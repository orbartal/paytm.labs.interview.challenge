package paytm.spring.web.controllers;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import paytm.internal.model.interfaces.SearchTweetLEI;
import paytm.internal.model.interfaces.SubListLEI;
import paytm.spring.web.api.uses.interfaces.AdapterSpringTwitterI;


@RestController
@RequestMapping("/Twitter")
@Api(value = "Twitter", description = "Rest API for twitter api")

public 	class TwitterControllerC {
	
	protected AdapterSpringTwitterI m_twitterAdapter;
	public TwitterControllerC (AdapterSpringTwitterI twitterAdapter) {
		m_twitterAdapter = twitterAdapter;
	}
	
	@ApiOperation(value = "search posts in twitter")
	@RequestMapping(method = RequestMethod.GET, value = "search/{text}", produces = "application/json")
	public SubListLEI<SearchTweetLEI> search(
			@ApiParam(value = "The search term", required = true) @PathVariable  String text, 
			@ApiParam(value = "The search offset and size", required = false) Pageable pageable) 
			throws Exception {
		return m_twitterAdapter.search(pageable, text);
	}
}