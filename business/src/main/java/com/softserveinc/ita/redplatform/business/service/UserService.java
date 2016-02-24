package com.softserveinc.ita.redplatform.business.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.redplatform.common.dto.UserDTO;
import com.softserveinc.ita.redplatform.common.entity.User;
import com.softserveinc.ita.redplatform.common.mapper.UserMapper;
import com.softserveinc.ita.redplatform.common.predicate.DataTablePredicate;
import com.softserveinc.ita.redplatform.persistence.dao.UserDao;
import com.softserveinc.ita.redplatform.persistence.listener.SecurityContext;

/**
 * User Service.
 * @author oleh
 *
 */
@Service
@Transactional
public class UserService {
    
    /**
     * SecurityContext.
     */
    @Autowired
    private SecurityContext securityContext;
    
    /**
     * userDao.
     */
    @Autowired
    private UserDao userDao;
    
    /**
     * UserMapper.
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * load user by email.
     * @param email user email
     * @return User
     */
    public User loadUserByEmail(final String email) {
	return userDao.findUserByEmail(email);
    }
    
    /**
     * load all users.
     * @param predicate predicate
     * @return List<User>
     */
    @Secured("ROLE_ADMIN")
	public List<UserDTO> loadAllUsers(final DataTablePredicate predicate) {
    	List<UserDTO> list = new LinkedList<UserDTO>();
    	for (User user : userDao.findAll(predicate)) {
    		list.add(userMapper.toDto(user));
    	}
    	return list;
    }
    
    /**
     * load all users dealing with company.
     * @param email company admin email
     * @param predicate predicate
     * @return List<User>
     */
    @Secured("ROLE_REDADMIN")
    public List<UserDTO> 
    	loadUsersByCompanyAdmin(final String email, 
    			final DataTablePredicate predicate) {
    	List<UserDTO> list = new LinkedList<UserDTO>();
		for (User user :  userDao.findCompanyUsersByCompanyAdmin(email, 
				predicate)) {
			list.add(userMapper.toDto(user));
		}
		return list;
    }
    
    /**
     * Checks if email is available.
     *
     * @param email the email
     * @return true, if email is available
     */
    public boolean isEmailAvailable(final String email) {
	return userDao.findUserByEmail(email) == null;
    }
    
    /**
     * count all users.
     * @return count
     */
    @Secured("ROLE_ADMIN")
    public long countAll() {
    	return userDao.countAll();
    }
    
    /**
     * count all users with predicate.
     * @param predicate 
     * @return count.
     */
    @Secured("ROLE_ADMIN")
    public long countAll(final DataTablePredicate predicate) {
		return userDao.countAll(predicate);
    	
    }
    /**
     * count all users.
     * @param email Admin email
     * @return count
     */
    @Secured("ROLE_REDADMIN")
    public long countAllCompanyUsers(final String email) {
    	return userDao.countAllCompanyUsers(email);
    }
    
    /**
     * count all users with predicate.
     * @param email Admin email
     * @param predicate 
     * @return count.
     */
    @Secured("ROLE_REDADMIN")
    public long countAllCompanyUsers(final String email, 
    		final DataTablePredicate predicate) {
		return userDao.countAllCompanyUsers(email, predicate);
    	
    }
    
    /**
     * set Logged User to SecurityContext.
     *
     * @param user the user
     */
    public void setLoggedUser(
	    final org.springframework.security.core.userdetails.User user) {
	  securityContext.set(user);
    }
}
