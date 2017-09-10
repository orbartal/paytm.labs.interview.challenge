package paytm.labs.interview.challenge.external.spring.api.uses.interfaces;

import org.springframework.data.domain.Pageable;
import paytm.labs.interview.challenge.internal.model.interfaces.SearchTweetLEI;
import paytm.labs.interview.challenge.internal.model.interfaces.SubListLEI;

public interface AdapterSpringTwitterI {
	public SubListLEI<SearchTweetLEI> search(Pageable pageable, String text) throws Exception;
}