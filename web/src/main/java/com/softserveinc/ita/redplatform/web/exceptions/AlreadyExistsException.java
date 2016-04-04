package com.softserveinc.ita.redplatform.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * The class AlreadyExistsException.
 * 
 * @author Oleh Khimka
 */
@ResponseStatus(value = HttpStatus.CONFLICT, 
	reason = "Such resource already exists!")
public class AlreadyExistsException extends RuntimeException {

    /** Unique ID for Serialized object. */
    private static final long serialVersionUID = 4657491283614755649L;

    /**
     * Instantiates a new already exists exception.
     *
     * @param msg the msg
     */
    public AlreadyExistsException(final String msg) {
	super(msg);
    }
}
