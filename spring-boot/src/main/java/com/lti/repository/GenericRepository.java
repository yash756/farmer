package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository //recommended for Dao classes
public class GenericRepository { //another name for Dao
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	public Object save(Object obj) {
		Object updatedObj = entityManager.merge(obj);
		return updatedObj;
	}
	
	public <E> E fetch(Class<E> clazz, Object pk) {
		E e = entityManager.find(clazz, pk);
		return e;
	}

}
