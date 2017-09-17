package paytm.labs.interview.challenge.internal.services.interfaces;

import paytm.labs.interview.challenge.internal.model.interfaces.QuerySubListLEI;
import paytm.labs.interview.challenge.internal.model.interfaces.SubListLEI;
import paytm.labs.interview.challenge.internal.model.interfaces.UserLEI;

public interface UserInternalServiceI {
	public void create(UserLEI user) throws Exception;
	public UserLEI read(Long id) throws Exception;
	public SubListLEI<UserLEI> read (QuerySubListLEI query) throws Exception;
	public void update(UserLEI user, Long id) throws Exception;
	public void delete(Long id) throws Exception;
	public UserLEI readByUserName(String name) throws Exception;
}