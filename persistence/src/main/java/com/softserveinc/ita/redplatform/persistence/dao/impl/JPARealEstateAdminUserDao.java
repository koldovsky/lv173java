package com.softserveinc.ita.redplatform.persistence.dao.impl;

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
	
}
