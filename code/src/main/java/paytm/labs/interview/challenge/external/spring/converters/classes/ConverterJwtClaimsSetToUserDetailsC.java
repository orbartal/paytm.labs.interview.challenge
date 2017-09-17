package paytm.labs.interview.challenge.external.spring.converters.classes;

import java.util.Collections;
import java.util.Set;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import com.nimbusds.jwt.JWTClaimsSet;

public class ConverterJwtClaimsSetToUserDetailsC implements Converter <JWTClaimsSet, UserDetails>{

	public UserDetails convert(JWTClaimsSet source) {
		String role = (String) source.getClaim("role");
		String name =  source.getSubject();
		Set<SimpleGrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority(role));
		UserDetails target = new User(name, "", authorities);
		return target;
	}
}