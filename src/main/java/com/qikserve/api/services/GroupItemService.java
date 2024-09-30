package com.qikserve.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qikserve.api.abstracts.AbstractService;
import com.qikserve.api.model.dto.GroupItemDTO;
import com.qikserve.api.model.entities.GroupItem;
import com.qikserve.api.repositories.groupItem.GroupItemRepository;

@Service
public class GroupItemService extends AbstractService<GroupItem, Long, GroupItemDTO> {
	
	@Autowired
	private GroupItemRepository groupItemRepository;
	
}
