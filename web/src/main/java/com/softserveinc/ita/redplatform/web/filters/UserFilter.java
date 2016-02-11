package com.softserveinc.ita.redplatform.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import com.softserveinc.ita.redplatform.business.service.UserService;


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
    @Autowired
    private UserService userService;

    /**
     * get user and set to SecurityContext.
     */
    @Override
    public final void doFilter(final ServletRequest req, 
	    final ServletResponse res, final FilterChain chain)
	    throws IOException, ServletException {
	
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

}
