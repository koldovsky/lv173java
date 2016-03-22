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
     * Method get order by id and user email. Method check if current user has
     * access to the order.
     * 
     * @param id
     *            order id
     * @param email
     *            user email
     * @return order order
     */
    Order getOrder(Long id, String email);

    /**
     * Load orders.
     *
     * @param userMail the user mail
     * @param predicate the predicate
     * @return the order list
     */
    List<Order> loadOrders(String userMail, DataTablePredicate predicate);
}