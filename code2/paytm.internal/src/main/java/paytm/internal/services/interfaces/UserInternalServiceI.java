package paytm.internal.services.interfaces;

import paytm.internal.model.interfaces.QuerySubListLEI;
import paytm.internal.model.interfaces.SubListLEI;
import paytm.internal.model.interfaces.UserLEI;

public interface UserInternalServiceI {
	public void create(UserLEI user) throws Exception;
	public UserLEI read(Long id) throws Exception;
	public SubListLEI<UserLEI> read (QuerySubListLEI query) throws Exception;
	public void update(UserLEI user, Long id) throws Exception;
	public void delete(Long id) throws Exception;
	public UserLEI readByUserName(String name) throws Exception;
}