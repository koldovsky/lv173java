package com.softserveinc.ita.redplatform.persistence.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import org.springframework.stereotype.Repository;

import com.softserveinc.ita.redplatform.common.entity.RealEstateAdminUser;
import com.softserveinc.ita.redplatform.common.entity.User;
import com.softserveinc.ita.redplatform.persistence.dao.UserDao;

/**
 * DAO for User.
 * 
 * @author oleh
 *
 */
@Repository
public class JPAUserDao extends JPAGenericDao<User, Long> implements UserDao {

    /**
     * method find user by email.
     */
    @Override
    public final User findUserByEmail(final String email) {
	try {
	    return (User) super.getEntityManager()
		    .createNamedQuery("FROM User WHERE email=:email")
		    .setParameter("email", email).getSingleResult();
	} catch (NoResultException e) {
	    return null;
	}
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
	return (List<User>) super.getEntityManager()
		.createQuery("from " + RealEstateAdminUser.class.getName() 
			+ " as redadmin inner join redadmin.agency "
			+ "as agency where agency.name=:companyName")
		.setParameter("companyName", companyName).getResultList();
    }
}