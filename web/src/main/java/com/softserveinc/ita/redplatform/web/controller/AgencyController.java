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
public class AgencyController {

    /**
     * registerAgency page mapping.
     * 
     * @return agencyRegistration view.
     */
    @RequestMapping(value = "agency", method = RequestMethod.GET)
    public final String getRegisterPage() {
	return "register/agencyRegister";
    }
    
    /**
     * edit agency information.
     * 
     * @return agencyRegistration view.
     */
    @RequestMapping(value = "agency/{id}", method = RequestMethod.GET)
    public final String getEditPage() {
	return "agencyEdit";
    }

}
