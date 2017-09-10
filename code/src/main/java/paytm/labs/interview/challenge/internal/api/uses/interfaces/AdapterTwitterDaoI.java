package paytm.labs.interview.challenge.internal.api.uses.interfaces;

import paytm.labs.interview.challenge.internal.model.interfaces.QuerySubListI;
import paytm.labs.interview.challenge.internal.model.interfaces.SearchItemI;
import paytm.labs.interview.challenge.internal.model.interfaces.SubListI;
import twitter4j.TwitterException;

public interface AdapterTwitterDaoI {
	public SubListI<SearchItemI> search(QuerySubListI querySubList, String text) throws TwitterException;
}