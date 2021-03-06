package com.softserveinc.ita.redplatform.persistence.dao;

import java.util.List;

import com.softserveinc.ita.redplatform.common.entity.User;
import com.softserveinc.ita.redplatform.common.predicate.DataTablePredicate;

/**
 * DAO implementation for User.
 * 
 * @author Oleh Khimka
 */
public interface UserDao extends GenericDao<User, Long> {

	/**
	 * find user by email.
	 * 
	 * @param email
	 *            user email
	 * @return User
	 */
	User findUserByEmail(String email);

	/**
	 * find user by company.
	 * 
	 * @param email
	 *            company admin email
	 * @param predicate predicate
	 * @return User
	 */
	List<User> findCompanyUsersByCompanyAdmin(String email, 
			DataTablePredicate predicate);

	/**
	 * find customer by company.
	 * 
	 * @param companyName company name
	 * @return User
	 */
	List<User> findCustomersByCompany(String companyName);

	/**
	 * find all users usning predicates.
	 * 
	 * @param predicate prediacte
	 * @return User
	 */
	List<User> findAll(DataTablePredicate predicate);
	
	/**
	 * count all users.
	 * @return count
	 */
	long countAll();
	/**
	 * count all users with predicate.
	 * @param predicate predicate
	 * @return count
	 */
	long countAll(DataTablePredicate predicate);
	
	/**
	 * count all company users.
	 * @param email Admin email
	 * @return count
	 */
	long countAllCompanyUsers(String email);
	/**
	 * count all company users with predicate.
	 * @param email Admin email
	 * @param predicate predicate
	 * @return count
	 */
	long countAllCompanyUsers(String email, DataTablePredicate predicate);

}
