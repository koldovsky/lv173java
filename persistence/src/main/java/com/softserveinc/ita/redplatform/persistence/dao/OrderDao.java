package com.softserveinc.ita.redplatform.persistence.dao;

import java.util.List;

import com.softserveinc.ita.redplatform.common.entity.Order;
import com.softserveinc.ita.redplatform.common.predicate.DataTablePredicate;


/**
 * Dao interface for Order entity.
 * 
 * @author Bulhakov Alex
 *
 */
public interface OrderDao extends GenericDao<Order, Long> {
    
    /**
     * Gets the company orders.
     *
     * @param email the current user's email
     * @param predicate the predicate
     * @return the company orders
     */
    List<Order> loadCompanyOrders(String email, DataTablePredicate predicate);
    
    /**
     * Count company orders.
     *
     * @param email the current user's email
     * @return the long
     */
    Long countCompanyOrders(String email);


}