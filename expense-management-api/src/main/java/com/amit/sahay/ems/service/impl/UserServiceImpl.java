package com.amit.sahay.ems.service.impl;

import org.springframework.stereotype.Service;

import com.amit.sahay.ems.entity.User;
import com.amit.sahay.ems.repository.UserRepository;
import com.amit.sahay.ems.service.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		
		return userRepository.save(user);
	}

	//Only user name,age and password can be updated
	@Override
	public User updateUser(long userId, User usr) {
		User user = getUserDetails(userId);
				        		 
		user.setName(usr.getName());
		user.setAge(usr.getAge());
		user.setPassword(usr.getPassword());
		return userRepository.save(user);
	}

	@Override
	public String deleteUser(long userId) {
		User user = getUserDetails(userId);
		userRepository.delete(user);
		return "User Deleted Successfully";
	}

	@Override
	public User getUserDetails(long userId) {
		// TODO Auto-generated method stub
		User user = userRepository
				        .findById(userId)
				        .orElseThrow(()->new RuntimeException("User with id: "+userId+" not found"));
		return user;
	}

}
