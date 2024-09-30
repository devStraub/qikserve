package com.qikserve.api.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import com.qikserve.api.abstracts.AbstractEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_item")
public class OrderItem extends AbstractEntity<Long> implements Serializable {
	
	private static final long serialVersionUID = -1548086344106807788L;

	@JoinColumn(name = "order")
	private Order order;
	
	@JoinColumn(name = "item")
	private Item item;
	
	@Column(name = "unit_cost")
	private BigDecimal unitCost;
	
	@Column(name = "unit_discount")
	private BigDecimal unitDiscount;
	
	@Column(name = "amount")
	private BigDecimal amount;
	
	@Column(name = "total_cost")
	private BigDecimal totalPaid;
	
}
