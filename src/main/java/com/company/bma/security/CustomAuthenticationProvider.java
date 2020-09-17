package com.company.bma.security;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.company.bma.model.User;
import com.company.bma.repository.UserRepository;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class CustomAuthenticationProvider implements AuthenticationProvider {
 
	@Autowired
	private UserRepository userRepository;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        Optional<User> user = userRepository.findByUserNameAndPassword(name, password);
        if(user.isPresent()) {
        	log.info("----CustomAuthenticationProvider---"+user.get().getUserName());
        	ArrayList<GrantedAuthority> rolelist =new ArrayList<>();
        	rolelist.add(new SimpleGrantedAuthority(user.get().getRoleType().toString()));
        	return new UsernamePasswordAuthenticationToken(
                    user.get().getUserName(), user.get().getPassword(),rolelist);
        }else {
        	log.info("----CustomAuthenticationProvider---No user Found");
        	return null;
        }
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
