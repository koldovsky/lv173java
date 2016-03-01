package com.softserveinc.ita.redplatform.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Controller for registration new Real Estate Agency.
 * 
 * @author Roman Ivaniv
 * 
 */
@Controller
public class CurrencyController {
    
    /**
     * add Currency rate page mapping.
     * 
     * @return currencyRate view.
     */
    @RequestMapping(value = "currency", method = RequestMethod.GET)
    public final String addCurrencyPage() {
	return "currencyRate";
    }
    
}
