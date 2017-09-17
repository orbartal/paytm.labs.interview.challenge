package paytm.labs.interview.challenge.internal.services.classes;

import org.springframework.stereotype.Service;

import paytm.labs.interview.challenge.internal.api.uses.interfaces.AdapterPasswordEncoderI;
import paytm.labs.interview.challenge.internal.api.uses.interfaces.AdapterUserDaoI;
import paytm.labs.interview.challenge.internal.model.classes.UserLEC;
import paytm.labs.interview.challenge.internal.model.interfaces.QuerySubListLEI;
import paytm.labs.interview.challenge.internal.model.interfaces.SubListLEI;
import paytm.labs.interview.challenge.internal.model.interfaces.UserLEI;
import paytm.labs.interview.challenge.internal.services.interfaces.UserInternalServiceI;

@Service("UserInternalService")
public class UserInternalServiceC implements UserInternalServiceI {
	
	protected AdapterUserDaoI m_adapterUserDao;
	protected AdapterPasswordEncoderI m_passwordEncoder;
	public UserInternalServiceC (AdapterUserDaoI adapterUserDao, AdapterPasswordEncoderI passwordEncoder) throws Exception {
		m_adapterUserDao = adapterUserDao;
		m_passwordEncoder = passwordEncoder;
		createAdminIfNotExist();
	}
	
	private void createAdminIfNotExist() throws Exception {
		long n = m_adapterUserDao.count();
		if (n==0) {
			UserLEI user = new UserLEC();
			user.setName("admin");
			String passwordE = m_passwordEncoder.encode("admin");
			user.setPassword(passwordE);
			m_adapterUserDao.create(user);
		}
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
	public UserLEI readByUserName(String name) throws Exception {
		return m_adapterUserDao.readByUserName(name);
	}
}