package com.softserveinc.ita.redplatform.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.redplatform.common.entity.RealEstateAdminUser;
import com.softserveinc.ita.redplatform.persistence.dao.RealEstateAdminUserDao;

/**
 * The class JPARealEstateAdminDao.
 * 
 * @author Ilona Yavorska
 */
@Repository
public class JPARealEstateAdminUserDao 
		extends JPAGenericDao<RealEstateAdminUser, Long> 
		implements RealEstateAdminUserDao {
    
}
