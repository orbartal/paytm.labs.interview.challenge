package paytm.spring.web.model.interfaces;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import paytm.spring.web.model.classes.UserUEC;

@JsonDeserialize(as = UserUEC.class)
public interface UserUEI {
	public Long getId();
	public String getName();
	public String getPassword();
	
	public void setId(Long id);
	public void setName(String name);
	public void setPassword(String name);
}