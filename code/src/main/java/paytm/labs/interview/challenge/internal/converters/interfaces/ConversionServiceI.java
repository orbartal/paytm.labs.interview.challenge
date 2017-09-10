package paytm.labs.interview.challenge.internal.converters.interfaces;

import java.util.Collection;
import java.util.List;
import org.springframework.core.convert.ConversionService;

@SuppressWarnings("rawtypes")
public interface ConversionServiceI extends ConversionService {
	public <T> Collection<T> converts(Iterable source, Class<T> targetType);
	public <T> List<T> convertsToList(Iterable source, Class<T> targetType);
}