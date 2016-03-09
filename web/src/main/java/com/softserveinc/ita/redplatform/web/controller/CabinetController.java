package com.softserveinc.ita.redplatform.web.controller;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Cabinet page mapping.
 * @author Hryhorii
 */
@Controller
public class CabinetController {
    
    /**
     * Get cabinet page.
     * @return cabinet page
     */
    @RequestMapping(value  = "/cabinet", method = RequestMethod.GET)
    public final String getCabinet() {
	List<SimpleGrantedAuthority> authorities = 
		(List<SimpleGrantedAuthority>) 
		SecurityContextHolder.getContext().getAuthentication().getAuthorities();
	if (authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
	    return "cabinet/admin";
	} else if (authorities.contains(new SimpleGrantedAuthority(
		"ROLE_REDADMIN"))) {
	    return "cabinet/redadmin";
	}
	return "cabinet/customer";
    }

}
