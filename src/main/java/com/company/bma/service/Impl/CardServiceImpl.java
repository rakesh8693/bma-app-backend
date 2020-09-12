package com.company.bma.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.bma.model.Card;
import com.company.bma.model.CardRequest;
import com.company.bma.model.Group;
import com.company.bma.model.GroupCategory;
import com.company.bma.model.RoleType;
import com.company.bma.model.ShortUrl;
import com.company.bma.model.User;
import com.company.bma.repository.CardRepository;
import com.company.bma.repository.GroupRepository;
import com.company.bma.repository.ShortUrlRepository;
import com.company.bma.repository.UserRepository;
import com.company.bma.service.CardService;
import com.company.bma.utils.ExceptionUtils;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CardServiceImpl implements CardService {

	@Autowired
	private CardRepository cardRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ShortUrlRepository shortUrlRepository;

	@Autowired
	private GroupRepository groupRepository;

	@Override
	public void createCard(Integer id, CardRequest cardRequest) {
		log.info("createCard ----" + cardRequest.toString() + "-----");
		User user = getUserById(id);
		Optional<ShortUrl> findById = shortUrlRepository.findById(cardRequest.getSurlId());
		if (!findById.isPresent()) {
			throw ExceptionUtils.generic404Exception("ShortUrl Not Found");
		}
		Optional<ShortUrl> shortUrl = user.getShorturls().stream().filter(s -> s.getId() == cardRequest.getSurlId()).findFirst();
		if(!shortUrl.isPresent()) {
			throw ExceptionUtils.generic404Exception("ShortUrl Not Found For User");
		}
		List<Card> cards = user.getCards();
		Card card = new Card(cardRequest.getTitle(), cardRequest.getIcon(), cardRequest.getDescription(), 0);
		shortUrl.get().setCard(card);
		cards.add(card);
		user.setCards(cards);
		userRepository.save(user);
	}

	@Override
	public List<Card> retrieveCard(Integer id) {
		User user = getUserById(id);
		return user.getCards();
	}

	@Override
	public void updateCard(Integer cardId, CardRequest cardRequest) {
		log.info("updateCard ----" + cardRequest.toString() + "-----");
		Optional<Card> card = cardRepository.findById(cardId);
		if (!card.isPresent()) {
			throw ExceptionUtils.generic404Exception("Card Not Found");
		}
		card.get().setDescription(cardRequest.getDescription());
		card.get().setIcon(cardRequest.getIcon());
		card.get().setTitle(cardRequest.getTitle());
		cardRepository.save(card.get());
	}

	@Override
	public void deleteCard(Integer id) {
		log.info("deleteCard ----" + id + "-----");
		getUserById(id);
		cardRepository.deleteById(id);
	}

	private User getUserById(Integer userId) {
		Optional<User> findById = userRepository.findById(userId);
		if (!findById.isPresent()) {
			throw ExceptionUtils.generic404Exception("User Not Found");
		}
		return findById.get();
	}

	@Override
	public List<Card> changesToValidate(Integer userId, GroupCategory grpCategory, String grpName) {
		log.info("changesToValidate----" + userId + "---" + grpCategory + "-----" + "grpName");
		Optional<User> user = userRepository.findById(userId);
		if (!user.isPresent()) {
			throw ExceptionUtils.generic404Exception("User Not Found");
		}
		if (user.get().getRoleType().equals(RoleType.USER)) {
			return new ArrayList<Card>();
		}
		List<Group> group = groupRepository.findBygroupCategoryAndGroupName(grpCategory, grpName);
		return group.stream().flatMap(grp -> {
			return grp.getCards().stream();
		}).filter(c -> c.getValidate() == 1).collect(Collectors.toList());
	}
}
