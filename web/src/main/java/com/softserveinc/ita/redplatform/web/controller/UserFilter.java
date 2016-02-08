package com.softserveinc.ita.redplatform.web.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.beans.factory.annotation.Autowired;
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
@WebFilter(filterName = "UserFilter")
public class UserFilter implements Filter {

    /**
     * userService.
     */
    @Autowired
    private UserService userService;

    /**
     * get user and set to SecurityContext.
     */
    @Override
    public final void doFilter(final ServletRequest req, 
	    final ServletResponse res, final FilterChain chain)
	    throws IOException, ServletException {
	
	String email = (String) SecurityContextHolder.getContext()
                 .getAuthentication().getPrincipal();
	User user;
	try{
	    user = (User) userService.loadUserByEmail(email);
	    SecurityContext.setCurrentUser(user);
	}
	catch(NullPointerException e) {
		SecurityContext.setCurrentUser(null);
	}

	

	chain.doFilter(req, res);

    }

    /**
     * init filter.
     */
    @Override
    public void init(final FilterConfig arg0) throws ServletException {
	// Do nothing
    }

    /**
     * destroy filter.
     */
    @Override
    public final void destroy() {
	SecurityContext.setCurrentUser(null);
    }

}
