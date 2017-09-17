package paytm.labs.interview.challenge.external.spring.security.classes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import paytm.labs.interview.challenge.external.spring.security.interfaces.AuthenticationFactoryI;

@Component
public class AuthenticationFactoryC implements AuthenticationFactoryI {

	public Authentication get(ServletRequest request) throws Exception {
		String strJwt = getJwtAuthorization(request);
		Authentication auth1 = new JwtAuthenticationTokenC (strJwt);
		return auth1;
	}
		
	protected String getJwtAuthorization(ServletRequest request) throws Exception{
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String strJwt =  httpRequest.getHeader("Authorization");
        if (strJwt == null) {
            throw new InsufficientAuthenticationException("Authorization header not found");
        }
        return strJwt;
	}

}
