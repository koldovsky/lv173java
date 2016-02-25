package com.softserveinc.ita.redplatform.web.controller;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softserveinc.ita.redplatform.business.service.CustomerUserService;
import com.softserveinc.ita.redplatform.common.dto.CustomerUserDTO;
import com.softserveinc.ita.redplatform.common.predicate.DataTablePredicate;
import com.softserveinc.ita.redplatform.web.utils.DataTableResponse;

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
    public final ResponseEntity<DataTableResponse<CustomerUserDTO>> getUserList(
	    @RequestParam final int draw, @RequestParam final int length,
	    @RequestParam final int start,
	    @RequestParam(value = "search[value]") final String search,
	    @RequestParam(value = "order[0][column]") final int column,
	    @RequestParam(value = "order[0][dir]") final String order) {
	DataTablePredicate predicate = new DataTablePredicate(draw, start,
		length, column, order, search);
	DataTableResponse<CustomerUserDTO> dtResp =
		new DataTableResponse<CustomerUserDTO>();
	dtResp.setDraw(predicate.getDraw());
	dtResp.setTotalRecords(customerUserService.countAllCustomerUsers());
	dtResp.setTotalDisplayRecords(
		customerUserService.countAllCustomerUsers(predicate));
	dtResp.setData(customerUserService.loadCustomerUsers(predicate));
	return new ResponseEntity<DataTableResponse<CustomerUserDTO>>(dtResp,
		HttpStatus.OK);

    }

    /**
     * Users page mapping.
     * 
     * @return users page
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/createorder", method = RequestMethod.GET)
    public final String getUsersPage() {
	Authentication auth =
		SecurityContextHolder.getContext().getAuthentication();
	if (auth instanceof AnonymousAuthenticationToken) {
	    return "common/login";
	} else {
	    Collection<GrantedAuthority> authorities =
		    (Collection<GrantedAuthority>) SecurityContextHolder
			    .getContext().getAuthentication().getAuthorities();
	    if (authorities
		    .contains(new SimpleGrantedAuthority("ROLE_REDADMIN"))) {
		return "usersfororders";
	    }
	}
	return "common/index";
    }

}