package com.company.bma.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.company.bma.exception.Generic404Exception;
import com.company.bma.model.Card;
import com.company.bma.model.Group;
import com.company.bma.model.GroupCategory;
import com.company.bma.model.GroupRequest;
import com.company.bma.model.User;
import com.company.bma.repository.CardRepository;
import com.company.bma.repository.GroupRepository;
import com.company.bma.repository.UserRepository;
import com.company.bma.service.Impl.GroupServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class GroupServiceTests {
	
	@InjectMocks
	GroupServiceImpl groupService;
	
	@Mock
	private GroupRepository groupRepository;

	@Mock
	private CardRepository cardRepository;

	@Mock
	private UserRepository userRepository;

	@Test
	public void createGroup() {		
		User user=new User("testuser","testuser@gmail.com","testuser");
		user.setCards(new ArrayList<Card>());
		when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(user));
		groupService.createGroup(new GroupRequest(GroupCategory.TRIBE,"Group",1));
		Group group = new Group(GroupCategory.TRIBE,"Group");
		group.setUsers(Arrays.asList(user));
		verify(groupRepository, times(1)).save(group);		
	}

	@Test
	public void retrieveCardsOfGroup() {
		Group group = new Group(GroupCategory.TRIBE,"Group");
		group.setCards(new ArrayList<Card>());
		when(groupRepository.findBygroupCategoryAndGroupName(GroupCategory.TRIBE,"Group")).thenReturn(Arrays.asList(group));
		groupService.retrieveCardsOfGroup(GroupCategory.TRIBE,"Group");
	}
	
	@Test
	public void retrieveGroupName() {
		groupService.retrieveGroupName(GroupCategory.TRIBE);
	}
	
	@Test
	public void addCardToGroup() {		
		Card card=new Card("title","carddescription","iconlocation",0);
		Group group = new Group(GroupCategory.TRIBE,"Group");
		group.setCards(new ArrayList<Card>());
		when(cardRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(card));
		when(groupRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(group));
		groupService.addCardToGroup(1,new GroupRequest(GroupCategory.TRIBE,"Group",1));
		verify(groupRepository, times(1)).save(group);		
	}
	
	@Test(expected=Generic404Exception.class)
	public void addCardToGroupThrowException() {		
		Group group = new Group(GroupCategory.TRIBE,"Group");
		group.setCards(new ArrayList<Card>());
		when(cardRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		when(groupRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(group));
		groupService.addCardToGroup(1,new GroupRequest(GroupCategory.TRIBE,"Group",1));
		verify(groupRepository, times(1)).save(group);		
	}
}
