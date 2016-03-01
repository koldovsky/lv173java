package com.softserveinc.ita.redplatform.business.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.redplatform.common.entity.AdminUser;
import com.softserveinc.ita.redplatform.common.entity.RealEstateAdminUser;

/**
 * Implementation of UserDetailsService.
 * 
 * @author Ivaniv Roman
 *
 */
@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    /**
     * Using UserService object.
     */
    private UserService userService;

    @Transactional(readOnly = true)
    @Override
    public final UserDetails loadUserByUsername(final String username)
	    throws UsernameNotFoundException {

	HashSet<String> set = new HashSet<String>();
	com.softserveinc.ita.redplatform.common.entity.User user = 
		userService.loadUserByEmail(username);
	if (user instanceof AdminUser) {
	    set.add(new String("ROLE_ADMIN"));
	} else if (user instanceof RealEstateAdminUser) {
	    set.add(new String("ROLE_REDADMIN"));
	} else {
	    set.add(new String("ROLE_USER"));
	}
	List<GrantedAuthority> authorities = buildUserAuthority(set);
	return buildUserForAuthentication(user, authorities);

    }

    /**
     * 
     * @param user
     *            Receiving user object
     * @param authorities
     *            Receiving list of user authorities
     * @return returning user object
     */
    private User buildUserForAuthentication(
	    final com.softserveinc.ita.redplatform.common.entity.User user,
	    final List<GrantedAuthority> authorities) {
	
	return new User(user.getEmail(), user.getPassword(), 
		true, true, true, true, authorities);
    }

    /**
     * 
     * @param userRoles
     *            receiving
     * @return Returning list of authorities
     */
    private List<GrantedAuthority> buildUserAuthority(
	    final Set<String> userRoles) {

	Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
	// Build user's authorities
	for (String userRole : userRoles) {
	    setAuths.add(new SimpleGrantedAuthority(userRole));
	}
	List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);

	return result;
    }

    public final UserService getUserService() {
	return userService;
    }

    public final void setUserService(final UserService newUserService) {
	this.userService = newUserService;
    }

}