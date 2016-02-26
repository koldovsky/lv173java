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
import com.softserveinc.ita.redplatform.business.service.OrderService;
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

    /** The order service. */
    @Autowired
    private OrderService orderService;

    //TODO redesign the method so that 
    //it returns ResponseEntity instance instead 
    //of view name, if the page could not be rendered
    /**
     * Gets the installment addition page.
     *
     * @param orderId the order id
     * @return the registration page
     */
    @RequestMapping(value = "/installment/{orderId}", 
	    method = RequestMethod.GET)
    public final String getInstallmentAdditionPage(
	    @PathVariable final Long orderId) {
	if (orderService.isOrderIdPresent(orderId)) {
	    return "installment";
	} else {
	    return "404";
	}
    }

    /**
     * Adds installment.
     *
     * @param orderId
     *            the user id
     * @param installmentList
     *            the installmentList
     * @return the response entity
     */
    @RequestMapping(value = "/installment/{orderId}", 
	    method = RequestMethod.POST)
    public final ResponseEntity<String> addInstallment(
	    @PathVariable final Long orderId,
	    @RequestBody final List<InstallmentDTO> installmentList) {
	try {
	    installmentService.addInstallment(installmentList, orderId);
	} catch (ParseException e) {
	    return new ResponseEntity<>("Invalid input date.", 
		    HttpStatus.BAD_REQUEST);
	}
	return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
