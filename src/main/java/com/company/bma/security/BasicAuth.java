package com.company.bma.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class BasicAuth extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;

	private static final String[] AUTH_WHITELIST = { "/swagger-ui.html", "/BMA-docs", "/BMA-docs/swagger-config",
			"/swagger-ui/**", "/h2-console/**", "/", "/console/**"};
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customAuthenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().disable();
		/*
		 * http.headers() .addHeaderWriter( new
		 * StaticHeadersWriter("Access-Control-Allow-Origin", "http://localhost:4200")
		 * );
		 */
		http.authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll().antMatchers(HttpMethod.OPTIONS, "/**")
				.permitAll().antMatchers(HttpMethod.POST, "/user").permitAll().antMatchers("/**").authenticated().and().httpBasic().and().csrf().disable();
		http.headers().frameOptions().disable();
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurerAdapter() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**").allowedOrigins("http://localhost:4200");
	        }
	    };
	}
	

}
