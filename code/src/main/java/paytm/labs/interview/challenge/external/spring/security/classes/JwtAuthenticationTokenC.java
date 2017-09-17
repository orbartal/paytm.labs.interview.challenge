package paytm.labs.interview.challenge.external.spring.security.classes;

import java.util.Collection;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class JwtAuthenticationTokenC extends AbstractAuthenticationToken {
	protected String m_token;
	protected UserDetails m_user;
	public JwtAuthenticationTokenC(String credentials) {
		super(null);
		setAuthenticated(false);
		m_token = credentials;
	}
	
	public JwtAuthenticationTokenC(UserDetails principal, String credentials,
			Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		setAuthenticated(true);
		m_token = credentials;
		m_user = principal;
	}

	public String getCredentials() {
		return m_token;
	}

	public UserDetails getPrincipal() {
		return m_user;
	}
}