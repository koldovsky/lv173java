package com.softserveinc.ita.redplatform.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping(value = "/red/admin")
public class RealEstateAdminController {
	
	/** The admin service. */
	@Autowired
	private RealEstateAdminUserService adminService;
	
	/** The agency service. */
	@Autowired
	private RealEstateAgencyService agencyService;
	
	/**
	 * Gets the registration page.
	 *
	 * @param model the model
	 * @return the registration page
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public final String getRegistrationPage(final Model model) {
		model.addAttribute("redAdmin", new RealEstateAdminUserDTO());
		initializeAgenciesList(model);
		return "register/red-admin-registration";
	}
	
	/**
	 * Initializes agencies list.
	 *
	 * @param model the model
	 */
	private void initializeAgenciesList(final Model model) {
		List<RealEstateAgencyDTO> agencies = agencyService.retrieveAllIdName();
		model.addAttribute("agencies", agencies);
	}
	
	/**
	 * Registers admin.
	 *
	 * @param admin the admin dto
	 * @param result the result
	 * @param model the model
	 * @return the index page if successful, register page otherwise
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public final String registerAdmin(@ModelAttribute("redAdmin") 
					@Validated final RealEstateAdminUserDTO admin, 
					final BindingResult result, final Model model) {
		if (result.hasErrors()) {
			return "register/red-admin-registration";
		}
		adminService.register(admin);
		return "common/index";
	}
}