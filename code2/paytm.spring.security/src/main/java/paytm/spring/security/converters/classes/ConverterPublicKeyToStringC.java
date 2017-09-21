package paytm.spring.security.converters.classes;

import java.security.PublicKey;
import java.util.Base64.Encoder;

import org.springframework.core.convert.converter.Converter;

public class ConverterPublicKeyToStringC implements Converter <PublicKey, String>{

	@Override
	public String convert(PublicKey source) {
		Encoder base4encoder = java.util.Base64.getEncoder();
		String target = base4encoder.encodeToString(source.getEncoded());
		return target;
	}

}
