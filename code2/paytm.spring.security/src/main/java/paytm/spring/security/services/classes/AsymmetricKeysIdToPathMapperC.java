package paytm.spring.security.services.classes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import paytm.spring.security.services.interfaces.AsymmetricKeysIdToPathMapperI;

@Component
public class AsymmetricKeysIdToPathMapperC implements AsymmetricKeysIdToPathMapperI{
	
	final static String PRIVATE_FILE_EXTENSION = ".rsa.private";
	final static String PUBLIC_FILE_EXTENSION = ".rsa.public";
	final static String STORE_DIR_PATH = "keys//";
	
	@Value("${key-store-dir-path}")
    protected String m_keyStoreDirPath;
	
	@Override
	public String getPublicPath(String strId) {
		return getKeyStoreDirPath()+strId+PUBLIC_FILE_EXTENSION;
	}

	@Override
	public String getPrivatePath(String strId) {
		return getKeyStoreDirPath()+ strId+PRIVATE_FILE_EXTENSION;
	}
	
	protected String getKeyStoreDirPath() {
		if (m_keyStoreDirPath==null) {
			return STORE_DIR_PATH;
		}
		return m_keyStoreDirPath;
	}
}