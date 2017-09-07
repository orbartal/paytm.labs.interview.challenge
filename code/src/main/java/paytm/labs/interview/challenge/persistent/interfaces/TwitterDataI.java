package paytm.labs.interview.challenge.persistent.interfaces;

import paytm.labs.interview.challenge.model.interfaces.QuerySubListI;
import paytm.labs.interview.challenge.model.interfaces.SearchItemI;
import paytm.labs.interview.challenge.model.interfaces.SubListI;
import twitter4j.TwitterException;

public interface TwitterDataI {

	public SubListI<SearchItemI> search(QuerySubListI querySubList, String text) throws TwitterException;

}