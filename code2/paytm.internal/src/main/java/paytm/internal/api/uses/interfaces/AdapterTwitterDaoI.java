package paytm.internal.api.uses.interfaces;

import paytm.internal.model.interfaces.QuerySubListLEI;
import paytm.internal.model.interfaces.SearchTweetLEI;
import paytm.internal.model.interfaces.SubListLEI;

public interface AdapterTwitterDaoI {
	public SubListLEI<SearchTweetLEI> search(QuerySubListLEI querySubList, String text) throws Exception;
}