package com.qikserve.api.repositories.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qikserve.api.abstracts.AbstractRepository;
import com.qikserve.api.model.entities.Client;

import lombok.Getter;

@Repository
public class ClientRepository extends AbstractRepository<Client, Long> {
	
	@Getter
	@Autowired
	private ClientJPA clientJPA;
	
}
