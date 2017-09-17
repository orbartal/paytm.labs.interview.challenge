package paytm.labs.interview.challenge.external.spring.security.interfaces;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtServiceI {
	public String userToJwt(UserDetails userD) throws Exception;
	///public UserDetails JwtToUserDetails(String strJwt);
	public Authentication JwtToAuth(String strJwt) throws Exception;
}
