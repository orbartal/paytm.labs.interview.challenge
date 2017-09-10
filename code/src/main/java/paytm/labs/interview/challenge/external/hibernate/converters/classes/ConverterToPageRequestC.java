package paytm.labs.interview.challenge.external.hibernate.converters.classes;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.PageRequest;
import paytm.labs.interview.challenge.internal.model.classes.QuerySubListLEC;

public class ConverterToPageRequestC implements Converter <QuerySubListLEC, PageRequest>{

	public PageRequest convert(QuerySubListLEC source) {
		int pageNumber = 0; //TODO
		PageRequest target = new PageRequest (pageNumber, source.getSize());
		return target;
	}
}