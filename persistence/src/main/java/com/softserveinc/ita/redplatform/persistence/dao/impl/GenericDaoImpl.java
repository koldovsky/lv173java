package com.softserveinc.ita.redplatform.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.redplatform.persistence.dao.GenericDao;

/**
 * Implementation of Generic DAO.
 *
 * @param <E>  Type Of Entity
 *            
 * @param <N>  Id Type
 * 
 * @author Oleh Khimka
 *            
 */

@Transactional
public abstract class GenericDaoImpl<E, N extends Number> 
				implements GenericDao<E, N> {

    /**
     * Actual type of arguments.
     */
    private Class<E> entityClass;

   
    /**
     * Entity manager is used to create / update / remove / find persistent
     * entity instances, and to query over entities.
     */
    @PersistenceContext
    private EntityManager entityManager;
    
    /**
     * Single public constructor.
     * gets the generic type at runtime.
     * 
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public GenericDaoImpl() {
	 Type t = getClass().getGenericSuperclass();
	 ParameterizedType pt = (ParameterizedType) t;
	 entityClass = (Class) pt.getActualTypeArguments()[0];
    }
       
    @Override
    public final E findById(final N id) {
	return entityManager.find(entityClass, id);
    }

    @Override
    public final void save(final E entity) {
	entityManager.persist(entity);
	entityManager.flush();
    }

    @Override
    public final void remove(final E entity) {
	entityManager.remove(entityManager.merge(entity));
    }

    @Override
    public final E update(final E entity) {
	return entityManager.merge(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public final List<E> findAll() {
	return entityManager.createQuery("from " + entityClass.getSimpleName())
		.getResultList();
    }

}
