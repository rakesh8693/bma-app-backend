package com.company.bma.service;

import java.util.List;
import com.company.bma.model.Card;
import com.company.bma.model.CardRequest;

public interface CardService {

	void createCard(Integer id,CardRequest card);

	List<Card> retrieveCard(Integer id);

	void updateCard(Integer id,CardRequest card);

	void deleteCard(Integer id);

}
