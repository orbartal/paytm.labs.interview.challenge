package paytm.labs.interview.challenge.external.hibernate.api.used;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import paytm.labs.interview.challenge.external.hibernate.converters.interfaces.ConversionServiceHibernateI;
import paytm.labs.interview.challenge.external.hibernate.model.classes.UserDEC;
import paytm.labs.interview.challenge.external.hibernate.repositories.UserRepositoryI;
import paytm.labs.interview.challenge.internal.api.uses.interfaces.AdapterUserDaoI;
import paytm.labs.interview.challenge.internal.model.classes.SubListLEC;
import paytm.labs.interview.challenge.internal.model.interfaces.QuerySubListLEI;
import paytm.labs.interview.challenge.internal.model.interfaces.SubListLEI;
import paytm.labs.interview.challenge.internal.model.interfaces.UserLEI;

@Service("AdapterUserDao")
public class AdapterUserDaoC implements AdapterUserDaoI {

	protected UserRepositoryI m_usersDao;
	protected ConversionServiceHibernateI m_conversionService;
	public AdapterUserDaoC (
			UserRepositoryI usersDao, 
			ConversionServiceHibernateI conversionService) {
		m_usersDao = usersDao;
		m_conversionService = conversionService;
	}
	public void create(UserLEI userLEI) throws Exception {
		UserDEC userDEI = m_conversionService.convert(userLEI, UserDEC.class);
		m_usersDao.save(userDEI);
	}
	public UserLEI read(long id) throws Exception {
		UserDEC userDEI = m_usersDao.findOne(id);
		return m_conversionService.convert(userDEI, UserLEI.class);
	}
	public void update(long id, UserLEI userLEI) throws Exception {
		UserDEC oldUserDEI = m_usersDao.findOne(id);
		oldUserDEI.setName(userLEI.getName());
		m_usersDao.save(oldUserDEI);
	}
	public void delete(long id) throws Exception {
		m_usersDao.delete(id);
	}
	public SubListLEI<UserLEI> read(QuerySubListLEI query) throws Exception {
		PageRequest page = m_conversionService.convert(query, PageRequest.class);
		Page<UserDEC> itrable = m_usersDao.findAll(page);
		long total = m_usersDao.count();
		List<UserLEI> lstUsers = m_conversionService.convertsToList(itrable, UserLEI.class);
		SubListLEI<UserLEI> result = new SubListLEC<UserLEI> (lstUsers, total, query);
		return result;
	}
}