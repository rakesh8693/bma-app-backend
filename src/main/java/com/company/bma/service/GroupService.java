package com.company.bma.service;

import java.util.List;

import com.company.bma.model.Group;
import com.company.bma.model.GroupRequest;

public interface GroupService {
	
	   Void createGroup(GroupRequest groupRequest);
	   
	   List<Group> retrieveGroup(Integer groupBy);
}
