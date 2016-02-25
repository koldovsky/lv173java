package com.softserveinc.ita.redplatform.persistence.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.redplatform.common.entity.CustomerUser;
import com.softserveinc.ita.redplatform.common.predicate.DataTablePredicate;
import com.softserveinc.ita.redplatform.persistence.dao.CustomerUserDao;

/**
 * Implementation for CustomerUser Dao.
 * 
 * @author Hryhorii Somyk
 */
@Repository
public class JPACustomerUserDao extends JPAGenericDao<CustomerUser, Long>
	implements CustomerUserDao {

    /**
     * find all customer users using predicate.
     * 
     * @param predicate predicate
     * @return User list
     */
    @SuppressWarnings("unchecked")
    @Override
    public final List<CustomerUser> findAll(
	    final DataTablePredicate predicate) {
	return (List<CustomerUser>) getEntityManager()
		.createQuery("select customer from "
			+ CustomerUser.class.getName()
			+ " where customer.email like :search"
			+ " or customer.firsName like :search"
			+ " or customer.lastName like :search"
			+ " or customer.createdDate like :search"
			+ " or customer.updatedDate like :search"
			+ " or customer.passport like:search"
			+ " or customer.individualTaxNumber like :search"
			+ " or customer.phone like :search")
		.setParameter("search", predicate.getSearch() + "%")
		.setFirstResult(predicate.getStart())
		.setMaxResults(predicate.getLength())
		.getResultList();
    }

    /**
     * count all customer users.
     * 
     * @return count
     */
    @Override
    public final long countAll() {
	return (long) getEntityManager()
		.createQuery("select count(*) from "
			+ CustomerUser.class.getName())
		.getSingleResult();
    }

    /**
     * count all customer users with predicate.
     * 
     * @param predicate predicate
     * @return count
     */
    @Override
    public final long countAll(final DataTablePredicate predicate) {
	return (long) getEntityManager()
		.createQuery("select customer from "
			+ CustomerUser.class.getName()
			+ " where customer.email like :search"
			+ " or customer.firsName like :search"
			+ " or customer.lastName like :search"
			+ " or customer.createdDate like :search"
			+ " or customer.updatedDate like :search"
			+ " or customer.passport like:search"
			+ " or customer.individualTaxNumber like :search"
			+ " or customer.phone like :search")
		.setParameter("search", predicate.getSearch() + "%")
		.getSingleResult();
    }

}
