package paytm.spring.security.converters.classes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import paytm.spring.security.model.classes.JwtAuthenticationTokenC;

public class ConverterServletRequestToAuthenticationC implements Converter <ServletRequest, Authentication>{

	@Override
	public Authentication convert(ServletRequest source) {
		String strJwt;
		try {
			strJwt = getJwtAuthorization(source);
			Authentication auth1 = new JwtAuthenticationTokenC (strJwt);
			return auth1;
		} catch (Exception e) {
			return null;
		}
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