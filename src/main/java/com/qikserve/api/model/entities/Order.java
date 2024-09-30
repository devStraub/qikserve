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
@Table(name = "order")
public class Order extends AbstractEntity<Long> implements Serializable {
	
	private static final long serialVersionUID = -4014832669537016366L;
	
	@JoinColumn(name = "client")
	private Client client;
	
	@Column(name = "date")
	private Calendar date;
	
}
