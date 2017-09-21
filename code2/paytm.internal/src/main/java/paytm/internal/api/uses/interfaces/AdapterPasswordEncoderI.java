package paytm.internal.api.uses.interfaces;

public interface AdapterPasswordEncoderI {
	public String encode(CharSequence rawPassword);
	public boolean matches(CharSequence rawPassword, String encodedPassword);
}
