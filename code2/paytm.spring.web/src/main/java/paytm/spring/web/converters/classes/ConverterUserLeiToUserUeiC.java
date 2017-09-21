package paytm.spring.web.converters.classes;

import org.springframework.core.convert.converter.Converter;
import paytm.internal.model.interfaces.UserLEI;
import paytm.spring.web.model.classes.UserUEC;
import paytm.spring.web.model.interfaces.UserUEI;

public class ConverterUserLeiToUserUeiC implements Converter <UserLEI, UserUEI>{

	public UserUEI convert(UserLEI source) {
		UserUEI target = new UserUEC();
		target.setId(source.getId());
		target.setName(source.getName());
		target.setPassword(null); //Client need to know nothing about the password
		return target;
	}
}