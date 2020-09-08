package com.company.bma.service;

import java.util.List;
import com.company.bma.model.Card;

public interface CardService {

	Void createCard(Card card);

	List<Card> retrieveCard(Integer id, Integer groupBy, String groupName);

	Void updateCard(Card card);

	Void deleteCard(Integer id);

}
