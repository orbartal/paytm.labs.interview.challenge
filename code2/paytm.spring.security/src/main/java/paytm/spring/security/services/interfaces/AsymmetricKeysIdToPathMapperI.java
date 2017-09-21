package paytm.spring.security.services.interfaces;

public interface AsymmetricKeysIdToPathMapperI {
	public String getPublicPath(String id);
	public String getPrivatePath(String id);
}
