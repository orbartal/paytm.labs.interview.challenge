package paytm.spring.security.converters.classes;

import org.springframework.stereotype.Service;
import paytm.internal.services.classes.AbstractConversionServiceC;
import paytm.spring.security.converters.interfaces.ConversionServiceSecurityI;

@Service ("ConversionServiceSecurity")
public 	class ConversionServiceSecurityC 
		extends AbstractConversionServiceC 
		implements ConversionServiceSecurityI {

	public ConversionServiceSecurityC () {
		addConverter(new ConverterUserLeiToUserDetailsC());
		addConverter(new ConverterJwtClaimsSetToUserDetailsC());
		addConverter(new ConverterUserDetailsToJwtClaimsSetC());
		addConverter(new ConverterServletRequestToAuthenticationC());
		
		addConverter(new ConverterStringToPublicKeyC());
		addConverter(new ConverterStringToPrivateKeyC());
		addConverter(new ConverterPublicKeyToStringC());
		addConverter(new ConverterPrivateKeyToStringC());
	}
}