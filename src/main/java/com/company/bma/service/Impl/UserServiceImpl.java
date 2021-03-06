package com.company.bma.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.bma.exception.Generic404Exception;
import com.company.bma.model.RoleType;
import com.company.bma.model.User;
import com.company.bma.repository.UserRepository;
import com.company.bma.service.UserService;
import com.company.bma.utils.ExceptionUtils;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void createUser(User user) {
		log.info("createUser ----"+user.toString()+"-----");
		Optional<User> userobj = userRepository.findByUserNameAndPassword(user.getUserName(),user.getPassword());
		if(userobj.isPresent()) {
			throw ExceptionUtils.generic406Exception("User Already Exists");
		}
		user.setRoleType(RoleType.USER);
		userRepository.save(user);	
	}

	@Override
	public User retrieveUserById(Integer id) {
		log.info("retrieveUserById ----"+id+"-----");
		return getUserById(id);
	}

	@Override
	public void updateUser(Integer id,User user) {
		log.info("updateUser ----"+user.toString()+"-----");
		User userObj = getUserById(id);
		userObj.setEmail(user.getEmail());
		userObj.setPassword(user.getPassword());
		userObj.setUserName(user.getUserName());
		userRepository.save(userObj);	
	}

	@Override
	public void deleteUserById(Integer id) {
		log.info("deleteUserById ----"+id+"-----");
		getUserById(id);
		userRepository.deleteById(id);	
	}
	
	private User getUserById(Integer userId) {
		Optional<User> findById = userRepository.findById(userId);
		if (!findById.isPresent()) {
			Generic404Exception generic404Exception = new Generic404Exception("Not_Found", "User Not Found");
			throw generic404Exception;
		}
		return findById.get();
	}

	@Override
	public List<User> retrieveUsers() {
		return userRepository.findAll();
	}

	@Override
	public User userLogin(String userName, String password) {
		Optional<User> userobj = userRepository.findByUserNameAndPassword(userName,password);
		if(!userobj.isPresent()) {
			throw ExceptionUtils.generic404Exception("User Doesnot Exists");
		}
		return userobj.get();
	}

}
