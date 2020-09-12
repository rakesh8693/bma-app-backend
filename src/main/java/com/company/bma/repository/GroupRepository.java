package com.company.bma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.bma.model.Group;
import com.company.bma.model.GroupCategory;

@Repository
public interface GroupRepository extends JpaRepository<Group,Integer> {
	
	List<Group> findBygroupCategory(GroupCategory arg0);
	
	List<Group> findBygroupCategoryAndGroupName(GroupCategory arg0,String arg1);

}
