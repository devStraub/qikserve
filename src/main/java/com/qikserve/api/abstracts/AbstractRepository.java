package com.qikserve.api.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.Getter;

/**
 * @author michel.pech
 */

@Component
public class AbstractRepository<E, ID>  {
	
	@Getter
	private JpaRepository<E, ID> jpaDefault;
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<E> findWithNativeQuery(String query, Class<E> clazz) {
		return entityManager.createNativeQuery(query, clazz).getResultList();
	}

}
