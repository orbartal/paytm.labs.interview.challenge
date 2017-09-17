package paytm.labs.interview.challenge.external.spring.security.interfaces;

import javax.servlet.ServletRequest;
import org.springframework.security.core.Authentication;

public interface AuthenticationFactoryI {
	public Authentication get(ServletRequest request) throws Exception;
}
