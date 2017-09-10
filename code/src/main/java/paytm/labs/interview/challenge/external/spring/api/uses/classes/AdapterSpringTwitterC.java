package paytm.labs.interview.challenge.external.spring.api.uses.classes;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import paytm.labs.interview.challenge.external.spring.api.uses.interfaces.AdapterSpringTwitterI;
import paytm.labs.interview.challenge.external.spring.converters.interfaces.ConversionServiceSpringI;
import paytm.labs.interview.challenge.internal.api.used.interfaces.AdapterInternalTwitterI;
import paytm.labs.interview.challenge.internal.model.interfaces.QuerySubListI;
import paytm.labs.interview.challenge.internal.model.interfaces.SearchItemI;
import paytm.labs.interview.challenge.internal.model.interfaces.SubListI;

@Service("TwitterSpringAdapter")
public class AdapterSpringTwitterC implements AdapterSpringTwitterI {
	
	protected AdapterInternalTwitterI m_twitterInternal;
	protected ConversionServiceSpringI m_conversionService;
	public AdapterSpringTwitterC (
			AdapterInternalTwitterI twitterService, 
			ConversionServiceSpringI conversionService) {
		m_twitterInternal = twitterService;
		m_conversionService = conversionService;
	}

	public SubListI<SearchItemI> search(Pageable pageable, String text) throws Exception {
		QuerySubListI querySubList = m_conversionService.convert(pageable, QuerySubListI.class);
		return m_twitterInternal.search(querySubList, text);
	}

}
