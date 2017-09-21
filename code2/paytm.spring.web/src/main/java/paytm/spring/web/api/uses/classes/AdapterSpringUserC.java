package paytm.spring.web.api.uses.classes;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import paytm.internal.api.used.interfaces.AdapterInternalUserI;
import paytm.internal.model.interfaces.QuerySubListLEI;
import paytm.internal.model.interfaces.SubListLEI;
import paytm.internal.model.interfaces.UserLEI;
import paytm.spring.web.api.uses.interfaces.AdapterSpringUserI;
import paytm.spring.web.converters.interfaces.ConversionServiceWebI;
import paytm.spring.web.model.interfaces.UserUEI;

@Service("AdapterSpringUser")
public class AdapterSpringUserC implements AdapterSpringUserI {
	
	protected AdapterInternalUserI m_userService;
	protected ConversionServiceWebI m_conversionService;
	protected PasswordEncoder m_passwordEncoder;
	
	public AdapterSpringUserC (
			AdapterInternalUserI userService, 
			ConversionServiceWebI conversionService, 
			PasswordEncoder passwordEncoder) {
		m_userService = userService;
		m_conversionService = conversionService;
		m_passwordEncoder = passwordEncoder;
	}
	public void create(UserUEI userUEI) throws Exception {
		UserLEI userLEI = m_conversionService.convert(userUEI, UserLEI.class);
		userLEI.setPassword(m_passwordEncoder.encode(userLEI.getPassword()));
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