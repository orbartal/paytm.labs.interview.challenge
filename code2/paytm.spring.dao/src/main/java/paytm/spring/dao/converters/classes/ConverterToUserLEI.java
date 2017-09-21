package paytm.spring.dao.converters.classes;

import org.springframework.core.convert.converter.Converter;
import paytm.internal.model.classes.UserLEC;
import paytm.internal.model.interfaces.UserLEI;
import paytm.spring.dao.model.interfaces.UserDEI;

public class ConverterToUserLEI implements Converter <UserDEI, UserLEI>{

	public UserLEI convert(UserDEI source) {
		UserLEI target = new UserLEC ();
		target.setId(source.getId());
		target.setName(source.getName());
		target.setPassword(source.getPassword());
		return target;
	}

	

	
}