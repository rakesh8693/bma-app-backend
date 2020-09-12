package com.company.bma.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.company.bma.model.Card;
import com.company.bma.model.CardRequest;
import com.company.bma.model.Group;
import com.company.bma.model.GroupCategory;
import com.company.bma.model.RoleType;
import com.company.bma.model.ShortUrl;
import com.company.bma.model.User;
import com.company.bma.repository.GroupRepository;
import com.company.bma.repository.ShortUrlRepository;
import com.company.bma.repository.UserRepository;
import com.company.bma.service.Impl.CardServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CardServiceTests {
	
	@InjectMocks
	CardServiceImpl cardService;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private GroupRepository groupRepository;
	
	@Mock
	private ShortUrlRepository shortUrlRepository;
	
	
	@Test
	public void createCard() {
		ShortUrl shortUrl=new ShortUrl("longurl","surl",new Date());
		shortUrl.setId(1);
		User user=new User("testuser","testuser@gmail.com","testuser");
		user.setShorturls(Arrays.asList(shortUrl));
		user.setCards(new ArrayList<Card>());
		when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(user));
		when(shortUrlRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(shortUrl));
		cardService.createCard(1, new CardRequest(1,"cardname","cardDescription","cardicon"));
		verify(userRepository, times(1)).save(user);
	}

	@Test
	public void retrieveCard() {
		ShortUrl shortUrl=new ShortUrl("longurl","surl",new Date());
		shortUrl.setId(1);
		User user=new User("testuser","testuser@gmail.com","testuser");
		user.setShorturls(Arrays.asList(shortUrl));
		user.setCards(new ArrayList<Card>());
		when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(user));
		cardService.retrieveCard(1);
	}
	
	@Test
	public void changesToValidateWhenUser() {
		ShortUrl shortUrl=new ShortUrl("longurl","surl",new Date());
		shortUrl.setId(1);
		User user=new User("testuser","testuser@gmail.com","testuser");
		user.setRoleType(RoleType.USER);
		user.setShorturls(Arrays.asList(shortUrl));
		user.setCards(new ArrayList<Card>());
		when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(user));
		cardService.changesToValidate(1,GroupCategory.TRIBE,"Group");
	}
	
	@Test
	public void changesToValidateWhenAdmin() {
		ShortUrl shortUrl=new ShortUrl("longurl","surl",new Date());
		shortUrl.setId(1);
		User user=new User("testuser","testuser@gmail.com","testuser");
		user.setRoleType(RoleType.ADMIN);
		user.setShorturls(Arrays.asList(shortUrl));
		user.setCards(new ArrayList<Card>());
		Group group=new Group();
		group.setCards(new ArrayList<Card>());
		when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(user));
		//when(groupRepository.findBygroupCategoryAndGroupName(GroupCategory.TRIBE,"group")).thenReturn(Arrays.asList(group));
		cardService.changesToValidate(1,GroupCategory.TRIBE,"Group");
	}

	Void updateCard(Card card) {
		return null;
	}

	Void deleteCard(Integer id) {
		return null;
	}

}
