package com.qikserve.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qikserve.api.abstracts.AbstractService;
import com.qikserve.api.model.dto.ItemDTO;
import com.qikserve.api.model.entities.Item;
import com.qikserve.api.repositories.item.ItemRepository;

import io.micrometer.common.util.StringUtils;

@Service
public class ItemService extends AbstractService<Item, Long, ItemDTO> {
	
	@Autowired
	private ItemRepository itemRepository;
	
	private final RestTemplate restTemplate = new RestTemplate();
	
	public List<Item> findItemsByLink(String link) {
		List<Item> itemList = new ArrayList<>();
		String data = null;
		
		if (StringUtils.isBlank(link)) {
			throw new IllegalArgumentException("Link is required");
		}
		
        ResponseEntity<String> response = restTemplate.getForEntity(link, String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            data = response.getBody();
        } else {
            throw new RuntimeException("Failed to get data: " + response.getStatusCode());
        }
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
        	List<ItemDTO> items = objectMapper.readValue(data, new TypeReference<List<ItemDTO>>() {});
        	
			for (ItemDTO itemDTO : items) {
				
				Item item = itemRepository.findByProviderId(itemDTO.getId());
				if (Objects.isNull(item)) {
					item = new Item();
					item.setName(itemDTO.getName());
					item.setPrice(itemDTO.getPrice());
					item.setProviderId(itemDTO.getId());
					
					this.insert(item);
				}
				else {
					item.setName(itemDTO.getName());
					item.setPrice(itemDTO.getPrice());
					item.setProviderId(itemDTO.getId());

					this.update(item);
				}
				
				itemList.add(item);
			}
        }
        catch (Exception e) {
        	throw new RuntimeException("Failed to parse data: " + e.getMessage());
        }
        
        return itemList;
	}
	
}
