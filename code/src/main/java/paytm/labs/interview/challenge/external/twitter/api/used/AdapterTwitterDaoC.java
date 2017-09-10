package paytm.labs.interview.challenge.external.twitter.api.used;

import java.util.List;
import org.springframework.stereotype.Service;

import paytm.labs.interview.challenge.external.twitter.dao.interfaces.TwitterExternalDaoI;
import paytm.labs.interview.challenge.internal.api.uses.interfaces.AdapterTwitterDaoI;
import paytm.labs.interview.challenge.internal.converters.interfaces.ConversionServiceI;
import paytm.labs.interview.challenge.internal.model.classes.SubListC;
import paytm.labs.interview.challenge.internal.model.interfaces.QuerySubListI;
import paytm.labs.interview.challenge.internal.model.interfaces.SearchItemI;
import paytm.labs.interview.challenge.internal.model.interfaces.SubListI;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;

@Service("TwitterAdapterDaoC")
public class AdapterTwitterDaoC implements AdapterTwitterDaoI {

	protected TwitterExternalDaoI m_twitterDao;
	protected ConversionServiceI m_conversionService;
	public AdapterTwitterDaoC (
			TwitterExternalDaoI twitterExternalDao, 
			ConversionServiceI conversionService) {
		m_twitterDao = twitterExternalDao;
		m_conversionService = conversionService;
	}
	public SubListI<SearchItemI> search(QuerySubListI querySubList, String text) throws TwitterException {
		Query query =  getQuery(text, querySubList);
		QueryResult queryResult = m_twitterDao.search(query, text);
		List <Status>lstTwitts = queryResult.getTweets();
	    List<SearchItemI> lstItems = m_conversionService.convertsToList
	    		(lstTwitts, SearchItemI.class);
	    return new SubListC<SearchItemI> (lstItems, queryResult.getCount(), querySubList);
	}
	
	protected Query getQuery(String text, QuerySubListI querySubList) {
		Query query = new Query(text);
		query.setSinceId(querySubList.getStart());
		query.setCount(querySubList.getSize());
		return query;
	}
}
