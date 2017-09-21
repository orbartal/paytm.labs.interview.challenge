package paytm.spring.security.services.classes;

import java.security.PrivateKey;
import java.security.PublicKey;
import org.springframework.stereotype.Component;
import paytm.spring.security.services.interfaces.AsymmetricKeysStoreServiceI;
import paytm.spring.security.services.interfaces.AsymmetricKeysIOServiceI;
import paytm.spring.security.converters.interfaces.ConversionServiceSecurityI;

@Component
public class AsymmetricKeysStoreServiceC implements AsymmetricKeysStoreServiceI{
	
	protected AsymmetricKeysIOServiceI m_keysFileService;
	protected ConversionServiceSecurityI m_convertor;

	public AsymmetricKeysStoreServiceC(AsymmetricKeysIOServiceI keysFileService, ConversionServiceSecurityI convertor) {
		m_keysFileService = keysFileService;
		m_convertor = convertor;
	}
	public PublicKey getPublicKey (String strId) throws Exception{
		String strPublicKey = m_keysFileService.readPublicKey(strId);
		return m_convertor.convert(strPublicKey, PublicKey.class);
	}
	public PrivateKey getPrivateKey (String strId) throws Exception{
		String strPrivateKey = m_keysFileService.readPrivateKey(strId);
		return m_convertor.convert(strPrivateKey, PrivateKey.class);
	}
	public void addPublicKey (String strId, PublicKey publicKey) throws Exception{
		String strKey = m_convertor.convert(publicKey, String.class);
		m_keysFileService.writePublicKey(strId, strKey);
	}
	public void addPrivateKey (String strId, PrivateKey privateKey) throws Exception{
		String strKey = m_convertor.convert(privateKey, String.class);
		m_keysFileService.writePrivateKey(strId, strKey);
	}
	//////////////////////
	/*
	public void writeKeyPair (String strPath, KeyPair keyPair) throws Exception{
		writePrivateKey(strPath, keyPair.getPrivate());
		writePublicKey(strPath, keyPair.getPublic());
	}
	
	public KeyPair readKeyPair (String strPath) throws Exception{
		PrivateKey privateKey =  readPrivateKey(strPath);
		PublicKey publicKey =  readPublic(strPath);
		KeyPair result = new KeyPair(publicKey, privateKey);
		return result;
	}
	*/
}
