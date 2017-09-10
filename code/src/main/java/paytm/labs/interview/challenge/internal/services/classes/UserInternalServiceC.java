package paytm.labs.interview.challenge.internal.services.classes;

import org.springframework.stereotype.Service;
import paytm.labs.interview.challenge.internal.api.uses.interfaces.AdapterUserDaoI;
import paytm.labs.interview.challenge.internal.model.interfaces.QuerySubListLEI;
import paytm.labs.interview.challenge.internal.model.interfaces.SubListLEI;
import paytm.labs.interview.challenge.internal.model.interfaces.UserLEI;
import paytm.labs.interview.challenge.internal.services.interfaces.UserInternalServiceI;

@Service("UserInternalService")
public class UserInternalServiceC implements UserInternalServiceI {
	protected AdapterUserDaoI m_adapterUserDao;
	public UserInternalServiceC (AdapterUserDaoI adapterUserDao) {
		m_adapterUserDao = adapterUserDao;
	}
	public void create(UserLEI user) throws Exception {
		 m_adapterUserDao.create(user);
	}
	public UserLEI read(Long id) throws Exception {
		return m_adapterUserDao.read(id);
	}
	public SubListLEI<UserLEI> read(QuerySubListLEI query) throws Exception {
		return m_adapterUserDao.read(query);
	}
	public void update(UserLEI user, Long id) throws Exception {
		m_adapterUserDao.update(id, user);
	}
	public void delete(Long id) throws Exception {
		m_adapterUserDao.delete(id);
	}
}