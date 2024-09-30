package com.qikserve.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qikserve.api.abstracts.AbstractService;
import com.qikserve.api.model.dto.OrderItemDTO;
import com.qikserve.api.model.entities.Order;
import com.qikserve.api.model.entities.OrderItem;
import com.qikserve.api.repositories.orderItem.OrderItemRepository;

@Service
public class OrderItemService extends AbstractService<OrderItem, Long, OrderItemDTO> {
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public List<OrderItemDTO> findOrderItemByOrder(Order order) {
		List<OrderItemDTO> orderItemDTOList = new ArrayList<>();
		
		List<OrderItem> orderItemList = this.orderItemRepository.findByOrder(order);

		for (OrderItem orderItem : orderItemList) {
			OrderItemDTO orderItemDTO = new OrderItemDTO().entityToDTO(orderItem);
			orderItemDTOList.add(orderItemDTO);
		}
		
		return orderItemDTOList;
	}
}
