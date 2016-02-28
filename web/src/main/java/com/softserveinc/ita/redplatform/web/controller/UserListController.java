package com.softserveinc.ita.redplatform.web.controller;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softserveinc.ita.redplatform.business.service.UserService;

/**
 * Controller for users page.
 * 
 * @author Hryhorii Somyk
 *
 */

@Controller
public class UserListController {

    /**
     * Logger for User List Controller class.
     */
    public static final Logger LOGGER = Logger.getLogger(
        UserListController.class);
	/**
	 * User Service.
	 */
	@Autowired
	private UserService userService;

	/**
	 * Users page mapping.
	 * 
	 * @return users page
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public final String getUsersPage() {
		Authentication auth = SecurityContextHolder
				.getContext()
				.getAuthentication();
		if (auth instanceof AnonymousAuthenticationToken) {
			return "common/login";
		} else {
			Collection<GrantedAuthority> authorities = 
					(Collection<GrantedAuthority>) SecurityContextHolder
					.getContext()
					.getAuthentication()
					.getAuthorities();
			if (authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN")) 
					|| authorities.contains(
							new SimpleGrantedAuthority("ROLE_REDADMIN"))) {
				return "users";
			}
		}
		return "common/index";
	}

}