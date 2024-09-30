package com.qikserve.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qikserve.api.abstracts.AbstractController;
import com.qikserve.api.model.dto.PromotionTypeDTO;
import com.qikserve.api.model.entities.PromotionType;
import com.qikserve.api.services.PromotionTypeService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/promotionType")
@Tag(name = "PromotionType", description = "PromotionType API")
public class PromotionTypeController extends AbstractController<PromotionType, Long, PromotionTypeDTO> {
	
	@Autowired
	private PromotionTypeService promotionTypeService;
	
}
