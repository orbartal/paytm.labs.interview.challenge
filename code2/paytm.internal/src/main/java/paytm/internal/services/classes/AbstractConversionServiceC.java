package paytm.internal.services.classes;

import java.util.ArrayList;
import java.util.List;
import paytm.internal.services.interfaces.ConversionServiceI;
import org.springframework.core.convert.support.GenericConversionService;

public abstract class AbstractConversionServiceC 
				extends GenericConversionService
				implements ConversionServiceI {
	
	public <T> Iterable<T> converts(Iterable<?> itSources, Class<T> targetType) {
		List<T> lstTargets = new ArrayList<T>();
		for (Object source : itSources) {
			try {
				T target = convert(source, targetType);
				lstTargets.add(target);
			}catch(Exception e) {
				//TODO
			}
		}
		return lstTargets;
	}

	public <T> List<T> convertsToList(Iterable<?> source, Class<T> targetType) {
		Iterable<T> itTarget  = this.converts(source, targetType);
		if (itTarget instanceof List) {
			return (List<T>) itTarget;
		}
		List<T> result = new ArrayList<T>();
		itTarget.forEach(result::add);
		return result;
	}	
}