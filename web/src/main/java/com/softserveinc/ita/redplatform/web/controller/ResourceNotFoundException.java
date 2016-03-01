package com.softserveinc.ita.redplatform.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The class ResourceNotFoundException.
 * 
 * @author Ilona Yavorska
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, 
reason = "Requested resource cannot be found")
public class ResourceNotFoundException extends RuntimeException {
    
}
