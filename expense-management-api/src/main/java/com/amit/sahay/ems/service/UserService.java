package com.amit.sahay.ems.service;

import com.amit.sahay.ems.entity.User;

public interface UserService {
	User createUser(User user);

	User updateUser(long userId, User user);

	String deleteUser(long userId);

	User getUserDetails(long userId);
}
