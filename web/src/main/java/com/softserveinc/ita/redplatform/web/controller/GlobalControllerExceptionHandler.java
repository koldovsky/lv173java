package com.softserveinc.ita.redplatform.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.softserveinc.ita.redplatform.common.dto.ValidationErrorsDTO;
import com.softserveinc.ita.redplatform.web.api.AgencyRestController;
import com.softserveinc.ita.redplatform.web
			.exceptions.ArgumentNotValidException;

// TODO: Auto-generated Javadoc
/**
 * Controller for handling exceptions.
 * 
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
     * 
     * @return 404 page
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public final ModelAndView handleConflict() {
	return new ModelAndView("errors/404");
    }

    /**
     * Bad request exception.
     *
     * @param exception the exception
     * @return ValidationErrorsDTO
     */
    @ExceptionHandler(ArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public final ValidationErrorsDTO
	    handle(final ArgumentNotValidException exception) {

	List<FieldError> fieldErrors =
		exception.getBindingResult().getFieldErrors();

	return processFieldErrors(fieldErrors);
    }

    /**
     * Process field errors.
     *
     * @param fieldErrors the field errors
     * @return the validation errors dto
     */
    private ValidationErrorsDTO
	    processFieldErrors(final List<FieldError> fieldErrors) {
	ValidationErrorsDTO dto = new ValidationErrorsDTO();

	for (FieldError fieldError : fieldErrors) {
	    dto.addFieldError(fieldError.getField(),
		    fieldError.getDefaultMessage());
	}

	return dto;
    }

}
