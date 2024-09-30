package com.qikserve.api.repositories.orderItem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qikserve.api.model.entities.Order;
import com.qikserve.api.model.entities.OrderItem;

public interface OrderItemJPA extends JpaRepository<OrderItem, Long> {

	List<OrderItem> findByOrder(Order order);

}
