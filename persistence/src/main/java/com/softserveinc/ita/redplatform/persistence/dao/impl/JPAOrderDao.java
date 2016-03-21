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
		List<Order> list = (List<Order>) getEntityManager()
				.createQuery(
						"from " + Order.class.getName() + " as customOrder "
								+ "where customOrder.id = :id and ( "
								+ "customOrder.customerUser.email = :email or "
								+ "customOrder.createdBy.agency = "
								+ "(select admin.agency from "
								+ RealEstateAdminUser.class.getName()
								+ " as admin where" + " admin.email = :email))")
				.setParameter("id", id).setParameter("email", email)
				.getResultList();
		if (!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

}