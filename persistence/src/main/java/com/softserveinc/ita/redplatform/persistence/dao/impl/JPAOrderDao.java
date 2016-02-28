package com.softserveinc.ita.redplatform.persistence.dao.impl;

import org.springframework.stereotype.Repository;
import com.softserveinc.ita.redplatform.common.entity.Order;
import com.softserveinc.ita.redplatform.persistence.dao.OrderDao;

/**
 * Implementation of OrderDao.
 * 
 * @author Bulhakov Alex
 *
 */
@Repository
public class JPAOrderDao extends JPAGenericDao<Order, Long>
	implements OrderDao {

    /**
     * Implementation of orderDao saveWithId method.
     * 
     * @param order
     *            Order entity
     * @return Long id of an order
     */
    public final Order saveWithId(final Order order) {
	getEntityManager().persist(order);
	getEntityManager().flush();
	return order;
    }

}