package com.softserveinc.ita.redplatform.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
public class AgencyController {

    /**
     * Logger for Agency Controller class.
     */
    public static final Logger LOGGER =
	    Logger.getLogger(AgencyController.class);

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
     * register Agency.
     * 
     * @return status.
     * @param realEstateAgencyDTO
     *            realEstateAgencyDTO
     */
    @RequestMapping(value = "agency", method = RequestMethod.POST)
    @ResponseBody
    public final ResponseEntity<RealEstateAgencyDTO> registerAgency(
	    @RequestBody final RealEstateAgencyDTO realEstateAgencyDTO) {

	realEstateAgencyService.create(realEstateAgencyDTO);

	return new ResponseEntity<RealEstateAgencyDTO>(
		realEstateAgencyDTO, HttpStatus.OK
		);
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

   
    
    /**
     * check if company exists.
     * 
     * @return boolean value
     * @param name
     *            name
     */
    @RequestMapping(value = "/checkUnique", method = RequestMethod.POST)
    @ResponseBody
    public final ResponseEntity<String>
    		checkIfExist(@RequestBody final String name) {

	if (realEstateAgencyService.exist(name)) {
	    return new ResponseEntity<String>("true", HttpStatus.OK);
	} else {
	    return new ResponseEntity<String>("false", HttpStatus.OK);
	}

    }
    

}
