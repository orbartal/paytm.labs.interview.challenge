package paytm.labs.interview.challenge.internal.services.interfaces;

import paytm.labs.interview.challenge.internal.model.interfaces.QuerySubListLEI;
import paytm.labs.interview.challenge.internal.model.interfaces.SearchTweetLEI;
import paytm.labs.interview.challenge.internal.model.interfaces.SubListLEI;
import twitter4j.TwitterException;

public interface TwitterInternalServiceI {
	public SubListLEI<SearchTweetLEI> search(QuerySubListLEI querySubList, String text) throws TwitterException;
}
