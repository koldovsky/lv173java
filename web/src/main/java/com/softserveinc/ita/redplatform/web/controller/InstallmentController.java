package com.softserveinc.ita.redplatform.web.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softserveinc.ita.redplatform.business.service.InstallmentService;
import com.softserveinc.ita.redplatform.common.dto.InstallmentDTO;

/**
 * The class InstallmentController.
 * 
 * @author Ilona Yavorska
 */
@Controller
public class InstallmentController {

    /** The installment service. */
    @Autowired
    private InstallmentService service;

    /**
     * Gets the installment addition page.
     * 
     * @return the registration page
     */
    @RequestMapping(value = "/installment", method = RequestMethod.GET)
    public final String getInstallmentAdditionPage() {
	return "installment";
    }

    /**
     * Adds installment.
     *
     * @param dtos the dtos
     * @return the response entity
     */
    @RequestMapping(value = "/installment", method = RequestMethod.POST)
    public final ResponseEntity<String> addInstallment(
	    @RequestBody final List<InstallmentDTO> dtos) {
	try {
	    service.addInstallment(dtos);
	} catch (ParseException e) {
	    return new ResponseEntity<>("Invalid input date.", 
		    HttpStatus.BAD_REQUEST);
	}
	return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
