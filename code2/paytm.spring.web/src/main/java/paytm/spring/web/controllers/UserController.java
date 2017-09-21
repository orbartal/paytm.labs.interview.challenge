package paytm.spring.web.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import paytm.spring.web.api.uses.interfaces.AdapterSpringUserI;
import paytm.spring.web.model.interfaces.UserUEI;

@RestController
@RequestMapping("/rest/users")
public class UserController {
	
  protected AdapterSpringUserI m_usersService;
  
  public UserController (AdapterSpringUserI usersService) {
	  m_usersService = usersService;
  }
  
  @RequestMapping(method = RequestMethod.GET, produces = "application/json")
  public Page<UserUEI> read(Pageable pageable) throws Exception {
	  return m_usersService.read(pageable);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
  public UserUEI read(@PathVariable Long id) throws Exception {
	  return m_usersService.read(id);
  }
  
  @RequestMapping(method = RequestMethod.POST, produces = "application/json")
  public void create(@RequestBody UserUEI user) throws Exception {
	    m_usersService.create(user);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
  public void update(@RequestBody UserUEI user, @PathVariable Long id) throws Exception {
	    m_usersService.update(user, id);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
  public void delete(@PathVariable Long id) throws Exception {
	  m_usersService.delete(id);
  }
}