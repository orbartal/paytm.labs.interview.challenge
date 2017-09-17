package paytm.labs.interview.challenge.external.spring.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import paytm.labs.interview.challenge.external.spring.security.interfaces.TokenPasswordServiceI;

@RestController
@RequestMapping("/tokens")
@Api(value = "Hello world", description = "Rest API for hello world")

public 	class SecurityTokenControllerC {
	
	protected TokenPasswordServiceI m_tokenPasswordService;
	
	public SecurityTokenControllerC(TokenPasswordServiceI tokenPasswordService) {
		m_tokenPasswordService = tokenPasswordService;
	}

	
	
	@ApiOperation(value = "Get hello world string")
	@RequestMapping(method = RequestMethod.GET, value = "password/{username}/{password}") //, produces =  MediaType.TEXT_PLAIN_VALUE
	public String get(	@ApiParam(value = "User name", required = true) @PathVariable  String username, 
						@ApiParam(value = "User password", required = true) @PathVariable  String password) throws Exception {
		String jwt = m_tokenPasswordService.createToken(username, password);
		return jwt;
	}
}