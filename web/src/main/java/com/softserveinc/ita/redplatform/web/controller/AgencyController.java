package com.softserveinc.ita.redplatform.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softserveinc.ita.redplatform.business.service
				.RealEstateAgencyService;

/**
 * Controller for registration new Real Estate Agency.
 * 
 * @author Oleh Khimka
 * 
 */
@Controller
public class AgencyController {
    
    /**
     * realEstateAgencyService.
     */
    @Autowired
    private RealEstateAgencyService realEstateAgencyService;

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
     * @param id id
     * @return agencyRegistration view.
     */
    @RequestMapping(value = "agency/{id}", method = RequestMethod.GET)
    public final String getEditPage(@PathVariable final Long id) {
	if (!realEstateAgencyService.exists(id)) {
	    throw new ResourceNotFoundException();
	}
	return "agencyEdit";
    }

}
