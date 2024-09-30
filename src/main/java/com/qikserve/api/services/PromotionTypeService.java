package com.qikserve.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qikserve.api.abstracts.AbstractService;
import com.qikserve.api.model.dto.PromotionTypeDTO;
import com.qikserve.api.model.entities.PromotionType;
import com.qikserve.api.repositories.promotionType.PromotionTypeRepository;

@Service
public class PromotionTypeService extends AbstractService<PromotionType, Long, PromotionTypeDTO> {
	
	@Autowired
	private PromotionTypeRepository promotionTypeRepository;
	
}
