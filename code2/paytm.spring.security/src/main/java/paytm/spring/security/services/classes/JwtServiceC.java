package paytm.spring.security.services.classes;

import java.security.PrivateKey;
import java.security.PublicKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import paytm.spring.security.converters.interfaces.ConversionServiceSecurityI;
import paytm.spring.security.model.classes.JwtAuthenticationTokenC;
import paytm.spring.security.services.interfaces.AsymmetricKeysStoreServiceI;
import paytm.spring.security.services.interfaces.JwtServiceI;
import paytm.spring.security.services.interfaces.SignerServiceI;



@Component
public class JwtServiceC implements JwtServiceI {

	protected ConversionServiceSecurityI m_conversionService;
	protected SignerServiceI m_signerService;
	protected AsymmetricKeysStoreServiceI m_asymmetricKeysStore;
	
	@Value("${key-id}")
    protected String m_keyId;
	
	public JwtServiceC(ConversionServiceSecurityI conversionService, SignerServiceI signerService, AsymmetricKeysStoreServiceI asymmetricKeysStore) {
		m_conversionService = conversionService;
		m_signerService = signerService;
		m_asymmetricKeysStore = asymmetricKeysStore;
	}

	public String userToJwt(UserDetails userD) throws Exception {
		JWTClaimsSet  claims = m_conversionService.convert(userD, JWTClaimsSet.class);
		PrivateKey privateKey = m_asymmetricKeysStore.getPrivateKey(getKeyId());
		String result = m_signerService.sign(claims.toString(), privateKey);
		return result;
	}

	public Authentication JwtToAuth(String strSignText) throws Exception {
		PublicKey publicKey = m_asymmetricKeysStore.getPublicKey(getKeyId());
		m_signerService.verify(strSignText, publicKey);
		SignedJWT signedJWT = SignedJWT.parse(strSignText);
		JWTClaimsSet claims = signedJWT.getJWTClaimsSet();
		UserDetails userD = m_conversionService.convert(claims, UserDetails.class);
		Authentication token = new JwtAuthenticationTokenC (userD, strSignText, userD.getAuthorities());
    	return token;
	}
	
	protected String getKeyId() {
		return m_keyId;
	}
}