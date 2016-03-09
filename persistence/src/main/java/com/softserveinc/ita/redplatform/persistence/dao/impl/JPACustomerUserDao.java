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
     * Search fields string.
     */
    private final String searchFields = "customer.email like :search"
		+ " or customer.firstName like :search"
		+ " or customer.lastName like :search"
		+ " or customer.createdDate like :search"
		+ " or customer.updatedDate like :search"
		+ " or customer.passport like:search"
		+ " or customer.individualTaxNumber like :search"
		+ " or customer.phone like :search";
    /**
     * Search query.
     */
    private final String searchQuery = CustomerUser.class.getName() 
	    + " as customer where " 
	    + searchFields;
    
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
			+ searchQuery)
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
		.createQuery("select count(*) from "
			+ searchQuery)
		.setParameter("search", predicate.getSearch() + "%")
		.getSingleResult();
    }

    /**
     * Get customer user by email.
     * @param email user mail
     * @return customer user
     */
    @Override
    public final CustomerUser getCustomerUserByEmail(final String email) {
	return (CustomerUser) getEntityManager()	
		.createQuery("select customer from "
			+ CustomerUser.class.getName()
			+ " as customer where customer.email =:email")
		.setParameter("email", email)
		.getSingleResult();
    }
    
    /**
     * Update customer user without updating email and password.
     * @param customer user
     * @return customer
     */
    public final CustomerUser updateCustomerFields(
	    final CustomerUser customer) {
	CustomerUser entity = findById(customer.getId());
	customer.setEmail(entity.getEmail());
	customer.setPassword(entity.getPassword());
	update(customer);
	return customer;
    }
    
}
