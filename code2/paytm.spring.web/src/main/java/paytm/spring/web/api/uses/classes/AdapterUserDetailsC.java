package paytm.spring.web.api.uses.classes;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import paytm.internal.api.used.interfaces.AdapterInternalUserI;
import paytm.internal.model.interfaces.UserLEI;
import paytm.spring.web.converters.interfaces.ConversionServiceWebI;

@Component
public class AdapterUserDetailsC implements UserDetailsService{
	
	protected AdapterInternalUserI m_userService;
	protected ConversionServiceWebI m_conversionService;
	
	public AdapterUserDetailsC (
			AdapterInternalUserI userService, 
			ConversionServiceWebI conversionService) {
		m_userService = userService;
		m_conversionService = conversionService;
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			UserLEI userLEI = m_userService.readByUserName(username);
			UserDetails userDetails = m_conversionService.convert(userLEI, UserDetails.class);
			return userDetails;
		} catch (Exception e) {
			throw new UsernameNotFoundException ("Faild to get user from server", e);
		}
	}

}
