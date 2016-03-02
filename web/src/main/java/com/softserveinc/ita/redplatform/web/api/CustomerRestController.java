package com.softserveinc.ita.redplatform.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softserveinc.ita.redplatform.business.service.CustomerUserService;
import com.softserveinc.ita.redplatform.common.dto.CustomerUserDTO;

/**
 * Rest controller for customer.
 * @author Hryhorii
 */
@RestController
public class CustomerRestController {
    
    /**
     * Customer user service.
     */
    @Autowired
    private CustomerUserService customerUserService;
    /**
     * Customer register.
     * @param customerUserDTO customer user
     * @return status
     */
    @RequestMapping(value = "api/customer",
	    method = RequestMethod.POST)
    public final ResponseEntity<CustomerUserDTO> registerCustomerUser(
	    @RequestBody final CustomerUserDTO customerUserDTO) {
	customerUserService.register(customerUserDTO);
	CustomerUserDTO customer = customerUserService
		.getUserDTOByEmail(customerUserDTO.getEmail()); 
	return new ResponseEntity<CustomerUserDTO>(customer, 
		HttpStatus.CREATED);
	
    }
    
    /**
     * Customer edit.
     * @param id customer user id
     * @return customer user dto
     */
    @RequestMapping(value = "api/customer/{id}", method = RequestMethod.GET)
    public final ResponseEntity<CustomerUserDTO> getCustomer(
	    @PathVariable final Long id) {
	CustomerUserDTO customer = customerUserService.getUserDTOById(id);
	if (customer == null) {
	    return new ResponseEntity<CustomerUserDTO>(HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<CustomerUserDTO>(customer, HttpStatus.OK);
    }

}
