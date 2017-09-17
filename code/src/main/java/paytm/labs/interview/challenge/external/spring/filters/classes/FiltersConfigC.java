package paytm.labs.interview.challenge.external.spring.filters.classes;

import javax.servlet.Filter;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import paytm.labs.interview.challenge.external.spring.filters.interfaces.FiltersConfigI;
import paytm.labs.interview.challenge.external.spring.security.interfaces.AuthenticationFactoryI;

@Component
public class FiltersConfigC implements FiltersConfigI {
	
	protected Filter m_authenticationFilter; 
	public FiltersConfigC (	ProviderManager authenticationManager, 
							AuthenticationFactoryI authenticationFactory) {
		m_authenticationFilter = new FilterJwtC (authenticationManager, authenticationFactory);
	}

	public void setFilters(HttpSecurity config) throws Exception {
		 config.addFilterBefore (m_authenticationFilter,  UsernamePasswordAuthenticationFilter.class);
	}
}