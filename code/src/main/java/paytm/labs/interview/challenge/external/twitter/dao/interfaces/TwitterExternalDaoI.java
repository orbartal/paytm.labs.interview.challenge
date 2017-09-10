package paytm.labs.interview.challenge.external.twitter.dao.interfaces;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.TwitterException;

public interface TwitterExternalDaoI {
	public QueryResult search(Query query, String text) throws TwitterException;
}