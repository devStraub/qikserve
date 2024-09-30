package com.qikserve.api.model.entities;

import java.io.Serializable;

import com.qikserve.api.abstracts.AbstractEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "promotion_type")
public class PromotionType extends AbstractEntity<Long> implements Serializable {

	private static final long serialVersionUID = 6163671981661586258L;
	
	@Column(name = "name")
	private String name;
	
}
