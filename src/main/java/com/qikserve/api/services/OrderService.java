package com.qikserve.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.qikserve.api.abstracts.AbstractService;
import com.qikserve.api.model.dto.OrderDTO;
import com.qikserve.api.model.entities.Client;
import com.qikserve.api.model.entities.Order;
import com.qikserve.api.repositories.order.OrderRepository;

@Service
public class OrderService extends AbstractService<Order, Long, OrderDTO> {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemService orderItemService;
	
	public List<OrderDTO> findOrderWithItemsByClient(Client client) {
		List<OrderDTO> orderDTOList = new  ArrayList<>();
		
		List<Order> orderList = this.orderRepository.findByClient(client);
		
		if (!CollectionUtils.isEmpty(orderList)) {
			for (Order order : orderList) {
				OrderDTO orderDTO = new OrderDTO().entityToDTO(order);
				orderDTO.setOrderItemList(this.orderItemService.findOrderItemByOrder(order));
				
				orderDTOList.add(orderDTO);
			}
		}
		
		return orderDTOList;
	}
}
