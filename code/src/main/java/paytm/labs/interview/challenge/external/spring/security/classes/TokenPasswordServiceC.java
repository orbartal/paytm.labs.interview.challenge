package paytm.labs.interview.challenge.external.spring.security.classes;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import paytm.labs.interview.challenge.external.spring.security.interfaces.JwtServiceI;
import paytm.labs.interview.challenge.external.spring.security.interfaces.TokenPasswordServiceI;

@Component
public class TokenPasswordServiceC implements TokenPasswordServiceI {

	protected UserDetailsService m_usersDetailsService;
	protected JwtServiceI m_jwtService;
	protected PasswordEncoder m_passwordEncoder;
	
	public TokenPasswordServiceC (UserDetailsService usersDetailsService, JwtServiceI jwtService, PasswordEncoder passwordEncoder) {
		m_usersDetailsService = usersDetailsService;
		m_jwtService = jwtService;
		m_passwordEncoder = passwordEncoder;
	}
	
	public Authentication getAuth(String strJwt) throws Exception {
		return m_jwtService.JwtToAuth(strJwt);
	}
	
	public String createToken(String username, String password) throws Exception {
		UserDetails userD = m_usersDetailsService.loadUserByUsername(username);
		if ((userD ==null) || 
				(!m_passwordEncoder.matches(password, userD.getPassword()))
			) { //Replace with a check on hash passwords
			throw new Exception ("Invalid username or password");
		}
		return m_jwtService.userToJwt(userD);
	}
}