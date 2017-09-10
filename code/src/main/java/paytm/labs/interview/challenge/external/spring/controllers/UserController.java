package paytm.labs.interview.challenge.external.spring.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import paytm.labs.interview.challenge.external.spring.api.uses.interfaces.AdapterSpringUserI;
import paytm.labs.interview.challenge.external.spring.model.interfaces.UserUEI;

@RestController
@RequestMapping("/users")
public class UserController {
	
  protected AdapterSpringUserI m_usersService;
  
  public UserController (AdapterSpringUserI usersService) {
	  m_usersService = usersService;
  }
  
  @RequestMapping(method = RequestMethod.GET)
  public Page<UserUEI> read(Pageable pageable) throws Exception {
	  return m_usersService.read(pageable);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public UserUEI read(@PathVariable Long id) throws Exception {
	  return m_usersService.read(id);
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public void create(@RequestBody UserUEI user) throws Exception {
	    m_usersService.create(user);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public void update(@RequestBody UserUEI user, @PathVariable Long id) throws Exception {
	    m_usersService.update(user, id);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable Long id) throws Exception {
	  m_usersService.delete(id);
  }
}