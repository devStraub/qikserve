package com.qikserve.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qikserve.api.abstracts.AbstractController;
import com.qikserve.api.model.dto.PromotionRelationDTO;
import com.qikserve.api.model.entities.PromotionRelation;
import com.qikserve.api.services.PromotionRelationService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/promotion-relation")
@Tag(name = "PromotionRelation", description = "PromotionRelation API")
public class PromotionRelationController extends AbstractController<PromotionRelation, Long, PromotionRelationDTO> {
	
	@Autowired
	private PromotionRelationService promotionRelationService;
	
}
