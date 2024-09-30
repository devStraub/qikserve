package com.qikserve.api.model.entities;

import java.io.Serializable;
import java.util.Calendar;

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
@Table(name = "promotion")
public class Promotion extends AbstractEntity<Long> implements Serializable {

	private static final long serialVersionUID = -8889171078640942262L;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "date_start")
	private Calendar dateStart;
	
	@Column(name = "date_end")
	private Calendar dateEnd;
	
	@Column(name = "active")
	private boolean active;
	
	@JoinColumn(name = "promotion_type")
	private PromotionType promotionType;
	
}
