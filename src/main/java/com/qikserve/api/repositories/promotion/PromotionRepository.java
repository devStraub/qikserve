package com.qikserve.api.repositories.promotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qikserve.api.abstracts.AbstractRepository;
import com.qikserve.api.model.entities.Promotion;

import lombok.Getter;

@Repository
public class PromotionRepository extends AbstractRepository<Promotion, Long> {
	
	@Getter
	@Autowired
	private PromotionJPA promotionJPA;
	
}
