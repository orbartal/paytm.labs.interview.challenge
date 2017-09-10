package paytm.labs.interview.challenge.internal.api.used.classes;

import paytm.labs.interview.challenge.internal.api.used.interfaces.AdapterInternalTwitterI;
import paytm.labs.interview.challenge.internal.model.interfaces.QuerySubListI;
import paytm.labs.interview.challenge.internal.model.interfaces.SearchItemI;
import paytm.labs.interview.challenge.internal.model.interfaces.SubListI;
import paytm.labs.interview.challenge.internal.services.interfaces.TwitterInternalServiceI;
import twitter4j.TwitterException;

public class AdapterInternalTwitterC implements AdapterInternalTwitterI {
	
	protected TwitterInternalServiceI m_twitterService;
	public AdapterInternalTwitterC (TwitterInternalServiceI twitterService) {
		m_twitterService = twitterService;
	}

	public SubListI<SearchItemI> search(QuerySubListI querySubList, String text) throws TwitterException {
		return m_twitterService.search(querySubList, text);
	}
}