package paytm.labs.interview.challenge.external.spring.api.uses.classes;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import paytm.labs.interview.challenge.external.spring.api.uses.interfaces.AdapterSpringTwitterI;
import paytm.labs.interview.challenge.external.spring.converters.interfaces.ConversionServiceSpringI;
import paytm.labs.interview.challenge.internal.api.used.interfaces.AdapterInternalTwitterI;
import paytm.labs.interview.challenge.internal.model.interfaces.QuerySubListLEI;
import paytm.labs.interview.challenge.internal.model.interfaces.SearchTweetLEI;
import paytm.labs.interview.challenge.internal.model.interfaces.SubListLEI;

@Service("TwitterSpringAdapter")
public class AdapterSpringTwitterC implements AdapterSpringTwitterI {
	
	protected AdapterInternalTwitterI m_twitterService;
	protected ConversionServiceSpringI m_conversionService;
	public AdapterSpringTwitterC (
			AdapterInternalTwitterI twitterService, 
			ConversionServiceSpringI conversionService) {
		m_twitterService = twitterService;
		m_conversionService = conversionService;
	}

	public SubListLEI<SearchTweetLEI> search(Pageable pageable, String text) throws Exception {
		QuerySubListLEI querySubList = m_conversionService.convert(pageable, QuerySubListLEI.class);
		return m_twitterService.search(querySubList, text);
	}

}
