package com.softserveinc.ita.redplatform.persistence.dao;

import java.util.List;

import com.softserveinc.ita.redplatform.common.entity.User;

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
	 * @param company
	 *            user companyName
	 * @return User
	 */
	List<User> findUsersByCompany(String company);

	/**
	 * find admin by company.
	 * 
	 * @param companyName company name
	 * @return User
	 */
	List<User> findAdminsByCompany(String companyName);

	/**
	 * find customer by company.
	 * 
	 * @param companyName company name
	 * @return User
	 */
	List<User> findCustomersByCompany(String companyName);
}
