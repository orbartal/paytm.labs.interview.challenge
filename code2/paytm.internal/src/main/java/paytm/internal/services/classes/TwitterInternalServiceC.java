package paytm.internal.services.classes;

import org.springframework.stereotype.Service;

import paytm.internal.api.uses.interfaces.AdapterTwitterDaoI;
import paytm.internal.model.interfaces.QuerySubListLEI;
import paytm.internal.model.interfaces.SearchTweetLEI;
import paytm.internal.model.interfaces.SubListLEI;
import paytm.internal.services.interfaces.TwitterInternalServiceI;


@Service("TwitterInternalService")
public class TwitterInternalServiceC implements TwitterInternalServiceI {
	
	protected AdapterTwitterDaoI m_twitterDao = null;
	
	public TwitterInternalServiceC (AdapterTwitterDaoI twitterApi) {
		m_twitterDao = twitterApi;
	}

	public SubListLEI<SearchTweetLEI> search (QuerySubListLEI querySubList, String text) throws Exception {
		return m_twitterDao.search(querySubList, text);
	}
}