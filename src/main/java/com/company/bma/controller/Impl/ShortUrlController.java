package com.company.bma.controller.Impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.bma.controller.ShortUrlSwaggerDoc;
import com.company.bma.model.ShortUrl;
import com.company.bma.model.ShortUrlRequest;
import com.company.bma.service.ShortUrlService;


@RestController
public class ShortUrlController implements ShortUrlSwaggerDoc {
	
	@Autowired
	ShortUrlService shortUrlService;
	
    @PostMapping("/shortUrl")
	public ResponseEntity<Void> createShortUrl(@RequestBody ShortUrlRequest shortUrlRequest) {
    	shortUrlService.createShortUrl(shortUrlRequest);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
    
    @GetMapping("/shortUrl/{id}")
	public ResponseEntity<List<ShortUrl>> retrieveShortUrls(@PathVariable Integer id) {
		return new ResponseEntity<List<ShortUrl>>(shortUrlService.retrieveAllShortUrl(id),HttpStatus.OK);
	}
    
    @PostMapping("/redirectShortUrl/{id}")
	public ResponseEntity<Void> redirectShortUrl(@PathVariable Integer id,HttpServletResponse httpResponse) {
    	try {
			httpResponse.sendRedirect(shortUrlService.redirectShortUrl(id));		
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return new ResponseEntity<Void>(HttpStatus.MOVED_PERMANENTLY);
	}
}
