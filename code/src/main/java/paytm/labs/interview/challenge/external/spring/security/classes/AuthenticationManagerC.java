package paytm.labs.interview.challenge.external.spring.security.classes;

import java.util.List;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationManagerC extends ProviderManager{

	public AuthenticationManagerC(List<AuthenticationProvider> providers) {
		super(providers);
	}

}
