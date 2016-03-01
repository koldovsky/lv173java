package com.softserveinc.ita.redplatform.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softserveinc.ita.redplatform.business.service.OrderService;

/**
 * The class InstallmentController.
 * 
 * @author Ilona Yavorska
 */
@Controller
public class InstallmentController {

    /** The order service. */
    @Autowired
    private OrderService orderService;

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
	    throw new ResourceNotFoundException();
	}
    }
}
