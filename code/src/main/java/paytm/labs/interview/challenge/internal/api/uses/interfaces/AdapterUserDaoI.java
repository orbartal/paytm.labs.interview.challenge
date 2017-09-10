package paytm.labs.interview.challenge.internal.api.uses.interfaces;

import paytm.labs.interview.challenge.internal.model.interfaces.QuerySubListLEI;
import paytm.labs.interview.challenge.internal.model.interfaces.SubListLEI;
import paytm.labs.interview.challenge.internal.model.interfaces.UserLEI;

public interface AdapterUserDaoI {
	public void create (UserLEI user) throws Exception;
	public UserLEI read (long id) throws Exception;
	public void update (long id, UserLEI user) throws Exception;
	public void delete (long id) throws Exception;
	public SubListLEI<UserLEI> read (QuerySubListLEI query) throws Exception;
}