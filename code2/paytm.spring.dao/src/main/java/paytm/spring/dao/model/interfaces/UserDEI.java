package paytm.spring.dao.model.interfaces;

public interface UserDEI {
	public Long getId();
	public String getName();
	public String getPassword();
	
	public void setId(Long id);
	public void setName(String name);
	public void setPassword(String name);
}
