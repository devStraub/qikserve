package com.qikserve.api.repositories.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qikserve.api.abstracts.AbstractRepository;
import com.qikserve.api.model.entities.Item;

import lombok.Getter;

@Repository
public class ItemRepository extends AbstractRepository<Item, Long> {
	
	@Getter
	@Autowired
	private ItemJPA itemJPA;

	public Item findByProviderId(String id) {
		return itemJPA.findByProviderId(id);
	}
	
}
