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
    private final String companyOrdersBaseQuery = Order.class.getName()
	    + " as order" + " where order.id in (select orders.id from "
	    + Order.class.getName() + " as orders inner join  orders.createdBy"
	    + " as admin  where "
	    + "admin.agency = (select currentadmin.agency from "
	    + RealEstateAdminUser.class.getName()
	    + " as currentadmin where currentadmin.email=:email))";

    @SuppressWarnings("unchecked")
    @Override
    public final List<Order> loadCompanyOrders(final String email,
	    final DataTablePredicate predicate) {
	return (List<Order>) getEntityManager()
		.createQuery("select order from " + companyOrdersBaseQuery)
		.setParameter("email", email)
		.setFirstResult(predicate.getStart())
		.setMaxResults(predicate.getLength()).getResultList();
    }

    @Override
    public final Long countCompanyOrders(final String email) {
	return (Long) getEntityManager()
		.createQuery("select count(*) from " + companyOrdersBaseQuery)
		.setParameter("email", email).getSingleResult();

    }

}