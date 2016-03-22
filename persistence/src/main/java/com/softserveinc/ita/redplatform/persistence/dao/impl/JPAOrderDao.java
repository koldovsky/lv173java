package com.softserveinc.ita.redplatform.persistence.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.redplatform.common.entity.Order;
import com.softserveinc.ita.redplatform.common.entity.RealEstateAdminUser;
import com.softserveinc.ita.redplatform.common.predicate.DataTablePredicate;
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
     * Base query for retrieving orders of a company.
     */
    private final String ordersBaseQuery = "from " + Order.class.getName() 
	    + " as customOrder"
	    + " where customOrder.customerUser.email = :email or"
	    + " customOrder.createdBy.agency = "
	    + "(select admin.agency from "
	    + RealEstateAdminUser.class.getName()
	    + " as admin where" + " admin.email = :email)";

    /**
     * Method get order by id and user email. Method check if user has access to
     * the order then return order, else return null.
     * 
     * @param id
     *            order id
     * @param email
     *            user email
     * @return order order
     */
    @Override
    public final Order getOrder(final Long id, final String email) {
	@SuppressWarnings("unchecked")
	List<Order> list = (List<Order>) getEntityManager()
		.createQuery(
			ordersBaseQuery
				+ " and customOrder.id = :id")
		.setParameter("id", id).setParameter("email", email)
		.getResultList();
	if (!list.isEmpty()) {
	    return list.get(0);
	}
	return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public final List<Order> loadOrders(final String userMail,
	    final DataTablePredicate predicate) {
	return (List<Order>) getEntityManager()
		.createQuery(ordersBaseQuery).setParameter("email", userMail)
		.getResultList();
    }
}