package paytm.internal.api.used.classes;

import org.springframework.stereotype.Service;
import paytm.internal.api.used.interfaces.AdapterInternalTwitterI;
import paytm.internal.model.interfaces.QuerySubListLEI;
import paytm.internal.model.interfaces.SearchTweetLEI;
import paytm.internal.model.interfaces.SubListLEI;
import paytm.internal.services.interfaces.TwitterInternalServiceI;

@Service("AdapterInternalTwitter")
public class AdapterInternalTwitterC implements AdapterInternalTwitterI {
	
	protected TwitterInternalServiceI m_twitterService;
	public AdapterInternalTwitterC (TwitterInternalServiceI twitterService) {
		m_twitterService = twitterService;
	}

	public SubListLEI<SearchTweetLEI> search(QuerySubListLEI querySubList, String text) throws Exception {
		return m_twitterService.search(querySubList, text);
	}
}