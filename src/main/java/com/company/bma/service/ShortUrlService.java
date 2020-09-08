package com.company.bma.service;

import java.util.List;

import com.company.bma.model.ShortUrl;
import com.company.bma.model.ShortUrlRequest;

public interface ShortUrlService {
	
   Void createShortUrl(ShortUrlRequest shortUrlRequest);
   
   List<ShortUrl> retrieveShortUrl(Integer id);
}
