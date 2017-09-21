package paytm.spring.web.controllers;

import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import paytm.internal.api.share.interfaces.AdapterSecurityTokenI;

@RestController
@RequestMapping("/tokens")
@Api(value = "Hello world", description = "Rest API for hello world")

public 	class SecurityTokenControllerC {
	
	protected AdapterSecurityTokenI<Authentication, UsernamePasswordAuthenticationToken> m_tokenService;
	
	public SecurityTokenControllerC(AdapterSecurityTokenI<Authentication, UsernamePasswordAuthenticationToken> tokenPasswordService) {
		m_tokenService = tokenPasswordService;
	}

	@ApiOperation(value = "Get hello world string")
	@RequestMapping(method = RequestMethod.GET, value = "password/{username}/{password}", produces =  MediaType.TEXT_PLAIN_VALUE)
	public String get(	@ApiParam(value = "User name", required = true) @PathVariable  String username, 
						@ApiParam(value = "User password", required = true) @PathVariable  String password) throws Exception {
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken (username, password, null);
		String token = m_tokenService.getToken(auth);
		return token;
	}
}