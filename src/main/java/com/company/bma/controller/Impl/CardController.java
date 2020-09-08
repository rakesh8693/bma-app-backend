package com.company.bma.controller.Impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.bma.controller.CardSwaggerDoc;
import com.company.bma.model.Card;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class CardController implements CardSwaggerDoc {

	@PostMapping("/card")
	public ResponseEntity<Void> createCard(@RequestBody Card card) {
		return null;
	}

	@GetMapping("/card")
	public ResponseEntity<List<Card>> retrieveCard(@RequestParam Integer id, @RequestParam Integer groupBy,
			@RequestParam String groupName) {
		return null;
	}

	@PutMapping("/card")
	public ResponseEntity<Void> updateCard(@RequestBody Card card) {
		return null;
	}

	@DeleteMapping("/card/{id}")
	public ResponseEntity<Void> deleteCard(@PathVariable Integer id) {
		return null;
	}

}
