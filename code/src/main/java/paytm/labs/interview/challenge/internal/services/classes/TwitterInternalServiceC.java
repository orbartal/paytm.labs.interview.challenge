package paytm.labs.interview.challenge.internal.services.classes;

import org.springframework.stereotype.Service;

import paytm.labs.interview.challenge.internal.api.uses.interfaces.AdapterTwitterDaoI;
import paytm.labs.interview.challenge.internal.model.interfaces.QuerySubListLEI;
import paytm.labs.interview.challenge.internal.model.interfaces.SearchTweetLEI;
import paytm.labs.interview.challenge.internal.model.interfaces.SubListLEI;
import paytm.labs.interview.challenge.internal.services.interfaces.TwitterInternalServiceI;
import twitter4j.TwitterException;

@Service("TwitterInternalService")
public class TwitterInternalServiceC implements TwitterInternalServiceI {
	
	protected AdapterTwitterDaoI m_twitterDao = null;
	
	public TwitterInternalServiceC (AdapterTwitterDaoI twitterApi) {
		m_twitterDao = twitterApi;
	}

	public SubListLEI<SearchTweetLEI>  search(QuerySubListLEI querySubList, String text) throws TwitterException {
		return m_twitterDao.search(querySubList, text);
	}
}