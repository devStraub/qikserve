package com.qikserve.api.repositories.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qikserve.api.abstracts.AbstractRepository;
import com.qikserve.api.model.entities.Client;
import com.qikserve.api.model.entities.Order;

import lombok.Getter;

@Repository
public class OrderRepository extends AbstractRepository<Order, Long> {
	
	@Getter
	@Autowired
	private OrderJPA orderJPA;

	public List<Order> findByClient(Client client) {
		return orderJPA.findByClient(client);
	}
	
}
