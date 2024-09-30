package com.qikserve.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qikserve.api.abstracts.AbstractController;
import com.qikserve.api.model.dto.OrderItemDTO;
import com.qikserve.api.model.entities.OrderItem;
import com.qikserve.api.services.OrderItemService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/order-item")
@Tag(name = "Order Item", description = "Order Item API")
public class OrderItemController extends AbstractController<OrderItem, Long, OrderItemDTO> {
	
	@Autowired
	private OrderItemService orderItemService;
	
}
