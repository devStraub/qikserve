package com.qikserve.api.model.dto;

import org.springframework.stereotype.Component;

import com.qikserve.api.abstracts.AbstractDTO;
import com.qikserve.api.model.entities.PromotionType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PromotionTypeDTO extends AbstractDTO<PromotionType, PromotionTypeDTO> {
	
	private String name;
	
}
