package com.qikserve.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qikserve.api.abstracts.AbstractController;
import com.qikserve.api.model.dto.ClientDTO;
import com.qikserve.api.model.entities.Client;
import com.qikserve.api.services.ClientService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/client")
@Tag(name = "Client", description = "Client API")
public class ClientController extends AbstractController<Client, Long, ClientDTO> {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/history/{id}")
	public ResponseEntity<ClientDTO> getClientSimpleHistory(@PathVariable Long id){
        return ResponseEntity.ok().body(clientService.getClientSimpleHistory(id));
    }

}
