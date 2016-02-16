package com.softserveinc.ita.redplatform.persistence.dao.impl;

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
}
