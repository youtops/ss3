package com.clyhs.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T , PK extends Serializable> {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	T getById(PK id);
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	T save(T t);
	
	/**
	 * 
	 * @param id
	 */
	void remove(PK id);
	
	/**
	 * 
	 * @param t
	 */
	void remove(final T t);
	
	/**
	 * 
	 * @return
	 */
	List<T> getAll();
	
	List<T> findByHql(String hql);

}
