package paytm.labs.interview.challenge.internal.api.used.interfaces;

import paytm.labs.interview.challenge.internal.model.interfaces.QuerySubListLEI;
import paytm.labs.interview.challenge.internal.model.interfaces.SubListLEI;
import paytm.labs.interview.challenge.internal.model.interfaces.UserLEI;

public interface AdapterInternalUserI {
	public void create (UserLEI user) throws Exception;
	public UserLEI read (long id) throws Exception;
	public void update (long id, UserLEI user) throws Exception;
	public void delete (long id) throws Exception;
	public SubListLEI<UserLEI> read (QuerySubListLEI query) throws Exception;
}