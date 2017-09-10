package paytm.labs.interview.challenge.external.spring.converters.classes;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Pageable;
import paytm.labs.interview.challenge.internal.model.classes.QuerySubListLEC;
import paytm.labs.interview.challenge.internal.model.interfaces.QuerySubListLEI;

public class ConverterToPageable implements Converter <Pageable, QuerySubListLEI>{

	public QuerySubListLEI convert(Pageable pageable) {
		return new QuerySubListLEC(pageable.getOffset(), pageable.getPageSize());
	}
}