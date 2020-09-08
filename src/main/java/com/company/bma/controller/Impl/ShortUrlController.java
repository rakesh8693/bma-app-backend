package com.company.bma.controller.Impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.bma.controller.ShortUrlSwaggerDoc;
import com.company.bma.model.ShortUrl;
import com.company.bma.model.ShortUrlRequest;


@RestController
public class ShortUrlController implements ShortUrlSwaggerDoc {
	
    @PostMapping("/shortUrl")
	public ResponseEntity<Void> createShortUrl(@RequestBody ShortUrlRequest shortUrlRequest) {
		return null;
	}
    
    @GetMapping("/shortUrl")
	public ResponseEntity<List<ShortUrl>> retrieveShortUrl(@RequestParam Integer id) {
		return null;
	}
}
