package com.softserveinc.ita.redplatform.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.redplatform.common.dto.RealEstateAdminUserDTO;
import com.softserveinc.ita.redplatform.common.entity.RealEstateAdminUser;
import com.softserveinc.ita.redplatform.common.entity.User;
import com.softserveinc.ita.redplatform.common.mapper.RealEstateAdminUserMapper;
import com.softserveinc.ita.redplatform.persistence.dao.GenericDao;
import com.softserveinc.ita.redplatform.persistence.dao.RealEstateAdminUserDao;
import com.softserveinc.ita.redplatform.persistence.dao.RealEstateAgencyDao;

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
	admin.setAgency(agencyDao
		.findById(((RealEstateAdminUserDTO) dto).getAgencyId()));
	return admin;
    }
    
    @Override
    protected GenericDao<RealEstateAdminUser, Long> doGetDao() {
	return dao;
    }
}