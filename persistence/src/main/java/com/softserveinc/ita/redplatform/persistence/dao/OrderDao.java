package com.softserveinc.ita.redplatform.persistence.dao;

import java.util.List;

import com.softserveinc.ita.redplatform.common.entity.Order;

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
     * @return the order list
     */
    List<Order> loadOrders(String userMail);

    /**
     * Gets the agency name.
     *
     * @param orderId the order id
     * @return the agency name
     */
    String getAgencyName(Long orderId);
}