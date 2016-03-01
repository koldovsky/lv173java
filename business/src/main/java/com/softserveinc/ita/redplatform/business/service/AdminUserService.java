package com.softserveinc.ita.redplatform.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.redplatform.common.dto.AdminUserDTO;
import com.softserveinc.ita.redplatform.common.entity.AdminUser;
import com.softserveinc.ita.redplatform.common.entity.User;
import com.softserveinc.ita.redplatform.common.mapper.AdminUserMapper;
import com.softserveinc.ita.redplatform.persistence.dao.AdminUserDao;

/**
 * Admin User Service.
 * 
 * @author Bulhakov Alex
 */
@Service
@Secured("ROLE_ADMIN")
public class AdminUserService extends AbstractUserService {

    /** The admin user dao. */
    @Autowired
    private AdminUserDao dao;

    /** The admin user mapper. */
    @Autowired
    private AdminUserMapper mapper;

    @Override
    protected AdminUser getEntity(final Object dto) {
	return mapper.toEntity((AdminUserDTO) dto);
    }

    @Override
    protected AdminUserDao getDao() {
	return dao;
    }

    @Override
    protected AdminUserDTO getUserDTO(final User admin) {
	return mapper.toDto((AdminUser) admin);
    }

}
