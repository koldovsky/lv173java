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

import com.sofserveinc.ita.redplatform.web.api.DataTableResponse;
import com.softserveinc.ita.redplatform.business.service.UserService;
import com.softserveinc.ita.redplatform.common.dto.UserDTO;
import com.softserveinc.ita.redplatform.common.predicate.DataTablePredicate;

/**
 * Controller for users page.
 * 
 * @author Hryhorii Somyk
 *
 */

@Controller
public class UserListController {

    /**
     * Logger for User List Controller class.
     */
    public static final Logger LOGGER = Logger.getLogger(
        UserListController.class);
	/**
	 * User Service.
	 */
	@Autowired
	private UserService userService;

	/**
	 * Returns User list.
	 * @param draw draw
	 * @param length length
	 * @param start start
	 * @param search search text
	 * @param column column index
	 * @param order order type
	 * @return users list
	 */
	@RequestMapping(value = "/user", 
			method = RequestMethod.GET)
	@ResponseBody
	public final ResponseEntity<DataTableResponse<UserDTO>> 
		getUserList(
				@RequestParam final int draw,
				@RequestParam final int length,
				@RequestParam final int start,
				@RequestParam(value = "search[value]") final String search,
				@RequestParam(value = "order[0][column]") final int column,
				@RequestParam(value = "order[0][dir]") final String order
				) {
		DataTablePredicate predicate = new DataTablePredicate(draw,
				start, length, column, order, search);
		DataTableResponse<UserDTO> dtResp = new DataTableResponse<UserDTO>();
		dtResp.setDraw(predicate.getDraw());
		if (!SecurityContextHolder
				.getContext()
				.getAuthentication()
				.getAuthorities()
				.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
			String email = SecurityContextHolder
					.getContext()
					.getAuthentication()
					.getName();
			dtResp.setTotalDisplayRecords(userService.
					countAllCompanyUsers(email, predicate));
			dtResp.setTotalRecords(userService.countAllCompanyUsers(email));
			dtResp.setData(userService
					.loadUsersByCompanyAdmin(email, predicate));
		} else {
			dtResp.setTotalRecords(userService.countAll());
			dtResp.setTotalDisplayRecords(userService.countAll(predicate));
			dtResp.setData(userService.loadAllUsers(predicate));
		}
		return new ResponseEntity<DataTableResponse<UserDTO>>(dtResp,
				HttpStatus.OK);
		
	}

	/**
	 * Users page mapping.
	 * 
	 * @return users page
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public final String getUsersPage() {
		Authentication auth = SecurityContextHolder
				.getContext()
				.getAuthentication();
		if (auth instanceof AnonymousAuthenticationToken) {
			return "common/login";
		} else {
			Collection<GrantedAuthority> authorities = 
					(Collection<GrantedAuthority>) SecurityContextHolder
					.getContext()
					.getAuthentication()
					.getAuthorities();
			if (authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN")) 
					|| authorities.contains(
							new SimpleGrantedAuthority("ROLE_REDADMIN"))) {
				return "users";
			}
		}
		return "common/index";
	}

}