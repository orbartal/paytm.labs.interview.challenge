package paytm.spring.dao.converters.classes;

import org.springframework.stereotype.Service;
import paytm.internal.services.classes.AbstractConversionServiceC;
import paytm.spring.dao.converters.interfaces.ConversionServiceHibernateI;

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