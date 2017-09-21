package paytm.internal.services.interfaces;

import java.util.List;
import org.springframework.core.convert.ConversionService;

public interface ConversionServiceI extends ConversionService {
	public <T> Iterable<T> converts(Iterable<?> source, Class<T> targetType);
	public <T> List<T> convertsToList(Iterable<?> source, Class<T> targetType);
}