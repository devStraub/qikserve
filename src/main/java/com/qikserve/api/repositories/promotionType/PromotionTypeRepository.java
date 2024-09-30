package com.qikserve.api.repositories.promotionType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qikserve.api.abstracts.AbstractRepository;
import com.qikserve.api.model.entities.PromotionType;

import lombok.Getter;

@Repository
public class PromotionTypeRepository extends AbstractRepository<PromotionType, Long> {
	
	@Getter
	@Autowired
	private PromotionTypeJPA promotionTypeJPA;
	
}
