package paytm.spring.web.api.used.classes;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import paytm.internal.api.uses.interfaces.AdapterPasswordEncoderI;

@Component
public 	class BCryptPasswordEncoderC 
		extends BCryptPasswordEncoder 
		implements AdapterPasswordEncoderI
		{}
