package paytm.labs.interview.challenge.converters.interfaces;

import java.util.Collection;
import java.util.List;
import org.springframework.core.convert.ConversionService;

@SuppressWarnings("rawtypes")
public interface ConversionServiceI extends ConversionService {
	public <T> Collection<T> converts(Collection source, Class<T> targetType);
	public <T> List<T> convertsToList(Collection source, Class<T> targetType);
}