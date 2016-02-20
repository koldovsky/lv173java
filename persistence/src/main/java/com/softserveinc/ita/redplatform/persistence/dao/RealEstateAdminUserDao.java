package com.softserveinc.ita.redplatform.persistence.dao;

import com.softserveinc.ita.redplatform.common.entity.RealEstateAdminUser;

/**
 * The interface RealEstateAdminUserDao.
 * 
 * @author Ilona Yavorska
 */
public interface RealEstateAdminUserDao 
			extends GenericDao<RealEstateAdminUser, Long> {

    /**
     * Find user by email.
     *
     * @param email the email
     * @return the real estate admin user
     */
    RealEstateAdminUser findUserByEmail(String email);
	
}