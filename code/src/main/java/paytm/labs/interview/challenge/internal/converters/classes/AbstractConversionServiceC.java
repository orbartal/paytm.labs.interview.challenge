package paytm.labs.interview.challenge.internal.converters.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.core.convert.support.GenericConversionService;
import paytm.labs.interview.challenge.internal.converters.interfaces.ConversionServiceI;

@SuppressWarnings({ "unchecked", "rawtypes" })
public abstract class AbstractConversionServiceC 
		extends GenericConversionService 
		implements ConversionServiceI {
	
	public <T> Collection<T> converts(Iterable source, Class<T> targetType) {
		ConversionTransformerC transformer = new ConversionTransformerC (this, targetType);
		Collection<T> result = CollectionUtils.collect(source, transformer);
		return result;
	}

	public <T> List<T> convertsToList(Iterable source, Class<T> targetType) {
		Collection<T> targetCol  = this.converts(source, targetType);
		if (targetCol instanceof List) {
			return (List<T>) targetCol;
		}
		List<T> result = new ArrayList<T>(targetCol);
		return result;
	}	
}