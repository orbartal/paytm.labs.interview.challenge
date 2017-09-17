package paytm.labs.interview.challenge.external.spring.security.interfaces;

import java.security.PrivateKey;
import java.security.PublicKey;

public interface AsymmetricKeysStoreServiceI {
	public PublicKey getPublicKey (String strPath) throws Exception;
	public PrivateKey getPrivateKey (String strPath) throws Exception;
	public void addPublicKey (String strPath, PublicKey publicKey) throws Exception;
	public void addPrivateKey (String strPath, PrivateKey privateKey) throws Exception;
}
