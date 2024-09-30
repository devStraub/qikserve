package com.qikserve.api.model.dto;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.qikserve.api.abstracts.AbstractDTO;
import com.qikserve.api.model.entities.Item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDTO extends AbstractDTO<Item, ItemDTO> {
	
	private String name;
	private BigDecimal price;
	private GroupItemDTO groupItem;
	private String providerId;
	
}
