package com.booking.ticket.app.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
	
	//CustomAuthenticationProvider customAuthenticationProvider;
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		//authenticationProvider(customAuthenticationProvider)
		.inMemoryAuthentication()
				.withUser("sankar").roles("ADMIN")
				.password("reddy").and()
				.withUser("mohan").password("reddy").roles("USER");
				
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		//http.antMatcher("/**").authorizeRequests().anyRequest().hasRole("USER").and().openidLogin();
			
		http.authorizeRequests().antMatchers("/api/tickets/ticket/1").hasRole("ADMIN")
		.anyRequest()
		.fullyAuthenticated()
		.and().httpBasic();
		http.csrf().disable();

	}


}
