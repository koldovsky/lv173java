package com.softserveinc.ita.redplatform.business.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.redplatform.common.dto.UserDTO;
import com.softserveinc.ita.redplatform.common.entity.User;
import com.softserveinc.ita.redplatform.common.mapper.UserMapper;
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
     * 
     * @return List<User>
     */
    public List<UserDTO> loadAllUsers() {
    	List<UserDTO> list = new LinkedList<UserDTO>();
    	for (User user : userDao.findAll()) {
    		list.add(userMapper.toDto(user));
    	}
    	return list;
    }
    
    /**
     * load all users dealing with company.
     * @param companyName company name
     * @return List<User>
     */
    public List<UserDTO> 
    	loadUserByCompany(final String companyName) {
    	List<UserDTO> list = new LinkedList<UserDTO>();
		for (User user :  userDao.findUsersByCompany(companyName)) {
			list.add(userMapper.toDto(user));
		}
		return list;
    }
}
