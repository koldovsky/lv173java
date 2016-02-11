package com.softserveinc.ita.redplatform.persistence.dao.impl;

import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.softserveinc.ita.redplatform.common.entity.CustomerUser;
import com.softserveinc.ita.redplatform.common.entity.RealEstateAdminUser;
import com.softserveinc.ita.redplatform.common.entity.User;
import com.softserveinc.ita.redplatform.persistence.dao.UserDao;

/**
 * DAO for User.
 * 
 * @author Hryhorii Somyk
 *
 */
@Repository
public class JPAUserDao extends JPAGenericDao<User, Long> implements UserDao {

	/**
	 * method find user by email.
	 */
	@Override
	public final User findUserByEmail(final String email) {
		return (User) super.getEntityManager()
				.createQuery("from "
						+ User.class.getName()
						+ " as user where user.email=:email")
				.setParameter("email", email).getSingleResult();
	}

	/**
	 * method find all company admins.
	 * 
	 * @param companyName
	 *            company name
	 * @return List<User>
	 */
	@Override
	@SuppressWarnings("unchecked")
	public final List<User> findAdminsByCompany(final String companyName) {
		return (List<User>) super.getEntityManager()
				.createQuery("from " + RealEstateAdminUser.class.getName()
						+ " as user where user.id in (select redadmin.id from "
						+ RealEstateAdminUser.class.getName()
						+ " as redadmin inner join redadmin.agency"
						+ " as agency where agency.name=:companyName))")
				.setParameter("companyName", companyName).getResultList();
	}

	/**
	 * method find all company customers.
	 * 
	 * @param companyName
	 *            company name
	 * @return List<User>
	 */
	@Override
	@SuppressWarnings("unchecked")
	public final List<User> findCustomersByCompany(final String companyName) {
		return (List<User>) super.getEntityManager()
				.createQuery("from " + CustomerUser.class.getName()
						+ " as user where user.createdBy.id in"
						+ " ( select redadmin.id from "
						+ RealEstateAdminUser.class.getName()
						+ " as redadmin inner join redadmin.agency"
						+ " as agency where agency.name=:companyName))")
				.setParameter("companyName", companyName).getResultList();
	}

	/**
	 * method find all users dealing with company.
	 * 
	 * @param companyName
	 *            company name
	 * @return List<User>
	 */
	@Override
	public final List<User> findUsersByCompany(final String companyName) {
		List<User> list = new LinkedList<User>();
		List<User> users = findCustomersByCompany(companyName);
		List<User> admins = findAdminsByCompany(companyName);
		list.addAll(admins);
		list.addAll(users);
		return list;
	}
}