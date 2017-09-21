package paytm.spring.web.api.uses.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import paytm.spring.web.model.interfaces.UserUEI;

public interface AdapterSpringUserI {
	public void create(UserUEI user) throws Exception;
	public UserUEI read(Long id) throws Exception;
	public Page<UserUEI> read (Pageable pageable) throws Exception;
	public void update(UserUEI user, Long id) throws Exception;
	public void delete(Long id) throws Exception;
}