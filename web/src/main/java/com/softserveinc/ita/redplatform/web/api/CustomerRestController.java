package com.softserveinc.ita.redplatform.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.softserveinc.ita.redplatform.business.service.CustomerUserService;
import com.softserveinc.ita.redplatform.common.dto.CustomerUserDTO;
import com.softserveinc.ita.redplatform.common.predicate.DataTablePredicate;
import com.softserveinc.ita.redplatform.web.datatables.DataTablesResponse;

/**
 * Rest controller for customer.
 * 
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
     * 
     * @param customerUserDTO
     *            customer user
     * @return status
     */
    @RequestMapping(value = "api/customer", method = RequestMethod.POST)
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
     * 
     * @param id
     *            customer user id
     * @return customer user dto
     */
    @RequestMapping(value = "api/customer/{id}", method = RequestMethod.GET)
    public final ResponseEntity<CustomerUserDTO>
	    getCustomer(@PathVariable final Long id) {
	CustomerUserDTO customer = customerUserService.getUserDTOById(id);
	if (customer == null) {
	    return new ResponseEntity<CustomerUserDTO>(HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<CustomerUserDTO>(customer, HttpStatus.OK);
    }

    /**
     * Customer update.
     * 
     * @param id
     *            customer id
     * @param customer
     *            customer user dto
     * @return status
     */
    @RequestMapping(value = "api/customer/{id}", method = RequestMethod.PUT)
    public final ResponseEntity<CustomerUserDTO> updateCustomer(
	    @PathVariable final Long id,
	    @RequestBody final CustomerUserDTO customer) {
	customerUserService.update(customer);
	return new ResponseEntity<CustomerUserDTO>(customer, HttpStatus.OK);
    }

    /**
     * Returns User list.
     * 
     * @param draw
     *            draw
     * @param length
     *            length
     * @param start
     *            start
     * @param search
     *            search text
     * @param column
     *            column index
     * @param order
     *            order type
     * @return users list
     */
    @RequestMapping(value = "/api/customeruserlist", method = RequestMethod.GET)
    @ResponseBody
    public final ResponseEntity<DataTablesResponse<CustomerUserDTO>>
	    getUserList(@RequestParam final int draw,
		    @RequestParam final int length,
		    @RequestParam final int start,
		    @RequestParam(value = "search[value]") final String search,
		    @RequestParam(value = "order[0][column]") final int column,
		    @RequestParam(value = "order[0][dir]") final String order) {
	DataTablePredicate predicate = new DataTablePredicate(draw, start,
		length, column, order, search);
	DataTablesResponse<CustomerUserDTO> dtResp =
		new DataTablesResponse<CustomerUserDTO>();
	dtResp.setDraw(predicate.getDraw());
	if (SecurityContextHolder.getContext().getAuthentication()
		.getAuthorities()
		.contains(new SimpleGrantedAuthority("ROLE_REDADMIN"))) {
	    dtResp.setTotalRecords(customerUserService.countAllCustomerUsers());
	    dtResp.setTotalDisplayRecords(
		    customerUserService.countAllCustomerUsers(predicate));
	    dtResp.setData(customerUserService.loadCustomerUsers(predicate));
	}

	return new ResponseEntity<DataTablesResponse<CustomerUserDTO>>(dtResp,
		HttpStatus.OK);

    }

}
