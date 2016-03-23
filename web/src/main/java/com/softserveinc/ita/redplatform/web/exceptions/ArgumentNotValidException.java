package com.softserveinc.ita.redplatform.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The class ArgumentNotValidException.
 * 
 * @author Oleh Khimka
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid argument")
public class ArgumentNotValidException extends RuntimeException {
    
    /** The binding result. */
    private BindingResult bindingResult;

    /**
     * Instantiates a new argument not valid exception.
     *
     * @param result the result
     */
    public ArgumentNotValidException(final BindingResult result) {
	this.bindingResult = result;
    }

    /**
     * Gets the binding result.
     *
     * @return the binding result
     */
    public final BindingResult getBindingResult() {
        return bindingResult;
    }

    /**
     * Sets the binding result.
     *
     * @param newBindingResult the new binding result
     */
    public final void setBindingResult(final BindingResult newBindingResult) {
        this.bindingResult = newBindingResult;
    }
        
}
