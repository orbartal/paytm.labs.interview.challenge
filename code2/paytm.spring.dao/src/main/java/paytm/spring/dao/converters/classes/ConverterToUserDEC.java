package paytm.spring.dao.converters.classes;

import org.springframework.core.convert.converter.Converter;
import paytm.internal.model.interfaces.UserLEI;
import paytm.spring.dao.model.classes.UserDEC;

public class ConverterToUserDEC implements Converter <UserLEI, UserDEC>{

	public UserDEC convert(UserLEI source) {
		UserDEC target = new UserDEC();
		target.setName(source.getName());
		target.setPassword(source.getPassword());
		return target;
	}

	
}