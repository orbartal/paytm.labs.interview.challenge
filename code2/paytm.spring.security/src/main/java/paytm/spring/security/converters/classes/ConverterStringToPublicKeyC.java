package paytm.spring.security.converters.classes;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import org.springframework.core.convert.converter.Converter;

public class ConverterStringToPublicKeyC implements Converter <String, PublicKey>{
	
	@Override
	public PublicKey convert(String source) {
		try {
			return convert2(source);
		}catch (Exception e) {
			return null; //TODO: check errors
		}
	}

	protected PublicKey convert2(String source) throws Exception {
		byte[] bytes = source.getBytes();
		bytes = java.util.Base64.getDecoder().decode(bytes);
		X509EncodedKeySpec ks = new X509EncodedKeySpec(bytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		PublicKey publicKey = kf.generatePublic(ks);
		return publicKey;
	}
}