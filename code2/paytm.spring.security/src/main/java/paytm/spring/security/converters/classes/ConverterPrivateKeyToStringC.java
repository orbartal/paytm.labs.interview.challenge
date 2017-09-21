package paytm.spring.security.converters.classes;

import java.security.PrivateKey;
import java.util.Base64.Encoder;
import org.springframework.core.convert.converter.Converter;

public class ConverterPrivateKeyToStringC implements Converter <PrivateKey, String>{

	@Override
	public String convert(PrivateKey source) {
		Encoder base4encoder = java.util.Base64.getEncoder();
		String target = base4encoder.encodeToString(source.getEncoded());
		return target;
	}

}
