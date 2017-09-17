package paytm.labs.interview.challenge.external.hibernate.model.classes;

import javax.persistence.*;
import paytm.labs.interview.challenge.external.hibernate.model.interfaces.UserDEI;

@Entity
@Table(name = "users") 
public class UserDEC implements UserDEI{

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column (name = "id")
  private Long id;
  
  @Column (name = "name")
  private String name;
  
  @Column (name = "password")
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