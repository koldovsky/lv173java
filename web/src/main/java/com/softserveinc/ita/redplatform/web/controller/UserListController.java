package com.softserveinc.ita.redplatform.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
     * User Service.
     */
    @Autowired
    private UserService userService;

    /**
     * Users page mapping.
     * 
     * @param model represents ModelMap
     * 
     * @return users page
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public final String getUserList(final ModelMap model) {
	model.addAttribute("list", userService.loadAllUsers());
	return "users";
    }

}