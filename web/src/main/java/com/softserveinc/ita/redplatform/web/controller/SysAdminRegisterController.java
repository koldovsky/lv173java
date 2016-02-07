package com.softserveinc.ita.redplatform.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




/**
 * Controller for registration new Real Estate Agency.
 * 
 * @author Bulhakov Alex
 *         
 */
@Controller
public class SysAdminRegisterController {
    
    /**
     * sysadminregister page mapping.
     * 
     * @return sysadminregister view.
     */
    @RequestMapping(value = "/sysadminregister", method = RequestMethod.GET)
    public final String getPage() {
	return "sysadminregister";
    }    
    /**
     * register System Administrator.
     * 
     * @return index view.
     * @param login login
     */
    @RequestMapping(value = "sysadminregister", method = RequestMethod.POST)
    public final String 
    registerAgency(@RequestBody final String login) {
	       
	        return "index";
    }

}
