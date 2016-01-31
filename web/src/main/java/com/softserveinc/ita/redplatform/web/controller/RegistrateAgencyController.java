package com.softserveinc.ita.redplatform.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for registration new Real Estate Agency.
 * 
 * @author Oleh Khimka
 *         
 */
@Controller
public class RegistrateAgencyController {
    
    /**
     * registerAgency page mapping.
     * 
     * @return agencyRegistration view.
     */
    @RequestMapping(value = "registerAgency", method = RequestMethod.GET)
    public final String getPage() {
	return "agencyRegistration";
    }
    
    @RequestMapping(value = "registerAgency", method = RequestMethod.POST)
    public final String registerAgency() {
	System.out.println("in register Agency controller");
	return "index";
    }

}
