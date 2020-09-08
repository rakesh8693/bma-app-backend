package com.company.bma.controller.Impl;

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

@RestController
public class UserController implements UserSwaggerDoc {

	@PostMapping("/user")
	public ResponseEntity<Void> createUser(@RequestBody User user) {
		return null;
	}

	@GetMapping("/User/{id}")
	public ResponseEntity<User> retrieveUserById(@PathVariable Integer id) {
		return null;
	}

	@PutMapping("/user")
	public ResponseEntity<Void> updateUser(@RequestBody User user) {
		return null;
	}

	@DeleteMapping("/User/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable Integer id) {
		return null;
	}

}
