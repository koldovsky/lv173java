package com.softserveinc.ita.redplatform.web.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softserveinc.ita.redplatform.business.service.InstallmentService;
import com.softserveinc.ita.redplatform.business.service.UserService;
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
    private InstallmentService installmentService;

    /** The user service. */
    @Autowired
    private UserService userService;

    /**
     * Gets the installment addition page.
     *
     * @param userId the user id
     * @return the registration page
     */
    @RequestMapping(value = "/installment/{userId}", 
	    method = RequestMethod.GET)
    public final String getInstallmentAdditionPage(
	    @PathVariable final Long userId) {
	if (userService.isUserIdPresent(userId)) {
	    return "installment";
	} else {
	    return "404";
	}
    }

    /**
     * Adds installment.
     *
     * @param userId
     *            the user id
     * @param dtos
     *            the dtos
     * @return the response entity
     */
    @RequestMapping(value = "/installment/{userId}", 
	    method = RequestMethod.POST)
    public final ResponseEntity<String> addInstallment(
	    @PathVariable final Long userId,
	    @RequestBody final List<InstallmentDTO> dtos) {
	try {
	    installmentService.addInstallment(dtos, userId);
	} catch (ParseException e) {
	    return new ResponseEntity<>("Invalid input date.", 
		    HttpStatus.BAD_REQUEST);
	}
	return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
