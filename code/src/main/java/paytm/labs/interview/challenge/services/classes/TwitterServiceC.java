package paytm.labs.interview.challenge.services.classes;

import org.springframework.stereotype.Service;
import paytm.labs.interview.challenge.model.interfaces.QuerySubListI;
import paytm.labs.interview.challenge.model.interfaces.SearchItemI;
import paytm.labs.interview.challenge.model.interfaces.SubListI;
import paytm.labs.interview.challenge.persistent.interfaces.TwitterDataI;
import paytm.labs.interview.challenge.services.interfaces.TwitterServiceI;
import twitter4j.TwitterException;

@Service("TwitterService")
public class TwitterServiceC implements TwitterServiceI {
	
	protected TwitterDataI m_twitterApi = null;
	
	public TwitterServiceC (TwitterDataI twitterApi) {
		m_twitterApi = twitterApi;
	}

	public SubListI<SearchItemI>  search(QuerySubListI querySubList, String text) throws TwitterException {
		return m_twitterApi.search(querySubList, text);
	}
}