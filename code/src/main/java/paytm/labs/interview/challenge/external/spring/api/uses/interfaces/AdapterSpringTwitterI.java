package paytm.labs.interview.challenge.external.spring.api.uses.interfaces;

import org.springframework.data.domain.Pageable;
import paytm.labs.interview.challenge.internal.model.interfaces.SearchItemI;
import paytm.labs.interview.challenge.internal.model.interfaces.SubListI;

public interface AdapterSpringTwitterI {
	public SubListI<SearchItemI> search(Pageable pageable, String text) throws Exception;
}