package com.softserveinc.ita.redplatform.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
