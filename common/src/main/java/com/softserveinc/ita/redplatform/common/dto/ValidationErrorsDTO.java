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
    private List<FieldDTO> fieldErrors = new ArrayList<>();
    
    /**
     * Instantiates a new validation errors dto.
     */
    public ValidationErrorsDTO() {
 
    }
 
    /**
     * Adds the field error.
     *
     * @param path the path
     * @param message the message
     */
    public final void addFieldError(final String path, final String message) {
	FieldDTO error = new FieldDTO(path, message);
        fieldErrors.add(error);
    }

    /**
     * Gets the field errors.
     *
     * @return the field errors
     */
    public final List<FieldDTO> getFieldErrors() {
        return fieldErrors;
    }

    /**
     * Sets the field errors.
     *
     * @param newFieldErrors the new field errors
     */
    public final void setFieldErrors(final List<FieldDTO> newFieldErrors) {
        this.fieldErrors = newFieldErrors;
    }      
 
}
