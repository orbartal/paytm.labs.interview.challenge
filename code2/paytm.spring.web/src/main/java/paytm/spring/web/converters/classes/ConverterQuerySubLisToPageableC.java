package paytm.spring.web.converters.classes;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Pageable;
import paytm.internal.model.classes.QuerySubListLEC;
import paytm.internal.model.interfaces.QuerySubListLEI;

public class ConverterQuerySubLisToPageableC implements Converter <Pageable, QuerySubListLEI>{

	public QuerySubListLEI convert(Pageable pageable) {
		return new QuerySubListLEC(pageable.getOffset(), pageable.getPageSize());
	}
}