package com.softserveinc.ita.redplatform.persistence.listener;


import org.springframework.security.core.userdetails.User;

import com.softserveinc.ita.redplatform.persistence.dao.UserDao;



/**
 * Store current user.
 * @author oleh
 *
 */
public final class SecurityContext {
    
    /**
     * ThreadLocal current user.
     */
    public static final ThreadLocal<User> CURRENT_USER = 
	    				new ThreadLocal<User>();
    /**
     * ThreadLocal user Dao.
     */
    public static final ThreadLocal<UserDao> USER_DAO = 
				new ThreadLocal<UserDao>();
    
    /**
     * private Constructor.
     */
    private SecurityContext() {	
    }
    
    
        
}
