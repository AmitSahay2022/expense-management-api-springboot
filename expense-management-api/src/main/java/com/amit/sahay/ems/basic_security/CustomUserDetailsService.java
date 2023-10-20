package com.amit.sahay.ems.basic_security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.amit.sahay.ems.entity.User;
import com.amit.sahay.ems.exception.UserNotFoundException;
import com.amit.sahay.ems.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
 private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository
		     .findByEmail(username)
		     .orElseThrow(()->new UserNotFoundException("user not found with email: "+username));
		
		return new org.springframework.security.core.userdetails.User(
				           user.getEmail(),
				           user.getPassword(),
				           new ArrayList<>()
				           );
		
	}
}
