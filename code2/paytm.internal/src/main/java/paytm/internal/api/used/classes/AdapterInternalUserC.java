package paytm.internal.api.used.classes;

import org.springframework.stereotype.Service;
import paytm.internal.api.used.interfaces.AdapterInternalUserI;
import paytm.internal.model.interfaces.QuerySubListLEI;
import paytm.internal.model.interfaces.SubListLEI;
import paytm.internal.model.interfaces.UserLEI;
import paytm.internal.services.interfaces.UserInternalServiceI;

@Service("AdapterInternalUser")
public class AdapterInternalUserC implements AdapterInternalUserI {

	protected UserInternalServiceI m_userService;
	
	public AdapterInternalUserC (UserInternalServiceI userService) {
		m_userService=userService;
	}
	
	public void create(UserLEI user) throws Exception {
		m_userService.create(user);
	}
	public UserLEI read(long id) throws Exception {
		return m_userService.read(id);
	}
	public void update(long id, UserLEI user) throws Exception {
		m_userService.update(user, id);
	}
	public void delete(long id) throws Exception {
		m_userService.delete(id);
	}
	public SubListLEI<UserLEI> read(QuerySubListLEI query) throws Exception {
		return m_userService.read(query);
	}

	public UserLEI readByUserName(String name) throws Exception {
		return m_userService.readByUserName(name);
	}
}