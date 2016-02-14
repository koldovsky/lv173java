package com.softserveinc.ita.redplatform.common.entity.listener;

import com.softserveinc.ita.redplatform.common.entity.User;

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
     * Private Constructor.
     * 
     * all members are static.
     * no need to create
     * example of the class.
     */
    private SecurityContext() { }

}
