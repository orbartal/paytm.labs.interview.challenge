package paytm.labs.interview.challenge.external.spring.filters.classes;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import paytm.labs.interview.challenge.external.spring.filters.interfaces.AuthenticationFilterI;
import paytm.labs.interview.challenge.external.spring.security.interfaces.AuthenticationFactoryI;

public 	class FilterJwtC 
		extends GenericFilterBean
		implements AuthenticationFilterI{

	protected ProviderManager m_authenticationManager;
	protected AuthenticationFactoryI m_authenticationFactory;
	
	public FilterJwtC(ProviderManager authenticationManager, AuthenticationFactoryI authenticationFactory) {
 		m_authenticationManager = authenticationManager;		
 		m_authenticationFactory = authenticationFactory;
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException {
		try {
			Authentication auth1 = m_authenticationFactory.get(request);
	        Authentication auth2 = m_authenticationManager.authenticate(auth1);
			SecurityContextHolder.getContext().setAuthentication(auth2);
			chain.doFilter(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		} 
	}
	
}