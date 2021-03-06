package paytm.spring.security.settings;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import paytm.spring.security.filters.interfaces.FiltersConfigI;

/**
 * Configuration class of the spring security: 
 * authentication and permission on files and resources.
 * 
 * @author Or Bartal
 */

@EnableGlobalMethodSecurity
@EnableWebSecurity
@Configuration
class WebSecureConfigC extends WebSecurityConfigurerAdapter {
	
	protected FiltersConfigI m_filtersConfig;

   public WebSecureConfigC(FiltersConfigI filtersConfig) {
		m_filtersConfig = filtersConfig;
	}

    //Enforce users authentication (login).
    @Override
    protected void configure (HttpSecurity http) throws Exception {
    	http.csrf().disable();
        //Config which pages are available for anonymous users and which require authentication.
        http.httpBasic().and().authorizeRequests().antMatchers(getPublicResources()).permitAll();
        http.httpBasic().and().authorizeRequests().anyRequest().authenticated();
        m_filtersConfig.setFilters(http.httpBasic().and());
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(getPublicResources());
    }

    protected String[] getPublicResources() {
		String[] arrPublicResources = {
				//The url of the site rool with links to swagger pages
				"/",
				
				//Swagger
				"favicon.ico",
				"/v2/api-docs", 
				"/configuration/ui", 
				"/swagger-resources/**", 
				"/configuration/security", 
				"/swagger-ui.html",
				"/webjars/**",
				
				//Allow access to the client app
				"/**/*.html", 
				"/**/*.js",  
				"/**/*.css",
				
				//get security token that enable access to all other server resources
				"/tokens/**"
		};
		return arrPublicResources;
	}
}