package paytm.labs.interview.challenge.internal.services.classes;

import org.springframework.stereotype.Service;

import paytm.labs.interview.challenge.internal.api.uses.interfaces.AdapterTwitterDaoI;
import paytm.labs.interview.challenge.internal.model.interfaces.QuerySubListI;
import paytm.labs.interview.challenge.internal.model.interfaces.SearchItemI;
import paytm.labs.interview.challenge.internal.model.interfaces.SubListI;
import paytm.labs.interview.challenge.internal.services.interfaces.TwitterInternalServiceI;
import twitter4j.TwitterException;

@Service("TwitterService")
public class TwitterInternalServiceC implements TwitterInternalServiceI {
	
	protected AdapterTwitterDaoI m_twitterDao = null;
	
	public TwitterInternalServiceC (AdapterTwitterDaoI twitterApi) {
		m_twitterDao = twitterApi;
	}

	public SubListI<SearchItemI>  search(QuerySubListI querySubList, String text) throws TwitterException {
		return m_twitterDao.search(querySubList, text);
	}
}