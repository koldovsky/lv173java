package com.softserveinc.ita.redplatform.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.softserveinc.ita.redplatform.business.service.UserService;
import com.softserveinc.ita.redplatform.common.dto.UserDTO;
import com.softserveinc.ita.redplatform.common.predicate.DataTablePredicate;
import com.softserveinc.ita.redplatform.web.datatables.DataTablesResponse;

/**
 * Rest Controller for users.
 * 
 * @author Hryhorii Somyk
 */
@RestController
public class UserRestController {

    /**
     * User Service.
     */
    @Autowired
    private UserService userService;

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
    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public final ResponseEntity<DataTablesResponse<UserDTO>> getUserList(
	    @RequestParam final int draw,
	    @RequestParam final int length, @RequestParam final int start,
	    @RequestParam(value = "search[value]") final String search,
	    @RequestParam(value = "order[0][column]") final int column,
	    @RequestParam(value = "order[0][dir]") final String order) {
	DataTablePredicate predicate = new DataTablePredicate(
		draw, start, length, column, order, search);
	DataTablesResponse<UserDTO> dtResp = new DataTablesResponse<UserDTO>();
	dtResp.setDraw(predicate.getDraw());
	if (!SecurityContextHolder.getContext().getAuthentication().getAuthorities()
		.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
	    String email = SecurityContextHolder
		    .getContext()
		    .getAuthentication()
		    .getName();
	    dtResp.setTotalDisplayRecords(
		    userService.countAllCompanyUsers(email, predicate));
	    dtResp.setTotalRecords(userService.countAllCompanyUsers(email));
	    dtResp.setData(userService.loadUsersByCompanyAdmin(email, predicate));
	} else {
	    dtResp.setTotalRecords(userService.countAll());
	    dtResp.setTotalDisplayRecords(userService.countAll(predicate));
	    dtResp.setData(userService.loadAllUsers(predicate));
	}
	return new ResponseEntity<DataTablesResponse<UserDTO>>(
		dtResp, HttpStatus.OK);

    }
}
