package com.softserveinc.ita.redplatform.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softserveinc.ita.redplatform.business.service.UserService;

/**
 * The Class UserController.
 */
@Controller
public class UserController {
    
    /** The user service. */
    @Autowired
    private UserService userService;
    
    /**
     * Check email availability.
     * 
     * @param mail the mail
     * @return true, if email is available
     */
    @RequestMapping(value = "/checkmail", method = RequestMethod.GET)
    @ResponseBody
    public final boolean checkEmailAvailability(
	    @RequestParam final String mail) {
	return userService.isEmailAvailable(mail);
    }
}
