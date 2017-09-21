package paytm.internal.api.uses.interfaces;

import paytm.internal.model.interfaces.QuerySubListLEI;
import paytm.internal.model.interfaces.SubListLEI;
import paytm.internal.model.interfaces.UserLEI;

public interface AdapterUserDaoI {
	public void create (UserLEI user) throws Exception;
	public UserLEI read (long id) throws Exception;
	public void update (long id, UserLEI user) throws Exception;
	public void delete (long id) throws Exception;
	public SubListLEI<UserLEI> read (QuerySubListLEI query) throws Exception;
	public UserLEI readByUserName(String name) throws Exception;
	public long count() throws Exception;
}