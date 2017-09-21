package paytm.internal.model.classes;

import paytm.internal.model.interfaces.UserLEI;

public class UserLEC implements UserLEI {
	
	protected Long id;
	protected String name;
	protected String password;

	public Long getId() {
		return id;
  	}

	public void setId(Long value) {
		id = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String value) {
		name = value;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String value) {
		password = value;
	}
}
