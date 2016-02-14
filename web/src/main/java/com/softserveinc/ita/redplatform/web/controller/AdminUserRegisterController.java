package com.softserveinc.ita.redplatform.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softserveinc.ita.redplatform.business.service.AdminUserService;
import com.softserveinc.ita.redplatform.common.dto.AdminUserDTO;

/**
 * Controller for registration new Real Estate Agency.
 * 
 * @author Bulhakov Alex
 * 
 */
@Controller
public class AdminUserRegisterController {
    /**
     * Autowired AdminUser Service.
     */
    @Autowired
    private AdminUserService adminUserService;

    /**
     * adminuserregister page mapping.
     * 
     * @return adminregister view.
     */
    @RequestMapping(value = "/adminregister", method = RequestMethod.GET)
    public final String getPage() {
	return "register/adminregister";
    }

    /**
     * register Admin User.
     * 
     * @return index view.
     * @param adminUserDTO
     *            DTO
     */
    @RequestMapping(value = "/adminregister", method = RequestMethod.POST)
    public final String adminRegister(
	    @RequestBody final AdminUserDTO adminUserDTO) {
	adminUserService.create(adminUserDTO);

	return "common/index";
    }

}
