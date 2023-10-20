package com.amit.sahay.ems.service;

import com.amit.sahay.ems.entity.User;

public interface UserService {
	User createUser(User user);

	User updateUser(User user);

	String deleteUser();

	User getUserDetails();
}
