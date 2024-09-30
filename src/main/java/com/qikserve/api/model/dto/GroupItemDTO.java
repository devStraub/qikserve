package com.qikserve.api.model.dto;

import org.springframework.stereotype.Component;

import com.qikserve.api.abstracts.AbstractDTO;
import com.qikserve.api.model.entities.GroupItem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class GroupItemDTO extends AbstractDTO<GroupItem, GroupItemDTO> {
	
	private String name;
	
}
