package com.softserveinc.ita.redplatform.common.dto;

import java.util.ArrayList;
import java.util.List;


/**
 * The Class ValidationErrorsDTO.
 *
 * @author Oleh Khimka
 */
public class ValidationErrorsDTO {
    
    /** The field errors. */
    private List<String> errors = new ArrayList<>();
    
    /**
     * Instantiates a new validation errors dto.
     */
    public ValidationErrorsDTO() {
 
    }
 
    /**
     * Adds the field error.
     * @param message the message
     */
    public final void addFieldError(final String message) {
        errors.add(message);
    }

    /**
     * Gets the field errors.
     *
     * @return the field errors
     */
    public final List<String> getFieldErrors() {
        return errors;
    }

    /**
     * Sets the field errors.
     *
     * @param newFieldErrors the new field errors
     */
    public final void setFieldErrors(final List<String> newFieldErrors) {
        this.errors = newFieldErrors;
    }      
 
}
