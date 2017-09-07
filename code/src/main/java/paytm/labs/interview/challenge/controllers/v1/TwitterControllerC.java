package paytm.labs.interview.challenge.controllers.v1;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import paytm.labs.interview.challenge.model.classes.QuerySubListC;
import paytm.labs.interview.challenge.model.interfaces.QuerySubListI;
import paytm.labs.interview.challenge.model.interfaces.SearchItemI;
import paytm.labs.interview.challenge.model.interfaces.SubListI;
import paytm.labs.interview.challenge.services.interfaces.TwitterServiceI;

@RestController
@RequestMapping("/Twitter")
@Api(value = "Twitter", description = "Rest API for twitter api")

public 	class TwitterControllerC {
	
	protected TwitterServiceI m_twitterService;
	public TwitterControllerC (TwitterServiceI twitterService) {
		m_twitterService = twitterService;
	}
	
	@ApiOperation(value = "search posts in twitter")
	@RequestMapping(method = RequestMethod.GET, value = "search/{text}", produces = "application/json")
	public SubListI<SearchItemI> search(
			@ApiParam(value = "The search term", required = true) @PathVariable  String text, 
			@ApiParam(value = "The search offset and size", required = false) Pageable pageable) 
			throws Exception {
		QuerySubListI querySubList = new QuerySubListC(pageable.getOffset(), pageable.getPageSize());
		return m_twitterService.search(querySubList, text);
	}
}