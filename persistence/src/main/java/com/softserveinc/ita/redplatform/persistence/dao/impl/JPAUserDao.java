package com.softserveinc.ita.redplatform.persistence.dao.impl;

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
@Repository("userDao")
public class JPAUserDao extends JPAGenericDao<User, Long> implements UserDao {

	/**
	 * method find user by email.
	 */
	@Override
	public final User findUserByEmail(final String email) {
		List list = getEntityManager()
				.createQuery("from "
						+ User.class.getName()
						+ " as user where user.email=:email")
				.setParameter("email", email).getResultList();
		if (list.isEmpty()) {
		    return null;
		}
		return (User) list.get(0);
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
		return (List<User>) getEntityManager()
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
		return (List<User>) getEntityManager()
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
	@SuppressWarnings("unchecked")
	@Override
	public final List<User> findUsersByCompany(final String companyName) {
		return (List<User>) getEntityManager()
				.createQuery("select user from "
						+ User.class.getName()
						+ " as user where user.id in ("
						+ " select customer.id from "
						+ CustomerUser.class.getName()
						+ " as customer inner join"
						+ " customer.orders as order"
						+ " where order.createdBy.id in"
						+ " ( select admin.id from "
						+ RealEstateAdminUser.class.getName()
						+ " as admin inner join admin.agency"
						+ " as agency where agency.name=:companyName))"
						+ " or user.id in ("
						+ " select admin.id from "
						+ RealEstateAdminUser.class.getName()
						+ " as admin inner join admin.agency"
						+ " as agency where agency.name=:companyName )")
				.setParameter("companyName", companyName)
				.getResultList();
	}
}

