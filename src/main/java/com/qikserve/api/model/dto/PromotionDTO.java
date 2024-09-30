package com.qikserve.api.model.dto;

import java.util.Calendar;

import org.springframework.stereotype.Component;

import com.qikserve.api.abstracts.AbstractDTO;
import com.qikserve.api.model.entities.Promotion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PromotionDTO extends AbstractDTO<Promotion, PromotionDTO> {
	
	private String name;
	private Calendar dateStart;
	private Calendar dateEnd;
	private boolean active;
	private PromotionTypeDTO promotionType;
	
}
