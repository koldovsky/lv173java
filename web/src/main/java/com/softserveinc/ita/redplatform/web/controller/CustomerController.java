package com.softserveinc.ita.redplatform.web.controller;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Customer page controller.
 * 
 * @author Hryhorii Somyk
 */

@Controller
public class CustomerController {

    /**
     * registerCustomer page mapping.
     * 
     * @return customer registration page
     */
    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public final String getRegisterPage() {
	Collection<GrantedAuthority> authorities = 
		(Collection<GrantedAuthority>) SecurityContextHolder.getContext()
		.getAuthentication().getAuthorities();
	if (authorities.contains(new SimpleGrantedAuthority("ROLE_REDADMIN"))) {
	    return "register/customer";
	}
	return "common/index";
    }
    
    /**
     * Edit customer page mapping.
     * @return edit customer page
     */
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public final String getEditPage() {
	return "edit/customer";
    }
    
}
