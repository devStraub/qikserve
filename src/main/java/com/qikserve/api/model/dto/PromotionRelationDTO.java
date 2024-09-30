package com.qikserve.api.model.dto;

import org.springframework.stereotype.Component;

import com.qikserve.api.abstracts.AbstractDTO;
import com.qikserve.api.model.entities.PromotionRelation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PromotionRelationDTO extends AbstractDTO<PromotionRelation, PromotionRelationDTO> {
	
	private PromotionDTO promotion;
	private ItemDTO item;
	private GroupItemDTO groupItem;
	private ClientDTO client;
	
}
