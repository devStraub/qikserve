package com.qikserve.api.repositories.orderItem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qikserve.api.abstracts.AbstractRepository;
import com.qikserve.api.model.entities.Order;
import com.qikserve.api.model.entities.OrderItem;

import lombok.Getter;

@Repository
public class OrderItemRepository extends AbstractRepository<OrderItem, Long> {
	
	@Getter
	@Autowired
	private OrderItemJPA orderItemJPA;

	public List<OrderItem> findByOrder(Order order) {
		return orderItemJPA.findByOrder(order);
	}
	
}
