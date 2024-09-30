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
@Table(name = "item")
public class Item extends AbstractEntity<Long> implements Serializable {

	private static final long serialVersionUID = -7053437318275760081L;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@JoinColumn(name = "group_item")
	private GroupItem groupItem;
	
	@Column(name = "provider_id")
	private String providerId;

}
