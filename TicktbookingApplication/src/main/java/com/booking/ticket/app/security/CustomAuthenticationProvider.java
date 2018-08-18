package com.booking.ticket.app.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationProvider implements AuthenticationProvider  {

	User user=new User("sankar", "Reddy", "ADMIN");
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {

		String user_Name=authentication.getName();
		Object credential=authentication.getCredentials();
		System.out.println("credentials class: " + credential.getClass());
		if(!(credential instanceof String)){
		return null;
		}
		
		String password=credential.toString();
		if(!password.isEmpty()){
			throw new BadCredentialsException("Authentication failed for " + user_Name);
		}
	return authentication;
}
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
