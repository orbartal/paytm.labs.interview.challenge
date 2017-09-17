package paytm.labs.interview.challenge.external.spring.converters.classes;

import org.springframework.core.convert.converter.Converter;
import paytm.labs.interview.challenge.external.spring.model.classes.UserUEC;
import paytm.labs.interview.challenge.external.spring.model.interfaces.UserUEI;
import paytm.labs.interview.challenge.internal.model.interfaces.UserLEI;

public class ConverterUserLeiToUserUeiC implements Converter <UserLEI, UserUEI>{

	public UserUEI convert(UserLEI source) {
		UserUEI target = new UserUEC();
		target.setId(source.getId());
		target.setName(source.getName());
		target.setPassword(null); //Client need to know nothing about the password
		return target;
	}
}