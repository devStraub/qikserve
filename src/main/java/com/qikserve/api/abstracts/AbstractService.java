package com.qikserve.api.abstracts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;

/**
 * @author michel.pech
 */

@Service
public abstract class AbstractService<E extends PersistenceInterface<ID>, ID, DTO> {

	@Autowired
	private JpaRepository<E, ID> abstractJPA;
	
	@Getter
	@Setter
	@Autowired
	private AbstractDTO<E, DTO> abstractDTO;

    @Transactional
	public List<E> findAll() {
		return abstractJPA.findAll();
	}

	@Transactional
	public E findById(ID id) {
		return abstractJPA.findById(id).orElse(null);
	}

	@Transactional
	public E insert(E entity) {
        return abstractJPA.saveAndFlush(entity);
	}

	@Transactional
	public E update(E entity) {
		return abstractJPA.saveAndFlush(entity);
	}

	@Transactional
	public void deleteById(ID id) {
		abstractJPA.deleteById(id);
	}

}
