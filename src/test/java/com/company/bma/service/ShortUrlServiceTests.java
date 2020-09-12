package com.company.bma.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.company.bma.exception.Generic404Exception;
import com.company.bma.model.ShortUrl;
import com.company.bma.model.ShortUrlRequest;
import com.company.bma.model.User;
import com.company.bma.repository.ShortUrlRepository;
import com.company.bma.repository.UserRepository;
import com.company.bma.service.Impl.ShortUrlServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ShortUrlServiceTests {
	
	@InjectMocks
	private ShortUrlServiceImpl ShortUrlService;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private ShortUrlRepository shortUrlRepository;

	@Test
	public void createShortUrl() {
		User user=new User("testuser","testuser@gmail.com","testuser");
		user.setShorturls(new ArrayList<ShortUrl>());
		when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(user));
		ShortUrlService.createShortUrl(new ShortUrlRequest("longurl",new Date(),1));
		verify(userRepository, times(1)).save(user);
	}

	@Test
	public void retrieveAllShortUrl() {
		User user=new User("testuser","testuser@gmail.com","testuser");
		user.setShorturls(new ArrayList<ShortUrl>());
		when(userRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(user));
		ShortUrlService.retrieveAllShortUrl(1);
	}
	
	@Test
	public void shareShortUrl() {
		ShortUrl shortUrl=new ShortUrl("longurl","surl",new Date());
		shortUrl.setId(1);
		when(shortUrlRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(shortUrl));
		ShortUrlService.shareShortUrl(1);
	}
	
	@Test(expected=Generic404Exception.class)
	public void shareShortUrlWhenNotFound() {
		when(shortUrlRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
		ShortUrlService.shareShortUrl(1);
	}
	
	
}
