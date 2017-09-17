package paytm.labs.interview.challenge.external.spring.security.classes;

import java.security.PrivateKey;
import java.security.PublicKey;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import paytm.labs.interview.challenge.external.spring.converters.interfaces.ConversionServiceSpringI;
import paytm.labs.interview.challenge.external.spring.security.interfaces.AsymmetricKeysStoreServiceI;
import paytm.labs.interview.challenge.external.spring.security.interfaces.JwtServiceI;
import paytm.labs.interview.challenge.external.spring.security.interfaces.SignerServiceI;

@Component
public class JwtServiceC implements JwtServiceI {

	final static String KEY_NAME = "a";
	protected ConversionServiceSpringI m_conversionService;
	protected SignerServiceI m_signerService;
	protected AsymmetricKeysStoreServiceI m_asymmetricKeysStore;
	
	public JwtServiceC(ConversionServiceSpringI conversionService, SignerServiceI signerService, AsymmetricKeysStoreServiceI asymmetricKeysStore) {
		m_conversionService = conversionService;
		m_signerService = signerService;
		m_asymmetricKeysStore = asymmetricKeysStore;
	}

	public String userToJwt(UserDetails userD) throws Exception {
		JWTClaimsSet  claims = m_conversionService.convert(userD, JWTClaimsSet.class);
		PrivateKey privateKey = m_asymmetricKeysStore.getPrivateKey(KEY_NAME);
		String result = m_signerService.sign(claims.toString(), privateKey);
		return result;
	}

	public Authentication JwtToAuth(String strSignText) throws Exception {
		PublicKey publicKey = m_asymmetricKeysStore.getPublicKey(KEY_NAME);
		m_signerService.verify(strSignText, publicKey);
		SignedJWT signedJWT = SignedJWT.parse(strSignText);
		JWTClaimsSet claims = signedJWT.getJWTClaimsSet();
		UserDetails userD = m_conversionService.convert(claims, UserDetails.class);
		JwtAuthenticationTokenC token = new JwtAuthenticationTokenC (userD, strSignText, userD.getAuthorities());
    	return token;
	}
}