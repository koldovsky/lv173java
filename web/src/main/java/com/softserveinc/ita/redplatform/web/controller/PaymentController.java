package com.softserveinc.ita.redplatform.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Controller for payment creation.
 * 
 * @author Bulhakov Alex
 * 
 */
@Controller
public class PaymentController {

    /**
     * Gets the order page.
     *
     * @param orderId
     *            the order id
     * @param model
     *            the model
     * @return the order page
     */
    @RequestMapping(value = "/payment/{orderId}", method = RequestMethod.GET)
    public final String getOrderPage(@PathVariable final long orderId,
	    final Model model) {
	model.addAttribute("orderId", orderId);
	return "/payment";
    }
}