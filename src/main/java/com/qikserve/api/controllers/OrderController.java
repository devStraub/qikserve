package com.qikserve.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qikserve.api.abstracts.AbstractController;
import com.qikserve.api.model.dto.OrderDTO;
import com.qikserve.api.model.entities.Order;
import com.qikserve.api.services.OrderService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/order")
@Tag(name = "Order", description = "Order API")
public class OrderController extends AbstractController<Order, Long, OrderDTO> {
	
	@Autowired
	private OrderService orderService;
	
}
