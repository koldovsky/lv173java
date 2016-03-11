package com.softserveinc.ita.redplatform.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for order creation.
 * 
 * @author Bulhakov Alex
 * 
 */
@Controller
public class OrderController {

    

    /**
     * Gets the order page.
     *
     * @return the order page
     */
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public final String getOrderPage() {
	
	    return "order/ordering";
	
    }
    
    /**
     * Gets the order list page.
     *
     * @return the order page
     */
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public final String getOrderListPage() {
	
	    return "orderList";
	
    }

    

}
