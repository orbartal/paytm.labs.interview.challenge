package paytm.labs.interview.challenge.persistent.classes;

import java.util.List;
import org.springframework.stereotype.Repository;
import paytm.labs.interview.challenge.converters.interfaces.ConversionServiceI;
import paytm.labs.interview.challenge.model.classes.SubListC;
import paytm.labs.interview.challenge.model.interfaces.QuerySubListI;
import paytm.labs.interview.challenge.model.interfaces.SearchItemI;
import paytm.labs.interview.challenge.model.interfaces.SubListI;
import paytm.labs.interview.challenge.persistent.interfaces.TwitterDataI;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

@Repository
public class TwitterApiC implements TwitterDataI {
	
	protected  Twitter m_twitterAPI;
	protected ConversionServiceI m_conversionService;
	
	public TwitterApiC (ConversionServiceI conversionService) {
		m_twitterAPI = TwitterFactory.getSingleton();
		m_conversionService = conversionService;
	}
	
	public SubListI <SearchItemI> search (QuerySubListI querySubList, String text) throws TwitterException {
	    Query query = getQuery(text, querySubList); new Query(text);
	    QueryResult result = m_twitterAPI.search(query);
	    List <Status>lstTwitts = result.getTweets();
	    List<SearchItemI> lstItems = m_conversionService.convertsToList
	    		(lstTwitts, SearchItemI.class);
	    return new SubListC<SearchItemI> (lstItems, result.getCount(), querySubList);
	}

	protected Query getQuery(String text, QuerySubListI querySubList) {
		Query query = new Query(text);
		query.setSinceId(querySubList.getStart());
		query.setCount(querySubList.getSize());
		return query;
	}
}
