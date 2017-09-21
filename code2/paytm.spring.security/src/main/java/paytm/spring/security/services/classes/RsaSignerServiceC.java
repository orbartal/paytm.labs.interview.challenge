package paytm.spring.security.services.classes;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import org.springframework.stereotype.Component;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import paytm.spring.security.services.interfaces.SignerServiceI;

@Component
public class RsaSignerServiceC implements SignerServiceI {

	public String sign(String strText, PrivateKey privateKey) throws Exception {
		JWTClaimsSet claims = JWTClaimsSet.parse(strText);
		RSAPrivateKey rsaPrivateKey = (RSAPrivateKey)privateKey;
		return sign2(claims, rsaPrivateKey);
	}
	
	public void verify(String strSignText, PublicKey publicKey) throws Exception {
		SignedJWT signedJWT = SignedJWT.parse(strSignText);
		RSAPublicKey rsaPublicKey = (RSAPublicKey)publicKey;
		verify2(signedJWT, rsaPublicKey);
	}

	protected String sign2(JWTClaimsSet claims, RSAPrivateKey privateKey) throws Exception {
        JWSSigner signer = new RSASSASigner(privateKey);
        JWSHeader header = new JWSHeader(JWSAlgorithm.RS256);
        SignedJWT signedJWT = new SignedJWT(header,claims);
        signedJWT.sign(signer);
        return signedJWT.serialize();
	}

	protected void verify2 (SignedJWT signedJWT, RSAPublicKey publicKey) throws Exception {
	    JWSVerifier verifier = new RSASSAVerifier(publicKey);
	    boolean bSigne = signedJWT.verify(verifier);
	    if (!bSigne) {
	    	throw new Exception ("invalid sign");
	    }
	}	
}