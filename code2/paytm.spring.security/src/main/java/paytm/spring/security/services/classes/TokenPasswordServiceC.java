package paytm.spring.security.services.classes;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import paytm.spring.security.services.interfaces.JwtServiceI;
import paytm.spring.security.services.interfaces.TokenPasswordServiceI;

@Component
public class TokenPasswordServiceC implements TokenPasswordServiceI {

	protected UserDetailsService m_usersDetailsService;
	protected JwtServiceI m_jwtService;
	protected PasswordEncoder m_passwordEncoder;
	
	public TokenPasswordServiceC (
			UserDetailsService usersDetailsService, 
			JwtServiceI jwtService, 
			PasswordEncoder passwordEncoder) {
		m_usersDetailsService = usersDetailsService;
		m_jwtService = jwtService;
		m_passwordEncoder = passwordEncoder;
	}
	
	public Authentication getAuth(String strJwt) throws Exception {
		return m_jwtService.JwtToAuth(strJwt);
	}
	
	@Override
	public String getToken(UsernamePasswordAuthenticationToken auth) throws Exception {
		String strUserName = auth.getName();
		String strPassword = (String)auth.getCredentials();
		return createToken (strUserName, strPassword);
	}
	
	protected String createToken(String username, String password) throws Exception {
		UserDetails userD = m_usersDetailsService.loadUserByUsername(username);
		if ((userD ==null) || (isInvalidePassword (password, userD))) { 
			throw new Exception ("Invalid username or password");
		}
		return m_jwtService.userToJwt(userD);
	}

	protected boolean isInvalidePassword(String password, UserDetails userD) {
		return !m_passwordEncoder.matches(password, userD.getPassword());
	}
}