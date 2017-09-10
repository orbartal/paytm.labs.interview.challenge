package paytm.labs.interview.challenge.external.spring.converters.classes;

import org.springframework.stereotype.Service;
import paytm.labs.interview.challenge.external.spring.converters.interfaces.ConversionServiceSpringI;
import paytm.labs.interview.challenge.internal.converters.classes.AbstractConversionServiceC;

@Service ("ConversionServiceSpring")
public 	class ConversionServiceSpringC 
		extends AbstractConversionServiceC 
		implements ConversionServiceSpringI {

	public ConversionServiceSpringC () {
		addConverter(new ConverterToPageable());
		addConverter(new ConverterToUserLEI());
		addConverter(new ConverterToUserUEI());
	}
}