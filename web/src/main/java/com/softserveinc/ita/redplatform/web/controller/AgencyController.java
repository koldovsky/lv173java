package com.softserveinc.ita.redplatform.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softserveinc.ita.redplatform.business.service
					.RealEstateAgencyService;
import com.softserveinc.ita.redplatform.common.dto.RealEstateAgencyDTO;

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
     * 
     * @param id
     *            id
     * @param model
     *            model
     * @return agencyRegistration view.
     */
    @RequestMapping(value = "agency/{id}", method = RequestMethod.GET)
    public final String getEditPage(@PathVariable final Long id,
	    final Model model) {
	RealEstateAgencyDTO agency = realEstateAgencyService.getById(id);
	if (agency == null) {
	    throw new ResourceNotFoundException();
	}
	model.addAttribute("agency", agency);
	return "agencyEdit";
    }

}
