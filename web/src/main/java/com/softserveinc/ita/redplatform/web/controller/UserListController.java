package com.softserveinc.ita.redplatform.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softserveinc.ita.redplatform.business.service.UserService;
import com.softserveinc.ita.redplatform.common.entity.AdminUser;
import com.softserveinc.ita.redplatform.common.entity.CustomerUser;
import com.softserveinc.ita.redplatform.common.entity.RealEstateAdminUser;
import com.softserveinc.ita.redplatform.common.entity.User;

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
	 * Users page mapping.
	 * 
	 * @param model
	 *            represents ModelMap
	 * 
	 * @return users page
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public final String getUserList(final ModelMap model) {
		String username = SecurityContextHolder
					.getContext()
					.getAuthentication()
					.getPrincipal()
					.toString();
		if (username.equals("anonymousUser")) {
			return "login";
		}
		User user = userService.loadUserByEmail(username);
		if (user instanceof CustomerUser) {
			return "index";
		} else if (user instanceof AdminUser) {
			model.addAttribute("list", userService.loadAllUsers());
			return "users";
		} else if (user instanceof RealEstateAdminUser) {
			model.addAttribute("lsit", userService
					.loadUserByCompany(
							((RealEstateAdminUser) user)
							.getAgency().getName()));
			return "user";
		}
		return "index";
	}

}