package paytm.spring.web.converters.classes;

import org.springframework.stereotype.Service;
import paytm.internal.services.classes.AbstractConversionServiceC;
import paytm.spring.web.converters.interfaces.ConversionServiceWebI;

@Service ("ConversionServiceWeb")
public 	class ConversionServiceWebC 
		extends AbstractConversionServiceC 
		implements ConversionServiceWebI {

	public ConversionServiceWebC () {
		addConverter(new ConverterQuerySubLisToPageableC());
		addConverter(new ConverterUserLeiToUserUeiC());
		addConverter(new ConverterUserUeiToUserLeiC());
		addConverter(new ConverterUserLeiToUserDetailsC());
	}
}