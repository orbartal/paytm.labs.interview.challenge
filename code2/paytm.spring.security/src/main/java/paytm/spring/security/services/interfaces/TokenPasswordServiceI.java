package paytm.spring.security.services.interfaces;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import paytm.internal.api.share.interfaces.AdapterSecurityTokenI;

public interface TokenPasswordServiceI extends AdapterSecurityTokenI<Authentication, UsernamePasswordAuthenticationToken> {}
