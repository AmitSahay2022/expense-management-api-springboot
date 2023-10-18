package com.amit.sahay.ems.service.impl;

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

	@Override
	public User createUser(User user) {
		if(userRepository.existsByEmail(user.getEmail())) {
			throw new UserAllReadyExistException("Email allready registered");
		}
		
		return userRepository.save(user);
	}

	//Only user name,age and password can be updated
	@Override
	public User updateUser(long userId, User usr) {
		User user = getUserDetails(userId);
				        		 
		user.setName(usr.getName().trim().length()>2 ? usr.getName() : user.getName());
		user.setAge(usr.getAge() > 0 ? usr.getAge() : user.getAge());
		user.setPassword(usr.getPassword().trim().length() >= 4 ? usr.getPassword() : user.getPassword());
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
				        .orElseThrow(()->new UserNotFoundException("User with id: "+userId+" not found"));
		return user;
	}

}
