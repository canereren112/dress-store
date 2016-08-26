package com.eren.dstore.dao;

public interface BaseDao<E> {
	public void update(E entity);

	public void save(E entity);

	public E findById(long id);

	public void delete(long id);
}
