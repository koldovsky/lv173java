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

/**
 * User Service.
 * @author oleh
 *
 */
@Service
@Transactional
public class UserService {
    
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
     * @return List<User>
     */
    @Secured("ROLE_REDADMIN")
    public List<UserDTO> 
    	loadUsersByCompanyAdmin(final String email) {
    	List<UserDTO> list = new LinkedList<UserDTO>();
		for (User user :  userDao.findCompanyUsersByCompanyAdmin(email)) {
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
    public long countAll() {
    	return userDao.countAll();
    }
    
    /**
     * count all users with predicate.
     * @param predicate 
     * @return count.
     */
    public long countAll(final DataTablePredicate predicate) {
		return userDao.countAll(predicate);
    	
    }
}
