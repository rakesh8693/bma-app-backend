package com.company.bma.service;

import com.company.bma.model.User;

public interface UserService {
	
	Void createUser(User user);

	User retrieveUserById(Integer id);

	Void updateUser(User user);

	Void deleteUserById(Integer id);

}
