package com.clyhs.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;

import com.clyhs.dao.BaseDao;

public class BaseDaoImpl<T,PK extends Serializable ,DaoImpl extends BaseDao<T ,PK>> extends HibernateDaoSupport implements BaseDao<T ,PK> {

	private Class<T> clazz; 
	
	
	protected BaseDaoImpl(){}
	
	@SuppressWarnings("unchecked")
	protected Class getEntityClass() {
        if (clazz == null) {
        	clazz = (Class<T>) ((ParameterizedType) getClass()
                    .getGenericSuperclass()).getActualTypeArguments()[0];
            logger.debug("T class = " + clazz.getName());
            
        }
        
        return clazz;
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		// TODO Auto-generated method stub
		return (List<T>) getHibernateTemplate().loadAll(getEntityClass());
	}



	@SuppressWarnings("unchecked")
	@Override
	public T getById( PK id) {
		// TODO Auto-generated method stub
		Assert.notNull(id, "id 不可空!");  
		return (T) getHibernateTemplate().get(getEntityClass(), id);
	}

	

	@Override
	public void remove(PK id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(getById(id));
	}

	@Override
	public void remove(T t) {
		// TODO Auto-generated method stub
		Assert.notNull(t, "t 不可空!");  
		getHibernateTemplate().delete(t);  
	}

	@SuppressWarnings("unchecked")
	@Override
	public T save(T t) {
		// TODO Auto-generated method stub
		Assert.notNull(t, "t 不可空!"); 
		return (T) getHibernateTemplate().save(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByHql(String hql) {
		// TODO Auto-generated method stub
		return getSession().createQuery(hql).list();
	}
	
	
	
	

	
}
