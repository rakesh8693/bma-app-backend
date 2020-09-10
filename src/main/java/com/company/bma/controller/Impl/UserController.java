package com.company.bma.controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.bma.controller.UserSwaggerDoc;
import com.company.bma.model.User;
import com.company.bma.service.UserService;

@RestController
public class UserController implements UserSwaggerDoc {
	
	@Autowired
	UserService userService;

	@PostMapping("/user")
	public ResponseEntity<Void> createUser(@RequestBody User user) {
		userService.createUser(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<User> retrieveUserById(@PathVariable Integer id) {
		return new ResponseEntity<User>(userService.retrieveUserById(id),HttpStatus.OK);
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<Void> updateUser(@PathVariable Integer id,@RequestBody User user) {
		userService.updateUser(id,user);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable Integer id) {
		userService.deleteUserById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
