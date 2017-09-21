package paytm.spring.security.filters.classes;

import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import paytm.spring.security.converters.interfaces.ConversionServiceSecurityI;
import paytm.spring.security.filters.interfaces.AuthenticationFilterI;
import paytm.spring.security.filters.interfaces.FiltersConfigI;

@Component
public class FiltersConfigC implements FiltersConfigI {
	
	protected AuthenticationFilterI m_authenticationFilter; 
	public FiltersConfigC (	ProviderManager authenticationManager, ConversionServiceSecurityI converter) { //TODO
		m_authenticationFilter = new FilterAuthenticationC (authenticationManager, converter);
	}

	public void setFilters(HttpSecurity config) throws Exception {
		 config.addFilterBefore (m_authenticationFilter,  UsernamePasswordAuthenticationFilter.class);
	}
}