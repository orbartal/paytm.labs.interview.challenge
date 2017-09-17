package paytm.labs.interview.challenge.external.hibernate.converters.classes;

import org.springframework.core.convert.converter.Converter;
import paytm.labs.interview.challenge.external.hibernate.model.classes.UserDEC;
import paytm.labs.interview.challenge.internal.model.interfaces.UserLEI;

public class ConverterToUserDEC implements Converter <UserLEI, UserDEC>{

	public UserDEC convert(UserLEI source) {
		UserDEC target = new UserDEC();
		target.setName(source.getName());
		target.setPassword(source.getPassword());
		return target;
	}

	
}