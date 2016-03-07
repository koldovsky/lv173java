package com.softserveinc.ita.redplatform.persistence.context;


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
    public static final ThreadLocal<String> CURRENT_USER_MAIL = 
	    				new ThreadLocal<String>();
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
