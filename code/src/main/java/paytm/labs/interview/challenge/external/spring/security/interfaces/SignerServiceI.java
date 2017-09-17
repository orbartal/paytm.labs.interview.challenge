package paytm.labs.interview.challenge.external.spring.security.interfaces;

import java.security.PrivateKey;
import java.security.PublicKey;

public interface SignerServiceI {
	public void verify (String strSignText, PublicKey publicKey) throws Exception;
	public String sign (String strText, PrivateKey privateKey) throws Exception;
}
