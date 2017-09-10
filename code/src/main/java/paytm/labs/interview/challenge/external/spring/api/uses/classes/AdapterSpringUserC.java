package paytm.labs.interview.challenge.external.spring.api.uses.classes;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import paytm.labs.interview.challenge.external.spring.api.uses.interfaces.AdapterSpringUserI;
import paytm.labs.interview.challenge.external.spring.converters.interfaces.ConversionServiceSpringI;
import paytm.labs.interview.challenge.external.spring.model.interfaces.UserUEI;
import paytm.labs.interview.challenge.internal.api.used.interfaces.AdapterInternalUserI;
import paytm.labs.interview.challenge.internal.model.interfaces.QuerySubListLEI;
import paytm.labs.interview.challenge.internal.model.interfaces.SubListLEI;
import paytm.labs.interview.challenge.internal.model.interfaces.UserLEI;

@Service("AdapterSpringUser")
public class AdapterSpringUserC implements AdapterSpringUserI {
	
	protected AdapterInternalUserI m_userService;
	protected ConversionServiceSpringI m_conversionService;
	public AdapterSpringUserC (
			AdapterInternalUserI userService, 
			ConversionServiceSpringI conversionService) {
		m_userService = userService;
		m_conversionService = conversionService;
	}
	public void create(UserUEI userUEI) throws Exception {
		UserLEI userLEI = m_conversionService.convert(userUEI, UserLEI.class);
		m_userService.create(userLEI);
	}
	public UserUEI read(Long id) throws Exception {
		UserLEI userLEI = m_userService.read(id);
		return m_conversionService.convert(userLEI, UserUEI.class);
	}
	public Page<UserUEI> read(Pageable pageable) throws Exception {
		QuerySubListLEI query = m_conversionService.convert(pageable, QuerySubListLEI.class);
		SubListLEI<UserLEI> subList  = m_userService.read(query);
		List<UserLEI> lstUsers1 = subList.getContent();
		List<UserUEI> lstUsers2 = m_conversionService.convertsToList(lstUsers1, UserUEI.class);
		Page<UserUEI> result = new PageImpl<UserUEI> (lstUsers2, pageable, subList.getTotal());
		return result;
	}
	public void update(UserUEI userUEI, Long id) throws Exception {
		UserLEI userLEI = m_conversionService.convert(userUEI, UserLEI.class);
		m_userService.update(id, userLEI);
	}
	public void delete(Long id) throws Exception {
		m_userService.delete(id);
	}
}