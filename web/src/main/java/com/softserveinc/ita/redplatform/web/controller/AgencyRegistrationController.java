package com.softserveinc.ita.redplatform.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import 
    com.softserveinc.ita.redplatform.business.service.RealEstateAgencyService;
import com.softserveinc.ita.redplatform.common.dto.RealEstateAgencyDTO;



/**
 * Controller for registration new Real Estate Agency.
 * 
 * @author Oleh Khimka
 *         
 */
@Controller
public class AgencyRegistrationController {
    
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
    @RequestMapping(value = "registerAgency", method = RequestMethod.GET)
    public final String getPage() {
	return "agencyRegistration";
    }    
    /**
     * register Agency.
     * 
     * @return index view.
     * @param realEstateAgencyDTO realEstateAgencyDTO
     */
    @RequestMapping(value = "registerAgency", method = RequestMethod.POST)
    public final String registerAgency(
	    @RequestBody final RealEstateAgencyDTO realEstateAgencyDTO) {
	
	realEstateAgencyService.create(realEstateAgencyDTO);
	return "index";
    }

}
