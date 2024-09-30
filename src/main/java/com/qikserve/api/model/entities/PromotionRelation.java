package com.qikserve.api.model.entities;

import java.io.Serializable;

import com.qikserve.api.abstracts.AbstractEntity;

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
@Table(name = "promotion_relation")
public class PromotionRelation extends AbstractEntity<Long> implements Serializable {
	
	private static final long serialVersionUID = 3473673631722318648L;
	
	@JoinColumn(name = "promotion")
	private Promotion promotion;
	
	@JoinColumn(name = "item")
	private Item item;
	
	@JoinColumn(name = "group_item")
	private GroupItem groupItem;
	
	@JoinColumn(name = "client")
	private Client client;
	
}
