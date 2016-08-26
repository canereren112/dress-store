package com.eren.assignment.sahibinden.dao.jpa;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.eren.assignment.sahibinden.dao.BaseDao;

public abstract class BaseDaoJpa<E> implements BaseDao<E> {
	@PersistenceContext
	private EntityManager entityManager;

	private Class<E> type;

	public BaseDaoJpa() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	public void update(E entity) {
		getEntityManager().merge(entity);

	}

	public void save(E entity) {
		getEntityManager().persist(entity);

	}

	public E findById(long id) {
		return (E) getEntityManager().find(type, id);
	}

	public void delete(long id) {
		E entity = getEntityManager().getReference(type, id);
		getEntityManager().remove(entity);

	}
}
