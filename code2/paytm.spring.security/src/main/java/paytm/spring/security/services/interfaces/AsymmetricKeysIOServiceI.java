package paytm.spring.security.services.interfaces;

public interface AsymmetricKeysIOServiceI {
	public String readPublicKey(String strId) throws Exception;
	public String readPrivateKey(String strId) throws Exception;
	public void writePublicKey(String strId, String strPublicKey) throws Exception;
	public void writePrivateKey(String strId, String strPrivateKey) throws Exception;
}
