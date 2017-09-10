package paytm.labs.interview.challenge.external.spring.converters.classes;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Pageable;
import paytm.labs.interview.challenge.internal.model.classes.QuerySubListC;
import paytm.labs.interview.challenge.internal.model.interfaces.QuerySubListI;

public class ConverterSpringPageC implements Converter <Pageable, QuerySubListI>{

	public QuerySubListI convert(Pageable pageable) {
		return new QuerySubListC(pageable.getOffset(), pageable.getPageSize());
	}
}