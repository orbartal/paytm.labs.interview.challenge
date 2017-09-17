package paytm.labs.interview.challenge.external.spring.security.classes;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import paytm.labs.interview.challenge.external.spring.security.interfaces.TokenServiceI;

@Component
public class JwtAuthenticationProviderC implements AuthenticationProvider {

	protected TokenServiceI m_tokenService;
	
	public JwtAuthenticationProviderC (TokenServiceI tokenService) {
		m_tokenService = tokenService;
	}
	
	public boolean supports(Class<?> authentication) {
		return (JwtAuthenticationTokenC.class.isAssignableFrom(authentication));
	}
	
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String strJwt =  getJwt(authentication);
		return getAuth(strJwt);
	}
	
	protected String getJwt(Authentication authentication) throws AuthenticationException{
    	Object credentials = authentication.getCredentials();
		if ((credentials==null) || (!(credentials instanceof  String))) {
			throw new AuthenticationCredentialsNotFoundException ("credentials==null");
		}else if (!(credentials instanceof  String)) {
			throw new BadCredentialsException (credentials+"");
		}
		return (String)credentials;
	}
	
	protected Authentication getAuth(String strJwt) {
    	try {
    		return m_tokenService.getAuth(strJwt);
		} catch (Exception e) {
			throw new AuthenticationServiceException (strJwt, e);
		}
	}
}