package paytm.spring.security.converters.classes;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTClaimsSet.Builder;

public class ConverterUserDetailsToJwtClaimsSetC implements Converter <UserDetails, JWTClaimsSet>{

	public JWTClaimsSet convert(UserDetails source) {
		Date dNow = new Date();
		Date dLater = new Date(dNow.getTime()+1000*60*60);
		Builder builder = new JWTClaimsSet.Builder()
	     .subject(source.getUsername())
	     .issuer("paytm")
	     .audience("interview")
	     .issueTime(dNow)
	     .expirationTime(dLater);
		addAuthorities (source, builder);
		JWTClaimsSet target = builder.build();
		return target;
	}
	
	protected void addAuthorities(UserDetails userD, Builder builder) {
		GrantedAuthority gaRole = userD.getAuthorities().iterator().next();
		String role = gaRole.getAuthority();
		builder.claim("role", role);
	}

}
