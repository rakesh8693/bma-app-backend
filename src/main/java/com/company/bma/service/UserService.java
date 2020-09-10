package com.company.bma.service;

import com.company.bma.model.User;

public interface UserService {
	
	void createUser(User user);

	User retrieveUserById(Integer id);

	void updateUser(Integer id,User user);

	void deleteUserById(Integer id);

}
