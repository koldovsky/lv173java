package com.softserveinc.ita.redplatform.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.redplatform.common.entity.User;
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
    public final List<User> loadAllUsers() {
	return userDao.findAll();
    }
    
    /**
     * load all users dealing with company.
     * @param companyName company name
     * @return List<User>
     */
    public final List<User> loadUserByCompany(final String companyName) {
	return userDao.findUsersByCompany(companyName);
    }
}
