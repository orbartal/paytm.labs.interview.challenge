package paytm.labs.interview.challenge.controllers.classes.rest.v1;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/HelloWorld")
@Api(value = "hello world", description = "Rest API for hello world")

public 	class HelloWorldControllerC {
	
	@ApiOperation(value = "crud: get all wikis in the site")
	@RequestMapping(method = RequestMethod.GET, produces =  MediaType.TEXT_PLAIN_VALUE)
	public String get() throws Exception {
		return "Hello World";
	}
}