package com.qikserve.api.repositories.item;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qikserve.api.model.entities.Item;

public interface ItemJPA extends JpaRepository<Item, Long> {

	Item findByProviderId(String id);
	
}
