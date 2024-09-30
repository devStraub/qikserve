package com.qikserve.api.abstracts;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Hidden;

/**
 * @author michel.pech
 */

@RestController
public abstract class AbstractController<E extends PersistenceInterface<ID>, ID, DTO> {

	@Autowired
	private AbstractService<E, ID, DTO> abstractService;

	@Hidden
	@GetMapping
	public ResponseEntity<List<DTO>> findAll() {
		List<E> entities = abstractService.findAll();
		List<DTO> dtos = entities.stream().map(entity -> abstractService.getAbstractDTO().entityToDTO(entity)).collect(Collectors.toList());
		return ResponseEntity.ok().body(dtos);
	}
	
	@Hidden
	@GetMapping("/{id}")
	public ResponseEntity<DTO> findById(@PathVariable ID id) {
		E entity = abstractService.findById(id);
		if (Objects.nonNull(entity)) {
			DTO dto = abstractService.getAbstractDTO().entityToDTO(entity);
			return ResponseEntity.ok().body(dto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@Hidden
	@PostMapping
	public ResponseEntity<DTO> insert(@RequestBody DTO dto) {
		E entity = abstractService.getAbstractDTO().dtoToEntity(dto);
		E savedEntity = abstractService.insert(entity);
		DTO savedDto = abstractService.getAbstractDTO().entityToDTO(savedEntity);
		return ResponseEntity.ok().body(savedDto);
	}
	
	@Hidden
	@PutMapping
	public ResponseEntity<DTO> update(@RequestBody DTO dto) {
		E entity = abstractService.getAbstractDTO().dtoToEntity(dto);
		E updatedEntity = abstractService.update(entity);
		DTO updatedDto = abstractService.getAbstractDTO().entityToDTO(updatedEntity);
		return ResponseEntity.ok().body(updatedDto);
	}
	
	@Hidden
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable ID id) {
		abstractService.deleteById(id);
		return new ResponseEntity<>("Registro removido com sucesso!", HttpStatus.OK);
	}
}
