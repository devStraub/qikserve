package com.qikserve.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qikserve.api.abstracts.AbstractController;
import com.qikserve.api.model.dto.GroupItemDTO;
import com.qikserve.api.model.entities.GroupItem;
import com.qikserve.api.services.GroupItemService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/group-item")
@Tag(name = "Group Item", description = "Group Item API")
public class GroupItemController extends AbstractController<GroupItem, Long, GroupItemDTO> {
	
	@Autowired
	private GroupItemService groupItemService;
	
}
