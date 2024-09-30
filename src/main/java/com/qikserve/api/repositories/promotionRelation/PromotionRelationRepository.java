package com.qikserve.api.repositories.promotionRelation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qikserve.api.abstracts.AbstractRepository;
import com.qikserve.api.model.entities.PromotionRelation;

import lombok.Getter;

@Repository
public class PromotionRelationRepository extends AbstractRepository<PromotionRelation, Long> {
	
	@Getter
	@Autowired
	private PromotionRelationJPA promotionRelationJPA;
	
}
