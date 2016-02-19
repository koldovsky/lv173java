package com.softserveinc.ita.redplatform.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.redplatform.common.dto.AdminUserDTO;
import com.softserveinc.ita.redplatform.common.entity.AdminUser;
import com.softserveinc.ita.redplatform.common.entity.User;
import com.softserveinc.ita.redplatform.common.mapper.AdminUserMapper;
import com.softserveinc.ita.redplatform.persistence.dao.AdminUserDao;

import org.springframework.security.access.annotation.Secured;

/**
 * Admin User Service.
 * 
 * @author Bulhakov Alex
 */
@Service
@Secured("ROLE_REDADMIN")
public class AdminUserService extends AbstractUserService {

    /** The admin user dao. */
    @Autowired
    private AdminUserDao dao;

    /** The admin user mapper. */
    @Autowired
    private AdminUserMapper mapper;

    @Override
    protected void doSave(final User user) {
	dao.save((AdminUser) user);
    }

    @Override
    protected User doGetUserEntity(final Object dto) {
	return mapper.toEntity((AdminUserDTO) dto);
    }

    /**
     * Check if exists.
     *
     * @param adminUserDTO
     *            the admin user dto
     * @return true, if successful
     */
    public boolean checkIfExists(final AdminUserDTO adminUserDTO) {
	return null != dao.findUserByEmail(adminUserDTO.getEmail());
    }
}
