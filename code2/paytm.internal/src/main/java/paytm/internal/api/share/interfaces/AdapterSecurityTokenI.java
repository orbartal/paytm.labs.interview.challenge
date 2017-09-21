package paytm.internal.api.share.interfaces;

public interface AdapterSecurityTokenI<T, S> {
	public T getAuth (String strToken) throws Exception;
	public String getToken(S auth)  throws Exception;
}
