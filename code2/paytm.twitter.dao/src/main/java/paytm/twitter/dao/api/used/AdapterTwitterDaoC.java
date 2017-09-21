package paytm.twitter.dao.api.used;

import java.util.List;
import org.springframework.stereotype.Service;
import paytm.internal.api.uses.interfaces.AdapterTwitterDaoI;
import paytm.internal.model.classes.SubListLEC;
import paytm.internal.model.interfaces.QuerySubListLEI;
import paytm.internal.model.interfaces.SearchTweetLEI;
import paytm.internal.model.interfaces.SubListLEI;
import paytm.twitter.dao.converters.interfaces.ConversionServiceTwitterI;
import paytm.twitter.dao.dao.interfaces.TwitterExternalDaoI;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;

@Service("TwitterAdapterDaoC")
public class AdapterTwitterDaoC implements AdapterTwitterDaoI {

	protected TwitterExternalDaoI m_twitterDao;
	protected ConversionServiceTwitterI m_conversionService;
	public AdapterTwitterDaoC (
			TwitterExternalDaoI twitterExternalDao, 
			ConversionServiceTwitterI conversionService) {
		m_twitterDao = twitterExternalDao;
		m_conversionService = conversionService;
	}
	public SubListLEI<SearchTweetLEI> search(QuerySubListLEI querySubList, String text) throws TwitterException {
		Query query =  getQuery(text, querySubList);
		QueryResult queryResult = m_twitterDao.search(query, text);
		List <Status>lstTwitts = queryResult.getTweets();
	    List<SearchTweetLEI> lstItems = m_conversionService.convertsToList
	    		(lstTwitts, SearchTweetLEI.class);
	    return new SubListLEC<SearchTweetLEI> (lstItems, queryResult.getCount(), querySubList);
	}
	
	protected Query getQuery(String text, QuerySubListLEI querySubList) {
		Query query = new Query(text);
		query.setSinceId(querySubList.getStart());
		query.setCount(querySubList.getSize());
		return query;
	}
}
