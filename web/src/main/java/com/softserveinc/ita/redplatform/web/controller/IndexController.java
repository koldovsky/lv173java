package com.softserveinc.ita.redplatform.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for index page.
 * 
 * @author Hryhorii Somyk
 *
 */
@Controller
public class IndexController {
    /**
     * Index page mapping.
     * 
     * @return index page
     */
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public final String getIndexPage() { 
	return "index";
    }
}
