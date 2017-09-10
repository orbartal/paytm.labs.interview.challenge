package paytm.labs.interview.challenge.external.spring.model.classes;

import paytm.labs.interview.challenge.external.spring.model.interfaces.UserUEI;

public class UserUEC implements UserUEI {

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
