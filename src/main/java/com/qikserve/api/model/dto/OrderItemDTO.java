package com.qikserve.api.model.dto;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.qikserve.api.abstracts.AbstractDTO;
import com.qikserve.api.model.entities.OrderItem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class OrderItemDTO extends AbstractDTO<OrderItem, OrderItemDTO> {
	
	private OrderDTO order;
	private ItemDTO item;
	private BigDecimal unitCost;
	private BigDecimal unitDiscount;
	private BigDecimal amount;
	private BigDecimal totalPaid;
	
}
