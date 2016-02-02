package com.softserveinc.ita.redplatform.persistence.dao;

import java.util.List;


/**
 * This interface describes Generic Dao.
 *
 * @param <E> Type Of Entity accepts class.
 * 
 * @param <N> Id Type
 * 
 * @author Oleh Khimka
 *            
 */
public interface GenericDao<E, N> {
    
    
    /**
     * Find object based on the V Id.
     * 
     * @param id
     *            Find object based on the Id.
     * @return T entity.
     */
    E findById(N id);

    /**
     * Create a new entity.
     * 
     * @param entity
     *            Entity to be created.
     */
    void save(E entity);

    /**
     * Delete T type.
     * 
     * @param entity
     *            the object to be deleted from DB.
     */
    void remove(E entity);

    /**
     * Update information T entity.
     * 
     * @param entity
     *            object T entity to be updated.
     *            
     * @return updated entity.
     */
    E update(E entity);

    
    /**
     * Get Entity from database.
     * 
     * @return a list of all the elements in Entity.
     */
    List<E> findAll();
}
