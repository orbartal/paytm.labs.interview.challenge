package paytm.spring.web.converters.classes;

import org.springframework.core.convert.converter.Converter;
import paytm.internal.model.classes.UserLEC;
import paytm.internal.model.interfaces.UserLEI;
import paytm.spring.web.model.interfaces.UserUEI;


public class ConverterUserUeiToUserLeiC implements Converter <UserUEI, UserLEI>{

	public UserLEI convert(UserUEI source) {
		UserLEI target = new UserLEC();
		target.setId(source.getId());
		target.setName(source.getName());
		target.setPassword(source.getPassword());
		return target;
	}



}