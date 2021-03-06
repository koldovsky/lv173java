package com.softserveinc.ita.redplatform.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
    public final String getRegisterPage(final Model model) {
	addAgenciesToModel(model);
	return "register/redAdminRegister";
    }
    
    /**
     * Adds agencies to model.
     *
     * @param model the model
     */
    private void addAgenciesToModel(final Model model) {
	List<RealEstateAgencyDTO> agencies = agencyService.retrieveAllIdName();
	model.addAttribute("agencies", agencies);
    }
    
    /**
     * Gets the edition page.
     *
     * @param model the model
     * @param id the id
     * @return the edits the page
     */
    @RequestMapping(value = "/redadmin/{id}", method = RequestMethod.GET)
    public final String getEditPage(final Model model,
	    @PathVariable final Long id) {
	RealEstateAdminUserDTO admin = (RealEstateAdminUserDTO) adminService
		.retrieve(id);
	if (admin != null) {
	    model.addAttribute("admin", admin);
	    addAgenciesToModel(model);
	    return "edit/redAdminEdit";
	} else {
	    throw new ResourceNotFoundException();
	}
	
    }
    
    /**
     * Gets the cabinet page.
     *
     * @return the cabinet page
     */
    @RequestMapping(value = "/redadmincabinet", method = RequestMethod.GET)
    public final String getCabinetPage() {
	
	return "redAdminCab";
    }
}
