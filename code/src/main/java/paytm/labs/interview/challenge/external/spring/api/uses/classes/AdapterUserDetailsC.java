package paytm.labs.interview.challenge.external.spring.api.uses.classes;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import paytm.labs.interview.challenge.external.spring.converters.interfaces.ConversionServiceSpringI;
import paytm.labs.interview.challenge.internal.api.used.interfaces.AdapterInternalUserI;
import paytm.labs.interview.challenge.internal.model.interfaces.UserLEI;

@Component
public class AdapterUserDetailsC implements UserDetailsService{
	
	protected AdapterInternalUserI m_userService;
	protected ConversionServiceSpringI m_conversionService;
	
	public AdapterUserDetailsC (
			AdapterInternalUserI userService, 
			ConversionServiceSpringI conversionService) {
		m_userService = userService;
		m_conversionService = conversionService;
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserLEI userLEI;
		try {
			userLEI = m_userService.readByUserName(username);
			UserDetails userDetails = m_conversionService.convert(userLEI, UserDetails.class);
			return userDetails;
		} catch (Exception e) {
			throw new UsernameNotFoundException ("Faild to get user from server", e);
		}
	}

}
