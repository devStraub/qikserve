package com.qikserve.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qikserve.api.abstracts.AbstractService;
import com.qikserve.api.model.dto.PromotionDTO;
import com.qikserve.api.model.entities.Promotion;
import com.qikserve.api.repositories.promotion.PromotionRepository;

@Service
public class PromotionService extends AbstractService<Promotion, Long, PromotionDTO> {
	
	@Autowired
	private PromotionRepository promotionRepository;
	
}
