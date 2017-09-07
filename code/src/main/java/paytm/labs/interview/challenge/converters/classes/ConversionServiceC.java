package paytm.labs.interview.challenge.converters.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Service;

import paytm.labs.interview.challenge.converters.interfaces.ConversionServiceI;

@Service ("ConversionService")
@SuppressWarnings({ "unchecked", "rawtypes" })
public 	class ConversionServiceC 
		extends GenericConversionService 
		implements ConversionServiceI {

	public ConversionServiceC () {
		this.addConverter(new ConverterTwitterSearch());
	}
	
	public <T> Collection<T> converts(Collection source, Class<T> targetType) {
		ConversionTransformerC transformer = new ConversionTransformerC (this, targetType);
		Collection<T> result = CollectionUtils.collect(source, transformer);
		return result;
	}

	public <T> List<T> convertsToList(Collection source, Class<T> targetType) {
		Collection<T> targetCol  = this.converts(source, targetType);
		if (targetCol instanceof List) {
			return (List<T>) targetCol;
		}
		List<T> result = new ArrayList<T>(targetCol);
		return result;
	}	
}