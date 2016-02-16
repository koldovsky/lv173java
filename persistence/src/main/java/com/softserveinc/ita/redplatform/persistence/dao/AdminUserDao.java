package com.softserveinc.ita.redplatform.persistence.dao;

import com.softserveinc.ita.redplatform.common.entity.AdminUser;

/**
 * Dao interface for Adminuser entity.
 * @author Bulhakov Alex
 *
 */
public interface AdminUserDao extends GenericDao<AdminUser, Long> {
    
    /**
     * This method returns Admin User. 
     *
     * @param email the email
     * @return email
     */
    AdminUser findUserByEmail(final String email);

}
