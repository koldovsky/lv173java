package com.softserveinc.ita.redplatform.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softserveinc.ita.redplatform.business.service.CustomerUserService;
import com.softserveinc.ita.redplatform.common.dto.CustomerUserDTO;
import com.softserveinc.ita.redplatform.common.predicate.DataTablePredicate;
import com.softserveinc.ita.redplatform.web.datatables.DataTablesResponse;

/**
 * Controller for users page.
 * 
 * @author Bulhakov Alex
 *
 */

@Controller
public class CustomerUserListController {

    /**
     * Logger for Customer User List Controller class.
     */
    public static final Logger LOGGER =
	    Logger.getLogger(CustomerUserListController.class);
    /**
     * User Service.
     */
    @Autowired
    private CustomerUserService customerUserService;

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
    @RequestMapping(value = "/customeruserlist", method = RequestMethod.GET)
    @ResponseBody
    public final ResponseEntity<DataTablesResponse<CustomerUserDTO>> 
    	getUserList(
	    @RequestParam final int draw, @RequestParam final int length,
	    @RequestParam final int start,
	    @RequestParam(value = "search[value]") final String search,
	    @RequestParam(value = "order[0][column]") final int column,
	    @RequestParam(value = "order[0][dir]") final String order) {
	DataTablePredicate predicate = new DataTablePredicate(draw, start,
		length, column, order, search);
	DataTablesResponse<CustomerUserDTO> dtResp =
		new DataTablesResponse<CustomerUserDTO>();
	dtResp.setDraw(predicate.getDraw());
	dtResp.setTotalRecords(customerUserService.countAllCustomerUsers());
	dtResp.setTotalDisplayRecords(
		customerUserService.countAllCustomerUsers(predicate));
	dtResp.setData(customerUserService.loadCustomerUsers(predicate));
	return new ResponseEntity<DataTablesResponse<CustomerUserDTO>>(dtResp,
		HttpStatus.OK);

    }


}