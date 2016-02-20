package com.softserveinc.ita.redplatform.persistence.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.redplatform.persistence.dao.RealEstateAdminUserDao;
import com.softserveinc.ita.redplatform.common.entity.RealEstateAdminUser;

/**
 * The class JPARealEstateAdminDao.
 * 
 * @author Ilona Yavorska
 */
@Repository
public class JPARealEstateAdminUserDao 
		extends JPAGenericDao<RealEstateAdminUser, Long> 
		implements RealEstateAdminUserDao {
    
    @Override
    public final RealEstateAdminUser findUserByEmail(final String email) {
	List<RealEstateAdminUser> users = getEntityManager()
		.createQuery("from " + RealEstateAdminUser.class.getName()
			+ " as user where user.email=:email")
		.setParameter("email", email).getResultList();
	return getSingleResult(users);
    }
}
