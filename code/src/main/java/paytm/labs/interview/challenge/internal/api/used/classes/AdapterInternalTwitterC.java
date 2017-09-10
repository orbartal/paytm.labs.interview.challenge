package paytm.labs.interview.challenge.internal.api.used.classes;

import org.springframework.stereotype.Service;

import paytm.labs.interview.challenge.internal.api.used.interfaces.AdapterInternalTwitterI;
import paytm.labs.interview.challenge.internal.model.interfaces.QuerySubListLEI;
import paytm.labs.interview.challenge.internal.model.interfaces.SearchTweetLEI;
import paytm.labs.interview.challenge.internal.model.interfaces.SubListLEI;
import paytm.labs.interview.challenge.internal.services.interfaces.TwitterInternalServiceI;
import twitter4j.TwitterException;

@Service("AdapterInternalTwitter")
public class AdapterInternalTwitterC implements AdapterInternalTwitterI {
	
	protected TwitterInternalServiceI m_twitterService;
	public AdapterInternalTwitterC (TwitterInternalServiceI twitterService) {
		m_twitterService = twitterService;
	}

	public SubListLEI<SearchTweetLEI> search(QuerySubListLEI querySubList, String text) throws TwitterException {
		return m_twitterService.search(querySubList, text);
	}
}