package com.softserveinc.ita.redplatform.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication
				.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.softserveinc.ita.redplatform.business.service.UserService;

/**
 * Filter that set current user.
 * 
 * @author oleh
 *
 */
@Component
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

	Authentication auth =
		SecurityContextHolder.getContext().getAuthentication();

	if (!(auth instanceof AnonymousAuthenticationToken)) {
	    userService.setLoggedUser(auth.getName());
	}

	chain.doFilter(req, res);
    }

    /**
     * init filter.
     */
    @Override
    public final void init(final FilterConfig arg0) throws ServletException {
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