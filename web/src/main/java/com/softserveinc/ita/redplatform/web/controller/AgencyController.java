package com.softserveinc.ita.redplatform.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    @RequestMapping(value = "agency/create", method = RequestMethod.GET)
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
    @RequestMapping(value = "agency/create", method = RequestMethod.POST)
    @ResponseBody
    public final ResponseEntity<Void> registerAgency(
	    @RequestBody final RealEstateAgencyDTO realEstateAgencyDTO) {

	realEstateAgencyService.create(realEstateAgencyDTO);

	return new ResponseEntity<Void>(HttpStatus.OK);
    }

    /**
     * edit agency information.
     * 
     * @return agencyRegistration view.
     */
    @RequestMapping(value = "agency/{id}", method = RequestMethod.GET)
    public final String getEditPage() {
	LOGGER.info("in get view");
	return "agencyEdit";
    }

    /**
     * Get agency by id to edit.
     * 
     * @param id
     *            id
     * @return ResponceEntity EwsponceEntity
     */
    @RequestMapping(value = "agency/{id}/edit", method = RequestMethod.GET)
    @ResponseBody
    public final ResponseEntity<RealEstateAgencyDTO>
	    getAgency(@PathVariable("id") final long id) {

	LOGGER.info("in get agency ajax");
	RealEstateAgencyDTO realEstateAgencyDTO =
		realEstateAgencyService.getById(id);
	if (realEstateAgencyDTO == null) {
	    LOGGER.info("agency not found");
	    return new ResponseEntity<RealEstateAgencyDTO>(
		    HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<RealEstateAgencyDTO>(realEstateAgencyDTO,
		HttpStatus.OK);

    }

    /**
     * Update agency.
     * 
     * @return status.
     * @param id
     *            id
     * @param realEstateAgencyDTO
     *            realEstateAgencyDTO
     */
    @RequestMapping(value = "agency/{id}/edit", method = RequestMethod.PUT)
    @ResponseBody
    public final ResponseEntity<String> updateAgency(
	    @PathVariable("id") final long id,
	    @RequestBody final RealEstateAgencyDTO realEstateAgencyDTO) {

	realEstateAgencyService.update(realEstateAgencyDTO);

	return new ResponseEntity<String>(
		"Agency has been edited successfully", 
		HttpStatus.OK);
    }
    
    /**
     * check if company exists.
     * 
     * @return boolean value
     * @param name
     *            name
     */
    @RequestMapping(value = "agency/checkUnique", method = RequestMethod.POST)
    @ResponseBody
    public final ResponseEntity<String>
	    checkIfExist(@RequestParam final String name) {

	if (realEstateAgencyService.exist(name)) {
	    return new ResponseEntity<String>("true", HttpStatus.OK);
	} else {
	    return new ResponseEntity<String>("false", HttpStatus.OK);
	}

    }

}
