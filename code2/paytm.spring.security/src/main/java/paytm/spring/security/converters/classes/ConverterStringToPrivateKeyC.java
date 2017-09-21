package paytm.spring.security.converters.classes;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import org.springframework.core.convert.converter.Converter;

public class ConverterStringToPrivateKeyC  implements Converter <String, PrivateKey>{

	@Override
	public PrivateKey convert(String source) {
		try {
			return convert2(source);
		}catch (Exception e) {
			return null; //TODO: check errors
		}
	}
	
	public PrivateKey convert2(String source) throws Exception {
		byte[] bytes = source.getBytes();
		bytes = java.util.Base64.getDecoder().decode(bytes);
		PKCS8EncodedKeySpec ks = new PKCS8EncodedKeySpec(bytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = kf.generatePrivate(ks);
		return privateKey;
	}
}