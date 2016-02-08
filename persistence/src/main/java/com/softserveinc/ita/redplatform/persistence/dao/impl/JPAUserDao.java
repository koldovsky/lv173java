package com.softserveinc.ita.redplatform.persistence.dao.impl;

import javax.persistence.NoResultException;
import org.springframework.stereotype.Repository;

import com.softserveinc.ita.redplatform.common.entity.User;
import com.softserveinc.ita.redplatform.persistence.dao.UserDao;
/**
 * DAO for User.
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
	    return (User) entityManager
		    .createNamedQuery("FROM User WHERE email=:email")
		    .setParameter("email", email).getSingleResult();
	} catch (NoResultException e) {
	    return null;
	}
    }

}
