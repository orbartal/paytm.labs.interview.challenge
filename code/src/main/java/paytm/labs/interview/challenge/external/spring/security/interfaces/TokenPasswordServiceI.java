package paytm.labs.interview.challenge.external.spring.security.interfaces;

public interface TokenPasswordServiceI extends TokenServiceI{
	public String createToken(String username, String password)  throws Exception;
}
