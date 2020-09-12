package com.company.bma.service;

import java.util.List;

import com.company.bma.model.Card;
import com.company.bma.model.GroupCategory;
import com.company.bma.model.GroupRequest;

public interface GroupService {

	void createGroup(GroupRequest groupRequest);

	void addCardToGroup(Integer id, GroupRequest groupRequest);

	List<Card> retrieveCardsOfGroup(GroupCategory category, String groupName);

	List<String> retrieveGroupName(GroupCategory groupCategory);
}
