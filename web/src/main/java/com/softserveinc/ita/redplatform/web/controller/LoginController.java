package com.softserveinc.ita.redplatform.web.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for login page.
 * 
 * @author Roman Ivaniv
 */
@Controller
public class LoginController {

    /**
     * mapping for login page.
     * @param error return error message
     * @return model
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public final ModelAndView login(
	    @RequestParam(value = "error", required = false)final String error) {
	
	Authentication auth = SecurityContextHolder.getContext()
		.getAuthentication();

	if (!(auth instanceof AnonymousAuthenticationToken)) {

	    /* The user is logged in :) */
	    return new ModelAndView("forward:/index");
	}
	
	ModelAndView model = new ModelAndView();

	if (error != null) {
	    model.addObject("error", "Invalid username or password!");
	}

	model.setViewName("common/login");
	return model;
    }

    /**
     * mapping loginfailed page.
     * @param model represent Model
     * @return login
     */
    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public final String loginerror(final Model model) {
	model.addAttribute("error", "true");
	return "common/login";
    }

}