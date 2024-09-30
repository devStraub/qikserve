package com.qikserve.api.repositories.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qikserve.api.model.entities.Client;
import com.qikserve.api.model.entities.Order;

public interface OrderJPA extends JpaRepository<Order, Long> {

	List<Order> findByClient(Client client);
	
}
