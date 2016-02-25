package com.softserveinc.ita.redplatform.persistence.dao;

import java.util.List;

import com.softserveinc.ita.redplatform.common.entity.CustomerUser;
import com.softserveinc.ita.redplatform.common.predicate.DataTablePredicate;

/**
 * Customer user dao interface.
 * 
 * @author Ivaniv Roman
 */
public interface CustomerUserDao extends GenericDao<CustomerUser, Long> {

    /**
     * find all customer users using predicate.
     * 
     * @param predicate predicate
     * @return Customer User list
     */
    List<CustomerUser> findAll(DataTablePredicate predicate);

    /**
     * count all customer users.
     * 
     * @return count
     */
    long countAll();

    /**
     * count customer all users with predicate.
     * 
     * @param predicate predicate
     * @return count
     */
    long countAll(DataTablePredicate predicate);
}
