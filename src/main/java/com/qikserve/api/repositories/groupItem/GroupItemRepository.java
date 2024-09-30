package com.qikserve.api.repositories.groupItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qikserve.api.abstracts.AbstractRepository;
import com.qikserve.api.model.entities.GroupItem;

import lombok.Getter;

@Repository
public class GroupItemRepository extends AbstractRepository<GroupItem, Long> {
	
	@Getter
	@Autowired
	private GroupItemJPA groupItemJPA;
	
}
