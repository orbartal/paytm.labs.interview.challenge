package paytm.spring.web.api.uses.interfaces;

import org.springframework.data.domain.Pageable;
import paytm.internal.model.interfaces.SearchTweetLEI;
import paytm.internal.model.interfaces.SubListLEI;

public interface AdapterSpringTwitterI {
	public SubListLEI<SearchTweetLEI> search(Pageable pageable, String text) throws Exception;
}