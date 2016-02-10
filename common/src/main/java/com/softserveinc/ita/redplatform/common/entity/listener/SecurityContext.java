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
    private static ThreadLocal<User> currentUser = new ThreadLocal<User>();

    /**
     * get current filter.
     * @return user
     */
    public static User getCurrentUser() {
	User user = currentUser.get();
	if (user == null) {
	    throw new IllegalStateException("No user is currently signed in");
	}
	return user;
    }
    
    /**
     * set user.
     * @param user user
     */
    public static void setCurrentUser(final User user) {
	currentUser.set(user);
    }
    /**
     * Private Constructor.
     * 
     * all members are static.
     * no need to create
     * example of the class.
     */
    private SecurityContext() { }
}
