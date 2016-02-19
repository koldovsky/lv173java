package com.softserveinc.ita.redplatform.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import 
  com.softserveinc.ita.redplatform.business.service.RealEstateAgencyService;
import com.softserveinc.ita.redplatform.common.dto.RealEstateAgencyDTO;


/**
* Rest Controller for registration new Real Estate Agency.
* 
* @author Oleh Khimka
* 
*/
@RestController
public class AgencyRestController {
    
    /**
     * Logger for Agency Controller class.
     */
    public static final Logger LOGGER =
	    Logger.getLogger(AgencyRestController.class);

    
    /**
     * realEstateAgencyService.
     */
    @Autowired
    private RealEstateAgencyService realEstateAgencyService;
    
    /**
     * Get agency by id to edit.
     * 
     * @param id
     *            id
     * @return ResponseEntity ResponseEntity
     */
    @RequestMapping(value = "/api/agency/{id}", method = RequestMethod.GET)
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
    @RequestMapping(value = "/api/agency/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public final ResponseEntity<String> updateAgency(
	    @PathVariable("id") final long id,
	    @RequestBody final RealEstateAgencyDTO realEstateAgencyDTO) {

	realEstateAgencyService.update(realEstateAgencyDTO);

	return new ResponseEntity<String>(
		"Agency has been edited successfully", 
		HttpStatus.OK);
    }
}
