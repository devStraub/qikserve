package com.qikserve.api.repositories.client;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qikserve.api.model.entities.Client;

public interface ClientJPA extends JpaRepository<Client, Long> {

}
