package paytm.spring.security.filters.interfaces;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface FiltersConfigI {
	public void setFilters (HttpSecurity config) throws Exception;
}
