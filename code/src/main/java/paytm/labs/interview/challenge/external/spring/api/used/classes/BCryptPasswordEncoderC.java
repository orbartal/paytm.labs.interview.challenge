package paytm.labs.interview.challenge.external.spring.api.used.classes;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import paytm.labs.interview.challenge.internal.api.uses.interfaces.AdapterPasswordEncoderI;

@Component
public 	class BCryptPasswordEncoderC 
		extends BCryptPasswordEncoder 
		implements AdapterPasswordEncoderI
		{}
