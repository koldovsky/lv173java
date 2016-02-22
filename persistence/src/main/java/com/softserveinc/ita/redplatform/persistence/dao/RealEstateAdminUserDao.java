package com.softserveinc.ita.redplatform.persistence.dao;

import java.util.List;

import com.softserveinc.ita.redplatform.common.entity.RealEstateAdminUser;

/**
 * The interface RealEstateAdminUserDao.
 * 
 * @author Hryhorii Somyk
 */
public interface RealEstateAdminUserDao 
                extends GenericDao<RealEstateAdminUser, Long> {
 
    /**
     * method find all company admins.
     * 
     * @param companyName
     *            company name
     * @return List<User>
     * */
    List<RealEstateAdminUser> findAdminsByCompany(final String companyName);
}