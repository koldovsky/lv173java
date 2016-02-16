package com.softserveinc.ita.redplatform.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.softserveinc.ita.redplatform.common.entity.AdminUser;
import com.softserveinc.ita.redplatform.persistence.dao.AdminUserDao;

/**
 * Implementation of AdminUserDao.
 * 
 * @author Bulhakov Alex
 *
 */
@Repository
public class JPAAdminUserDao extends JPAGenericDao<AdminUser, Long> 
       implements AdminUserDao {
    /**
     * 
     * @param email
     *            receiving
     * @return AdminUser object
     */
    public final AdminUser findUserByEmail(final String email) {
	List<AdminUser> users = new ArrayList<AdminUser>();
	users = (List<AdminUser>) super.getEntityManager()
		.createQuery("from " + AdminUser.class.getName()
			+ " as user where user.email=:email")
		.setParameter("email", email).getResultList();
	if (users.size() > 0) {
	    return users.get(0);
	} else {
	    return null;
	}
    }
}
