package com.company.bma.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.company.bma.model.User;
import com.company.bma.repository.UserRepository;
import com.company.bma.service.Impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTests {
	
	@InjectMocks
	UserServiceImpl userService;
	
	@Mock
	private UserRepository userRepository;
	
	@Test
	public void CreateUser() {
		User user=new User("testuser","testuser@gmail.com","testuser");
		userService.createUser(user);
		verify(userRepository, times(1)).save(user);
	}
	

	@Test
	public void UpdateUser() {
		when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(new User("testuser","testuser@gmail.com","testuser")));
		User user=new User("testuser","testuser@hotmail.com","testuser");
		userService.updateUser(1,user);
		verify(userRepository, times(1)).save(user);
	}

	@Test
	public void deleteUserById() {
		when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(new User("testuser","testuser@gmail.com","testuser")));
		userService.deleteUserById(1);
		verify(userRepository, times(1)).deleteById(1);
	}
	
	@Test
	public void RetrieveUsers() {
		when(userRepository.findAll()).thenReturn(new ArrayList<User>());
		userService.retrieveUsers();
	}
	
	@Test
	public void UserLogin() {
		when(userRepository.findByUserNameAndPassword(Mockito.anyString(), Mockito.anyString())).thenReturn(Optional.of(new User("testuser","testuser@gmail.com","testuser")));
		userService.userLogin("user","test");
	}

}
