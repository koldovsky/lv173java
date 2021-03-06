package com.softserveinc.ita.redplatform.web.controller;


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
     * Edit customer page mapping.
     * @return edit customer page
     */
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public final String getEditPage() {
	return "edit/customer";
    }
    
}
