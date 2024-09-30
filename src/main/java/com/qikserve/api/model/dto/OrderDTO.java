package com.qikserve.api.model.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.qikserve.api.abstracts.AbstractDTO;
import com.qikserve.api.model.entities.Order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class OrderDTO extends AbstractDTO<Order, OrderDTO> {
	
	private ClientDTO client;
	private String date;
	
	private List<OrderItemDTO> orderItemList;
	
}
