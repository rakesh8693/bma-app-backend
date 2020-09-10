package com.company.bma.service;

import java.io.IOException;
import java.util.List;

import com.company.bma.model.ShortUrl;
import com.company.bma.model.ShortUrlRequest;

public interface ShortUrlService {

	void createShortUrl(ShortUrlRequest shortUrlRequest);

	List<ShortUrl> retrieveAllShortUrl(Integer id);

	String redirectShortUrl(Integer id) throws IOException;
}
