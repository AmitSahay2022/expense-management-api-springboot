package com.amit.sahay.ems.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.amit.sahay.ems.entity.User;
import com.amit.sahay.ems.exception.UserAllReadyExistException;
import com.amit.sahay.ems.exception.UserNotFoundException;
import com.amit.sahay.ems.repository.UserRepository;
import com.amit.sahay.ems.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;
	
	private PasswordEncoder passwordEncoder;

	@Override
	public User createUser(User user) {
		if(userRepository.existsByEmail(user.getEmail())) {
			throw new UserAllReadyExistException("Email allready registered");
		}
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		return userRepository.save(user);
	}

	//Only user name,age and password can be updated
	@Override
	public User updateUser(User usr) {
		User user = getUserDetails();
				        		 
		user.setName(usr.getName().trim().length()>2 ? usr.getName() : user.getName());
		user.setAge(usr.getAge() > 0 ? usr.getAge() : user.getAge());
		
		String encodedPassword = passwordEncoder.encode(usr.getPassword());
		user.setPassword(encodedPassword);
		return userRepository.save(user);
	}

	@Override
	public String deleteUser() {
		User user = getUserDetails();
		userRepository.delete(user);
		return "User Deleted Successfully";
	}

	@Override
	public User getUserDetails() {
		// TODO Auto-generated method stub
		User user = getLoggedInUser();
		return user;
	}
	
	public User getLoggedInUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		return userRepository.findByEmail(email).get();
	}

}
