package paytm.labs.interview.challenge.external.spring.model.interfaces;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import paytm.labs.interview.challenge.external.spring.model.classes.UserUEC;

@JsonDeserialize(as = UserUEC.class)
public interface UserUEI {
	public Long getId();
	public String getName();
	public String getPassword();
	
	public void setId(Long id);
	public void setName(String name);
	public void setPassword(String name);
}