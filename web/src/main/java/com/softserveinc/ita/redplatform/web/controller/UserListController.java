package com.softserveinc.ita.redplatform.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softserveinc.ita.redplatform.business.service.UserService;
import com.softserveinc.ita.redplatform.common.dto.UserDTO;

/**
 * Controller for users page.
 * 
 * @author Hryhorii Somyk
 *
 */

@Controller
public class UserListController {

	/**
	 * User Service.
	 */
	@Autowired
	private UserService userService;

	/**
	 * Returns User list.
	 * 
	 * @return users list
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseBody
	public final List<UserDTO> getUserList() {
		return userService.loadAllUsers();
	}

	/**
	 * Users page mapping.
	 * 
	 * @return users page
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public final String getUsersPage() {
		return "users";
	}

}