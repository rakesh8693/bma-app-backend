package com.company.bma.service.Impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.company.bma.exception.Generic404Exception;
import com.company.bma.model.ShortUrl;
import com.company.bma.model.ShortUrlRequest;
import com.company.bma.model.User;
import com.company.bma.repository.ShortUrlRepository;
import com.company.bma.repository.UserRepository;
import com.company.bma.service.ShortUrlService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ShortUrlServiceImpl implements ShortUrlService {

	@Value("${mydomain}")
	String domain;

	@Autowired
	private ShortUrlRepository shortUrlRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void createShortUrl(ShortUrlRequest shortUrlRequest) {
		log.info("Requested url--" + shortUrlRequest.getLongurl());
		String name = "tiny";
		User user = getUserById(shortUrlRequest.getUserId());
		name = user.getUsername();
		String shortName = RandomStringUtils.randomAlphanumeric(7);
		String generatedUrl = domain + "/" + name + "/" + shortName;
		log.info("Generated url--" + generatedUrl);
		List<ShortUrl> shorturls = user.getShorturls();
		shorturls.add(new ShortUrl(shortUrlRequest.getLongurl(), generatedUrl, shortUrlRequest.getExpiryDate()));
		user.setShorturls(shorturls);
		userRepository.save(user);
	}

	@Override
	public List<ShortUrl> retrieveAllShortUrl(Integer id) {
		User user = getUserById(id);
		return user.getShorturls();
	}

	@Override
	public String redirectShortUrl(Integer id) throws IOException {
		Optional<ShortUrl> findById = shortUrlRepository.findById(id);
		if (!findById.isPresent()) {
			Generic404Exception generic404Exception = new Generic404Exception("Not_Found", "id Not Found");
			throw generic404Exception;
		}
		log.info("redirect url--" + findById.get().getLurl());
		return findById.get().getLurl();
	}

	private User getUserById(Integer userId) {
		Optional<User> findById = userRepository.findById(userId);
		if (!findById.isPresent()) {
			Generic404Exception generic404Exception = new Generic404Exception("Not_Found", "User Not Found");
			throw generic404Exception;
		}
		return findById.get();
	}

}
