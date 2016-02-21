package com.softserveinc.ita.redplatform.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softserveinc.ita.redplatform.business.service
		.RealEstateAdminUserService;
import com.softserveinc.ita.redplatform.business.service
		.RealEstateAgencyService;
import com.softserveinc.ita.redplatform.common.dto.RealEstateAdminUserDTO;
import com.softserveinc.ita.redplatform.common.dto.RealEstateAgencyDTO;

/**
 * The class RealEstateAdminController.
 * 
 * @author Ilona Yavorska
 */
@Controller
public class RealEstateAdminUserController {

    /** The admin service. */
    @Autowired
    private RealEstateAdminUserService adminService;

    /** The agency service. */
    @Autowired
    private RealEstateAgencyService agencyService;
    
    /**
     * Gets the registration page.
     *
     * @param model
     *            the model
     * @return the registration page
     */
    @RequestMapping(value = "/redadmin", method = RequestMethod.GET)
    public final String getRegistrationPage(final Model model) {
	List<RealEstateAgencyDTO> agencies = agencyService.retrieveAllIdName();
	model.addAttribute("agencies", agencies);
	return "register/redAdminRegister";
    }

    /**
     * Admin register.
     *
     * @param dto
     *            the dto
     * @return the response entity
     */
    @RequestMapping(value = "/redadmin", method = RequestMethod.POST)
    public final ResponseEntity<RealEstateAdminUserDTO> adminRegister(
	    @RequestBody final RealEstateAdminUserDTO dto) {
	adminService.register(dto);
	return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
