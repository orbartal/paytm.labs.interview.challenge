package paytm.labs.interview.challenge.external.twitter.converters.classes;

import org.springframework.stereotype.Service;
import paytm.labs.interview.challenge.external.twitter.converters.interfaces.ConversionServiceTwitterI;
import paytm.labs.interview.challenge.internal.converters.classes.AbstractConversionServiceC;

@Service ("ConversionServiceTwitter")
public 	class ConversionServiceTwitterC 
		extends AbstractConversionServiceC 
		implements ConversionServiceTwitterI {

	public ConversionServiceTwitterC () {
		addConverter(new ConverterTwitterSearchC());
	}
}