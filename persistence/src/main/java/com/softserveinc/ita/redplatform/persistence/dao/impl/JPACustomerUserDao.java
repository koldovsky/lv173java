package com.softserveinc.ita.redplatform.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.redplatform.common.entity.CustomerUser;
import com.softserveinc.ita.redplatform.persistence.dao.CustomerUserDao;

/**
 * Implementation for CustomerUser Dao.
 * 
 * @author Roman Ivaniv
 */
@Repository
public class JPACustomerUserDao extends JPAGenericDao<CustomerUser, Long>
	implements CustomerUserDao {

}
