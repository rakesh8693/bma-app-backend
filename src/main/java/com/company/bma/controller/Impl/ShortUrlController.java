package com.company.bma.controller.Impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.bma.controller.ShortUrlSwaggerDoc;
import com.company.bma.model.ShortUrl;
import com.company.bma.model.ShortUrlRequest;
import com.company.bma.service.ShortUrlService;
import com.company.bma.utils.CsvUtils;


@RestController
@CrossOrigin(origins = "*")
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
    

    @GetMapping("/shareShortUrl/{id}")
	public void shareShortUrl(@PathVariable Integer id,HttpServletResponse response) {
    	response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=shortUrl.csv");
		try {
			CsvUtils.downloadCsv(response.getWriter(),Arrays.asList(shortUrlService.shareShortUrl(id)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
