package paytm.labs.interview.challenge.external.hibernate.converters.classes;

import org.springframework.core.convert.converter.Converter;
import paytm.labs.interview.challenge.external.hibernate.model.interfaces.UserDEI;
import paytm.labs.interview.challenge.internal.model.classes.UserLEC;
import paytm.labs.interview.challenge.internal.model.interfaces.UserLEI;

public class ConverterToUserLEI implements Converter <UserDEI, UserLEI>{

	public UserLEI convert(UserDEI source) {
		UserLEI target = new UserLEC ();
		target.setId(source.getId());
		target.setName(source.getName());
		return target;
	}

	

	
}