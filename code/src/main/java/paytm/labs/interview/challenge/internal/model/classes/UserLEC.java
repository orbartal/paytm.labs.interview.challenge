package paytm.labs.interview.challenge.internal.model.classes;

import paytm.labs.interview.challenge.internal.model.interfaces.UserLEI;

public class UserLEC implements UserLEI {
	
	protected Long id;
	protected String name;

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
}
