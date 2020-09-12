package com.company.bma.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.bma.model.Card;
import com.company.bma.model.Group;
import com.company.bma.model.GroupCategory;
import com.company.bma.model.GroupRequest;
import com.company.bma.model.RoleType;
import com.company.bma.model.User;
import com.company.bma.repository.CardRepository;
import com.company.bma.repository.GroupRepository;
import com.company.bma.repository.UserRepository;
import com.company.bma.service.GroupService;
import com.company.bma.utils.ExceptionUtils;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private CardRepository cardRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void createGroup(GroupRequest groupRequest) {
		log.info("groupRequest ----" + groupRequest.toString() + "-----");
		Optional<User> user = userRepository.findById(groupRequest.getUserid());
		if (!user.isPresent()) {
			throw ExceptionUtils.generic404Exception("User Not Found");
		}
		user.get().setRoleType(RoleType.ADMIN);
		Group group = new Group(groupRequest.getGroupCategory(), groupRequest.getGroupname());
		if (group.getUsers() == null) {
			group.setUsers(new ArrayList<User>());
		}
		group.getUsers().add(user.get());
		groupRepository.save(group);
	}

	@Override
	public List<Card> retrieveCardsOfGroup(GroupCategory category, String groupName) {
		List<Group> groups = groupRepository.findBygroupCategoryAndGroupName(category, groupName);
		return groups.stream().flatMap(grp -> {
			return grp.getCards().stream();
		}).collect(Collectors.toList());
	}

	@Override
	public void addCardToGroup(Integer id, GroupRequest groupRequest) {
		log.info("addCardToGroup ----" + id + "-----" + groupRequest.toString() + "-----");
		Optional<Card> card = cardRepository.findById(id);
		Optional<Group> group = groupRepository.findById(groupRequest.getUserid());
		if (!card.isPresent()) {
			throw ExceptionUtils.generic404Exception("Card Not Found");
		}
		group.get().getCards().add(card.get());
		groupRepository.save(group.get());
	}

	@Override
	public List<String> retrieveGroupName(GroupCategory groupCategory) {
		log.info("retrieveGroupName----" + groupCategory + "-----");	
		List<Group> findBygroupCategory = groupRepository.findBygroupCategory(groupCategory);
		return findBygroupCategory.stream().map(grpcat -> {
			return grpcat.getGroupName();
		}).collect(Collectors.toList());
	}
}
