package paytm.labs.interview.challenge.external.hibernate.converters.classes;

import org.springframework.stereotype.Service;
import paytm.labs.interview.challenge.external.hibernate.converters.interfaces.ConversionServiceHibernateI;
import paytm.labs.interview.challenge.internal.converters.classes.AbstractConversionServiceC;

@Service ("ConversionServiceHibernate")
public 	class ConversionServiceHibernateC 
		extends AbstractConversionServiceC 
		implements ConversionServiceHibernateI {

	public ConversionServiceHibernateC () {
		addConverter(new ConverterToUserDEC());
		addConverter(new ConverterToUserLEI());
		addConverter(new ConverterToPageRequestC());
	}
}