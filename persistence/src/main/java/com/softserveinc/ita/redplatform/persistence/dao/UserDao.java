package com.softserveinc.ita.redplatform.persistence.dao;


import java.util.List;

import com.softserveinc.ita.redplatform.common.entity.User;

/**
 * DAO implementation for User.
 * 
 * @author Oleh Khimka
 */
public interface UserDao extends GenericDao<User, Long> {
    
    /**
     * find user by email.
     * @param email user email
     * @return User
     */
    User findUserByEmail(String email);
    
    /**
     * find all users.
     * 
     * @return List<User>
     */
    List<User> findAll();
}
