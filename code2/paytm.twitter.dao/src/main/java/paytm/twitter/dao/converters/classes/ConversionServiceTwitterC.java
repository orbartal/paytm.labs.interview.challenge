package paytm.twitter.dao.converters.classes;

import org.springframework.stereotype.Service;
import paytm.internal.services.classes.AbstractConversionServiceC;
import paytm.twitter.dao.converters.interfaces.ConversionServiceTwitterI;

@Service ("ConversionServiceTwitter")
public 	class ConversionServiceTwitterC 
		extends AbstractConversionServiceC 
		implements ConversionServiceTwitterI {

	public ConversionServiceTwitterC () {
		addConverter(new ConverterTwitterSearchC());
	}
}