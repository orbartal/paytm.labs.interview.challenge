package paytm.spring.web.api.uses.classes;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import paytm.internal.api.used.interfaces.AdapterInternalTwitterI;
import paytm.internal.model.interfaces.QuerySubListLEI;
import paytm.internal.model.interfaces.SearchTweetLEI;
import paytm.internal.model.interfaces.SubListLEI;
import paytm.spring.web.api.uses.interfaces.AdapterSpringTwitterI;
import paytm.spring.web.converters.interfaces.ConversionServiceWebI;

@Service("AdapterSpringTwitter")
public class AdapterSpringTwitterC implements AdapterSpringTwitterI {
	
	protected AdapterInternalTwitterI m_twitterService;
	protected ConversionServiceWebI m_conversionService;
	public AdapterSpringTwitterC (
			AdapterInternalTwitterI twitterService, 
			ConversionServiceWebI conversionService) {
		m_twitterService = twitterService;
		m_conversionService = conversionService;
	}

	public SubListLEI<SearchTweetLEI> search(Pageable pageable, String text) throws Exception {
		QuerySubListLEI querySubList = m_conversionService.convert(pageable, QuerySubListLEI.class);
		return m_twitterService.search(querySubList, text);
	}

}
