package paytm.labs.interview.challenge.external.spring.security.interfaces;

import org.springframework.security.core.Authentication;

public interface TokenServiceI {
	public Authentication getAuth (String strJwt) throws Exception;
}
