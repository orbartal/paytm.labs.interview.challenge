package paytm.labs.interview.challenge.converters.classes;

import org.apache.commons.collections4.Transformer;
import org.springframework.core.convert.ConversionService;

public class ConversionTransformerC<I,O> implements Transformer<I,O> {

	protected ConversionService m_converter;
	protected Class<O> m_targetClass;
	public ConversionTransformerC (ConversionService converter, Class<O> targetClass) {
		m_converter = converter;
		m_targetClass = targetClass;
	}
	public O transform(I source) {
		return m_converter.convert(source, m_targetClass);
	}
}