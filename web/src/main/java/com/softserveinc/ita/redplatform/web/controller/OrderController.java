package com.softserveinc.ita.redplatform.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.softserveinc.ita.redplatform.business.service.CustomerUserService;

/**
 * Controller for order creation.
 * 
 * @author Bulhakov Alex
 * 
 */
@Controller
public class OrderController {

    
    /**
     * Customer user service.
     */
    @Autowired
    private CustomerUserService customerUserService;

    /**
     * Gets the order page.
     *
     * @return the order page
     */
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public final String getOrderPage() {
	
	    return "order";
	
    }

    

}
