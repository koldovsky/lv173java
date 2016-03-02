package com.softserveinc.ita.redplatform.web.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.softserveinc.ita.redplatform.web.api.AgencyRestController;

/**
 * Controller for handling exceptions.
 * @author oleh
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {
    
    /**
     * Logger for Agency Controller class.
     */
    private static final Logger LOGGER =
	    Logger.getLogger(AgencyRestController.class);
    
    /**
     * Not found exception.
     * @return 404 page
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public final ModelAndView handleConflict() {
	LOGGER.info("in error handler");
	return new ModelAndView("errors/404");
    }

}
