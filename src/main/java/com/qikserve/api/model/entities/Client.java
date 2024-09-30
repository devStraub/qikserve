package com.qikserve.api.model.entities;

import java.io.Serializable;
import java.util.Calendar;

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
@Table(name = "client")
public class Client extends AbstractEntity<Long> implements Serializable {
	
	private static final long serialVersionUID = 2758818593001209930L;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "document")
	private String document;
	
	@Column(name = "birth")
	private Calendar birth;
}
