package com.softserveinc.ita.redplatform.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for registration new Real Estate Agency.
 * 
 * @author Bulhakov Alex
 * 
 */
@Controller
public class AdminUserRegisterController {

    /**
     * adminuserregister page mapping.
     * 
     * @return adminregister view.
     */
    @RequestMapping(value = "/adminregister", method = RequestMethod.GET)
    public final String getPage() {
	return "adminregister";
    }

    /**
     * register Admin User.
     * 
     * @return index view.
     * @param login
     *            login
     */
    @RequestMapping(value = "/adminregister", method = RequestMethod.POST)
    public final String adminRegister(@RequestBody final String login) {

	return "index";
    }

}
