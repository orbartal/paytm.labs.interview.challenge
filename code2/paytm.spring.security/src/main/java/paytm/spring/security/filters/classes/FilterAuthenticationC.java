package paytm.spring.security.filters.classes;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import paytm.spring.security.converters.interfaces.ConversionServiceSecurityI;
import paytm.spring.security.filters.interfaces.AuthenticationFilterI;

public 	class FilterAuthenticationC 
		extends GenericFilterBean
		implements AuthenticationFilterI{

	protected ProviderManager m_authenticationManager;
	protected ConversionServiceSecurityI m_converter;
	
	public FilterAuthenticationC(ProviderManager authenticationManager, ConversionServiceSecurityI converter) {
 		m_authenticationManager = authenticationManager;
 		m_converter = converter;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException {
		try {
			Authentication auth1 = m_converter.convert(request, Authentication.class);
	        Authentication auth2 = m_authenticationManager.authenticate(auth1);
			SecurityContextHolder.getContext().setAuthentication(auth2);
			chain.doFilter(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		} 
	}
}