package com.softserveinc.ita.redplatform.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import 
org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.softserveinc.ita.redplatform.business.service.UserService;
import com.softserveinc.ita.redplatform.common.entity.User;
import com.softserveinc.ita.redplatform.common.entity.listener.SecurityContext;


/**
 * Filter that set current user.
 * 
 * @author oleh
 *
 */
public class UserFilter implements Filter {
    
    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(UserFilter.class);

    /**
     * userService.
     */
    private UserService userService;

    /**
     * get user and set to SecurityContext.
     */
    @Override
    public final void doFilter(final ServletRequest req, 
	    final ServletResponse res, final FilterChain chain)
		    	throws IOException, ServletException {
	
	Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
	if (!(auth instanceof AnonymousAuthenticationToken)) {
	         String userName =  auth.getName();
	         User user = (User) userService.loadUserByEmail(userName);
	 	 SecurityContext.CURRENT_USER.set(user);
	 	 LOGGER.info("Current User - " + user.getEmail());
	}
	
	chain.doFilter(req, res);

    }

    /**
     * init filter.
     */
    @Override
    public final void init(final FilterConfig arg0) throws ServletException {
	LOGGER.info("userFilter init");
    }

    /**
     * destroy filter.
     */
    @Override
    public final void destroy() {
    }
    
    public final UserService getUserService() {
        return userService;
    }

    public final void setUserService(final UserService newUserService) {
        this.userService = newUserService;
    }

}