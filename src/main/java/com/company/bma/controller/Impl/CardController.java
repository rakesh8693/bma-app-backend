package com.company.bma.controller.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.bma.controller.CardSwaggerDoc;
import com.company.bma.model.Card;
import com.company.bma.model.CardRequest;
import com.company.bma.model.GroupCategory;
import com.company.bma.service.CardService;



@RestController
public class CardController implements CardSwaggerDoc {
	
    @Autowired
	private CardService CardService;
    
	@PostMapping("/card/{id}")
	public ResponseEntity<Void> createCard(@PathVariable Integer id,@RequestBody CardRequest card) {
		CardService.createCard(id,card);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("/card/{id}")
	public ResponseEntity<List<Card>> retrieveCard(@PathVariable Integer id) {
		return new ResponseEntity<List<Card>>(CardService.retrieveCard(id),HttpStatus.OK);
	}

	@PutMapping("/card/{id}")
	public ResponseEntity<Void> updateCard(@PathVariable Integer id,@RequestBody CardRequest card) {
		CardService.updateCard(id, card);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/card/{id}")
	public ResponseEntity<Void> deleteCard(@PathVariable Integer id) {
		CardService.deleteCard(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/validateCard/{id}")
	public ResponseEntity<List<Card>> changesToValidate(@PathVariable Integer id,@RequestParam GroupCategory groupCategory,@RequestParam String groupName){
		return new ResponseEntity<List<Card>>(CardService.changesToValidate(id,groupCategory,groupName),HttpStatus.OK);
	}
}
