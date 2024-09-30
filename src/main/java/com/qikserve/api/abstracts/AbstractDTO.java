package com.qikserve.api.abstracts;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author michel.pech
 */

@Getter
@Setter
@Component
public class AbstractDTO<T, DTO> {
	
	private String id;
	
	private Class<T> entityClass;
	private Class<DTO> dtoClass;
	private ModelMapper modelMapper;

	public AbstractDTO() {
		modelMapper = new ModelMapper();
	}
	
	public T dtoToEntity(DTO dto) {
		T entity = modelMapper.map(dto, this.getEntityClass());
		customDtoToEntity(entity);
		return entity;
	}

	public DTO entityToDTO(T entity) {
		DTO dto = modelMapper.map(entity, this.getDtoClass());
		customEntityToDTO(entity);
		return dto;
	}

	public void customDtoToEntity(T entity) {
		
	}
	
	public void customEntityToDTO(T entity) {
		
	}
	
}
