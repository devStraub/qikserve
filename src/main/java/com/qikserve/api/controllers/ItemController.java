package com.qikserve.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qikserve.api.abstracts.AbstractController;
import com.qikserve.api.model.dto.ItemDTO;
import com.qikserve.api.model.entities.Item;
import com.qikserve.api.services.ItemService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/item")
@Tag(name = "Item", description = "Item API")
public class ItemController extends AbstractController<Item, Long, ItemDTO> {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/findItemsByLink")
	public ResponseEntity<List<Item>> findItemsByLink(String link) {
		return ResponseEntity.ok().body(itemService.findItemsByLink(link));
	}
	
}
