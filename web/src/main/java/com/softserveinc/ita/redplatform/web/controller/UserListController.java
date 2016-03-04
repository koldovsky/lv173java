package com.softserveinc.ita.redplatform.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public final String getUsersPage() {
	    return "users";
	}

}