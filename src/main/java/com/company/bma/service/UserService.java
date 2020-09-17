package com.company.bma.service;

import java.util.List;

import com.company.bma.model.User;

public interface UserService {
	
	void createUser(User user);

	User retrieveUserById(Integer id);

	void updateUser(Integer id,User user);

	void deleteUserById(Integer id);

	List<User> retrieveUsers();

	User userLogin(String userName, String password);

}
