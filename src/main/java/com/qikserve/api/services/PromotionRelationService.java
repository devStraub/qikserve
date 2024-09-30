package com.qikserve.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qikserve.api.abstracts.AbstractService;
import com.qikserve.api.model.dto.PromotionRelationDTO;
import com.qikserve.api.model.entities.PromotionRelation;
import com.qikserve.api.repositories.promotionRelation.PromotionRelationRepository;

@Service
public class PromotionRelationService extends AbstractService<PromotionRelation, Long, PromotionRelationDTO> {
	
	@Autowired
	private PromotionRelationRepository promotionRelationRepository;
	
}
