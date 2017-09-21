package paytm.spring.web.converters.classes;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import paytm.internal.model.interfaces.UserLEI;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.Collections;
import java.util.Set;


public class ConverterUserLeiToUserDetailsC implements Converter <UserLEI, UserDetails>{

	public UserDetails convert(UserLEI source) {
		String role = "admin";
		Set<SimpleGrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority(role));
		UserDetails target = new User(source.getName(), source.getPassword(), authorities);
		return target;
	}
}