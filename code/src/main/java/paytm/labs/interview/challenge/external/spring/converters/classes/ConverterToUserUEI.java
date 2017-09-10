package paytm.labs.interview.challenge.external.spring.converters.classes;

import org.springframework.core.convert.converter.Converter;
import paytm.labs.interview.challenge.external.spring.model.interfaces.UserUEI;
import paytm.labs.interview.challenge.internal.model.classes.UserLEC;
import paytm.labs.interview.challenge.internal.model.interfaces.UserLEI;

public class ConverterToUserUEI implements Converter <UserUEI, UserLEI>{

	public UserLEI convert(UserUEI source) {
		UserLEI target = new UserLEC();
		target.setId(source.getId());
		target.setName(source.getName());
		return target;
	}



}