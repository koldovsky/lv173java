package com.softserveinc.ita.redplatform.persistence.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.softserveinc.ita.redplatform.common.entity.CustomerUser;
import com.softserveinc.ita.redplatform.common.entity.RealEstateAdminUser;
import com.softserveinc.ita.redplatform.common.entity.User;
import com.softserveinc.ita.redplatform.common.predicate.DataTablePredicate;
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
		return getSingleResult(list);
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
	 * @param email
	 * @return List<User>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public final List<User> findCompanyUsersByCompanyAdmin(final String email, 
			final DataTablePredicate predicate) {
		String orderField;
		if (predicate.getColumn() == 0) {
			orderField = "user.firstName " 
					+ predicate.getOrder() + ", user.lastName";
		} else if (predicate.getColumn() == 1) {
			orderField = "user.email";
		} else if (predicate.getColumn() == 2) {
			orderField = "user.phone";
		} else {
			orderField = "user.createdDate";
		}
		String orderDirection;
		if (predicate.getOrder().equalsIgnoreCase("desc")) {
			orderDirection = "desc";
		} else {
			orderDirection = "asc";
		}
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
						+ " as agency where agency ="
						+ " (select adminuser.agency from "
						+ RealEstateAdminUser.class.getName()
						+ " as adminuser where adminuser.email =:email )))"
						+ " and ( user.email like :search"
						+ " or user.createdDate like :search"
						+ " or user.phone like :search"
						+ " or user.lastName like :search"
						+ " or user.firstName like :search )"
						+ " or user.id in ("
						+ " select admin.id from "
						+ RealEstateAdminUser.class.getName()
						+ " as admin inner join admin.agency"
						+ " as agency where agency ="
						+ " (select adminuser.agency from "
						+ RealEstateAdminUser.class.getName()
						+ " as adminuser where adminuser.email =:email ))"
						+ " and ( user.email like :search"
						+ " or user.createdDate like :search"
						+ " or user.phone like :search"
						+ " or user.lastName like :search"
						+ " or user.firstName like :search )"
						+ " order by " + orderField
						+ " " + orderDirection)
				.setParameter("email", email)
				.setParameter("search", predicate.getSearch() + "%")
				.setFirstResult(predicate.getStart())
				.setMaxResults(predicate.getLength())
				.getResultList();
	}
	/**
	 * @param predicate predicate.
	 * @return User
	 */
	@SuppressWarnings("unchecked")
	@Override
	public final List<User> findAll(final DataTablePredicate predicate) {
		String orderField;
		if (predicate.getColumn() == 0) {
			orderField = "user.firstName " 
					+ predicate.getOrder() + ", user.lastName";
		} else if (predicate.getColumn() == 1) {
			orderField = "user.email";
		} else if (predicate.getColumn() == 2) {
			orderField = "user.phone";
		} else {
			orderField = "user.createdDate";
		}
		String orderDirection;
		if (predicate.getOrder().equalsIgnoreCase("desc")) {
			orderDirection = "desc";
		} else {
			orderDirection = "asc";
		}
		return (List<User>) getEntityManager()
				.createQuery("select user from "
						+ User.class.getName()
						+ " as user where user.email like :search"
						+ " or user.createdDate like :search"
						+ " or user.phone like :search"
						+ " or user.lastName like :search"
						+ " or user.firstName like :search"
						+ " order by " + orderField
						+ " " + orderDirection)
				.setParameter("search", predicate.getSearch() + "%")
				.setFirstResult(predicate.getStart())
				.setMaxResults(predicate.getLength())
				.getResultList();

	}
	
	/**
	 * Count all Users.
	 * @return count of users
	 */
	public final long countAll() {
		return (long) getEntityManager()
				.createQuery("select count(*) from "
						+ User.class.getName())
				.getSingleResult();
	}
	
	/**
	 * Count all Users with predicate.
	 * @param predicate predicate
	 * @return count of users
	 */
	public final long countAll(final DataTablePredicate predicate) {
		return (long) getEntityManager()
				.createQuery("select count(*) from "
						+ User.class.getName()
						+ " as user where user.email like :search"
						+ " or user.createdDate like :search"
						+ " or user.phone like :search"
						+ " or user.lastName like :search"
						+ " or user.firstName like :search")
				.setParameter("search", predicate.getSearch() + "%")
				.getSingleResult();
	}
	
	/**
	 * Count all Users.
	 * @param email company admin email
	 * @return count of users
	 */
	public final long countAllCompanyUsers(final String email) {
		return (long) getEntityManager()
				.createQuery("select count(*) from "
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
						+ " as agency where agency ="
						+ " (select adminuser.agency from "
						+ RealEstateAdminUser.class.getName()
						+ " as adminuser where adminuser.email =:email )))"
						+ " or user.id in ("
						+ " select admin.id from "
						+ RealEstateAdminUser.class.getName()
						+ " as admin inner join admin.agency"
						+ " as agency where agency ="
						+ " (select adminuser.agency from "
						+ RealEstateAdminUser.class.getName()
						+ " as adminuser where adminuser.email =:email ))")
				.setParameter("email", email)
				.getSingleResult();
	}
	
	/**
	 * Count all Users.
	 * @param email company admin email
	 * @param predicate predicate
	 * @return count of users
	 */
	public final long countAllCompanyUsers(final String email, 
			final DataTablePredicate predicate) {
		return (long) getEntityManager()
				.createQuery("select count(*) from "
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
						+ " as agency where agency ="
						+ " (select adminuser.agency from "
						+ RealEstateAdminUser.class.getName()
						+ " as adminuser where adminuser.email =:email )))"
						+ " and ( user.email like :search"
						+ " or user.createdDate like :search"
						+ " or user.phone like :search"
						+ " or user.lastName like :search"
						+ " or user.firstName like :search )"
						+ " or user.id in ("
						+ " select admin.id from "
						+ RealEstateAdminUser.class.getName()
						+ " as admin inner join admin.agency"
						+ " as agency where agency ="
						+ " (select adminuser.agency from "
						+ RealEstateAdminUser.class.getName()
						+ " as adminuser where adminuser.email =:email ))"
						+ " and ( user.email like :search"
						+ " or user.createdDate like :search"
						+ " or user.phone like :search"
						+ " or user.lastName like :search"
						+ " or user.firstName like :search )")
				.setParameter("email", email)
				.setParameter("search", predicate.getSearch() + "%")
				.getSingleResult();
	}
	
	
}

