package com.qikserve.api.model.dto;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.qikserve.api.abstracts.AbstractDTO;
import com.qikserve.api.model.entities.Client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ClientDTO extends AbstractDTO<Client, ClientDTO> {
	
	private String name;
	private String document;
	private String birth;
	
	private Integer orderAmount;
	private BigDecimal orderTotal;
	private BigDecimal orderTotalDiscount;
	
}
