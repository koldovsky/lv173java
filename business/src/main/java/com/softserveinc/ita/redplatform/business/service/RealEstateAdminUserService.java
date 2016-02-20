package com.softserveinc.ita.redplatform.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.redplatform.common.dto.RealEstateAdminUserDTO;
import com.softserveinc.ita.redplatform.common.entity.RealEstateAdminUser;
import com.softserveinc.ita.redplatform.common.entity.User;
import com.softserveinc.ita.redplatform.common.mapper.RealEstateAdminUserMapper;
import com.softserveinc.ita.redplatform.persistence.dao.RealEstateAdminUserDao;
import com.softserveinc.ita.redplatform.persistence.dao.RealEstateAgencyDao;

import org.springframework.security.access.annotation.Secured;

/**
 * The class RealEstateAdminService.
 * 
 * @author Ilona Yavorska
 */
@Service
@Secured("ROLE_ADMIN")
public class RealEstateAdminUserService extends AbstractUserService {

    /** The admin user dao. */
    @Autowired
    private RealEstateAdminUserDao dao;

    /** The agency dao. */
    @Autowired
    private RealEstateAgencyDao agencyDao;

    /** The admin user mapper. */
    @Autowired
    private RealEstateAdminUserMapper mapper;

    @Override
    protected User doGetUserEntity(final Object dto) {
	RealEstateAdminUser admin = mapper.toEntity((RealEstateAdminUserDTO) dto);
	Long agencyId = admin.getAgency().getId();
	admin.setAgency(agencyDao.findById(agencyId));
	return admin;
    }

    @Override
    protected void doSave(final User user) {
	RealEstateAdminUser admin = (RealEstateAdminUser) user;
	dao.save(admin);
    }
    
    /**
     * Load user by email.
     *
     * @param email the email
     * @return the user
     */
    @Transactional
    public User loadUserByEmail(final String email) {
	return dao.findUserByEmail(email);
    }
}