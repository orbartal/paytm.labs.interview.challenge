package paytm.spring.security.services.interfaces;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtServiceI {
	public String userToJwt(UserDetails userD) throws Exception;
	public Authentication JwtToAuth(String strJwt) throws Exception;
}
