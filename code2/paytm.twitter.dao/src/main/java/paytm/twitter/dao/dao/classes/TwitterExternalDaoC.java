package paytm.twitter.dao.dao.classes;

import org.springframework.stereotype.Repository;
import paytm.twitter.dao.dao.interfaces.TwitterExternalDaoI;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

@Repository
public class TwitterExternalDaoC implements TwitterExternalDaoI {

	protected  Twitter m_twitterApi;
	public TwitterExternalDaoC () {
		m_twitterApi = TwitterFactory.getSingleton();
	}
	
	public QueryResult search(Query query, String text) throws TwitterException {
		QueryResult result = m_twitterApi.search(query);
		return result;
	}

}
