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
import org.springframework.stereotype.Repository;

import com.softserveinc.ita.redplatform.common.entity.AdminUser;
import com.softserveinc.ita.redplatform.persistence.dao.impl.JPAAdminUserDao;

/**
 * Implementation of UserDetailsService.
 * 
 * @author Ivaniv Roman
 *
 */
@Repository
public class UserDetailsServiceImplementation implements UserDetailsService {

	/**
	 * Using JPAAdminUserDao object.
	 */
	private  JPAAdminUserDao jpaUserDao;
	
     @Override
	public final UserDetails loadUserByUsername(final String username) 
			throws UsernameNotFoundException {
		
		HashSet<String> set = new HashSet<String>();
		AdminUser user = (AdminUser) jpaUserDao.findUserByEmail(username);
		if (user instanceof AdminUser) {
			set.add(new String("ROLE_USER"));
			set.add(new String("ROLE_ADMIN"));
			set.add(new String("ROLE_REDADMIN"));
		} else {
			set.add(new String("ROLE_USER"));
		}
		List<GrantedAuthority> authorities = buildUserAuthority(set);
		return buildUserForAuthentication(user, authorities);
		
	}

    /**
     * 
     * @param user Receiving user object
     * @param authorities Receiving list of user authorities 
     * @return returning user object 
     */
	private User buildUserForAuthentication(final AdminUser user, 
			final List<GrantedAuthority> authorities) {
		return new User(user.getEmail(), user.getPassword(), true, 
				true, true, true, authorities);
	}

	/**
	 * 
	 * @param userRoles receiving
	 * @return Returning list of authorities
	 */
	private List<GrantedAuthority> buildUserAuthority(final 
			Set<String> userRoles) {
		
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		// Build user's authorities
		for (String userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole));
		}
		List<GrantedAuthority> result = new 
				ArrayList<GrantedAuthority>(setAuths);
		
		return result;
	}

	public final JPAAdminUserDao getJpaUserDao() {
		return jpaUserDao;
	}

	public final void setJPAAdminUserDao(final JPAAdminUserDao newJpaUserDao) {
		this.jpaUserDao = newJpaUserDao;
	}
}