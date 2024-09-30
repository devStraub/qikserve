package com.qikserve.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qikserve.api.abstracts.AbstractController;
import com.qikserve.api.model.dto.PromotionDTO;
import com.qikserve.api.model.entities.Promotion;
import com.qikserve.api.services.PromotionService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/promotion")
@Tag(name = "Promotion", description = "Promotion API")
public class PromotionController extends AbstractController<Promotion, Long, PromotionDTO> {
	
	@Autowired
	private PromotionService promotionService;
	
}
