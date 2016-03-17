package com.softserveinc.ita.redplatform.web.controller;


import org.springframework.stereotype.Controller;
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
     * Gets the payment page.
     *
     * @return the payment page
     */
    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public final String getOrderPage() {
	
	    return "/payment";
	
    }

}