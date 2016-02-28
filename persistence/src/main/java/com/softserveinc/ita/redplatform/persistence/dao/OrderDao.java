package com.softserveinc.ita.redplatform.persistence.dao;

import com.softserveinc.ita.redplatform.common.entity.Order;

/**
 * Dao interface for Order entity.
 * 
 * @author Bulhakov Alex
 *
 */
public interface OrderDao extends GenericDao<Order, Long> {

    /**
     * OrderDao saveWithId method.
     * @param order
     *            Order entity
     * @return Long id of an order
     */
    Order saveWithId(Order order);

}