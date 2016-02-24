package com.softserveinc.ita.redplatform.persistence.listener;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.softserveinc.ita.redplatform.persistence.dao.UserDao;



/**
 * Store current user.
 * @author oleh
 *
 */
@Component
public final class SecurityContext {
   /**
    * LOGGER.
    */
    private static final Logger LOGGER = 
	    			Logger.getLogger(SecurityContext.class);
    
    /**
     * ThreadLocal current user.
     */
    private static final ThreadLocal<User> CURRENT_USER = 
	    				new ThreadLocal<User>();
    /**
     * userDao.
     */
    private static UserDao userDao;
    
    /**
     * Constructor.
     * @param newUserDao the newUserDao
     */
    @Autowired
    public SecurityContext(final UserDao newUserDao) {
	SecurityContext.userDao = newUserDao;
    }
    
    /**
     * 
     * @param user the user
     */
   public void set(final User user) {
       CURRENT_USER.set(user); 
       LOGGER.info(user.toString());
   }
   
   /**
    * Get user entity.
    * @return user
    */
   public static com.softserveinc.ita.redplatform.common.entity.User get() {
       com.softserveinc.ita.redplatform.common.entity.User user = 
	       userDao.findUserByEmail(CURRENT_USER.get().getUsername());
       LOGGER.info("in Security context get" + user.getEmail());
    return user;
   }

}
