package com.company.bma.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.bma.exception.Generic404Exception;
import com.company.bma.model.Card;
import com.company.bma.model.CardRequest;
import com.company.bma.model.User;
import com.company.bma.repository.CardRepository;
import com.company.bma.repository.UserRepository;
import com.company.bma.service.CardService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CardServiceImpl implements CardService {
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void createCard(Integer id,CardRequest card) {
		log.info("createCard ----"+card.toString()+"-----");
		User user = getUserById(id);
		List<Card> cards = user.getCards();
		cards.add(new Card(card.getTitle(),card.getIcon(),card.getDescription(),0));
		user.setCards(cards);
		userRepository.save(user);	
	}

	@Override
	public List<Card> retrieveCard(Integer id) {
		User user = getUserById(id);
		return user.getCards();
	}

	@Override
	public void updateCard(Integer id,CardRequest card) {
		log.info("updateCard ----"+card.toString()+"-----");
		User user = getUserById(id);
		Card cradObj = cardRepository.getOne(id);
		if(cradObj==null) {
			throw generic404Exception("Card Not Found");
		}
		cradObj=user.getCards().stream().filter(c->c.getId()==id).findFirst().get();
		cradObj.setDescription(card.getDescription());
		cradObj.setIcon(card.getIcon());
		cradObj.setTitle(card.getTitle());
		user.getCards().add(cradObj);
		userRepository.save(user);	
	}

	@Override
	public void deleteCard(Integer id) {
		log.info("deleteCard ----"+id+"-----");
		getUserById(id);
		cardRepository.deleteById(id);	
	}
	
	private User getUserById(Integer userId) {
		Optional<User> findById = userRepository.findById(userId);
		if (!findById.isPresent()) {
			throw generic404Exception("User Not Found");
		}
		return findById.get();
	}
	
	private Generic404Exception generic404Exception(String description) {
		Generic404Exception generic404Exception = new Generic404Exception("Not_Found",description);
		return generic404Exception;
	}

}
