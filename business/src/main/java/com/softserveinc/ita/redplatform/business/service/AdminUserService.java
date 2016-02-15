package com.softserveinc.ita.redplatform.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.redplatform.common.dto.AdminUserDTO;
import com.softserveinc.ita.redplatform.common.entity.AdminUser;
import com.softserveinc.ita.redplatform.common.entity.RealEstateAdminUser;
import com.softserveinc.ita.redplatform.common.entity.User;
import com.softserveinc.ita.redplatform.common.mapper.AdminUserMapper;
import com.softserveinc.ita.redplatform.persistence.dao.AdminUserDao;
import org.springframework.mail.SimpleMailMessage;

/**
 * The class RealEstateAdminService.
 * 
 * @author Ilona Yavorska
 */
@Service
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

	@Override
	protected void doSetContentAndPassword(final SimpleMailMessage message, 
			final User user, final String password) {
		RealEstateAdminUser admin = (RealEstateAdminUser) user;
		String notification =
				(new StringBuilder())
				.append("Hi and welcome to the REDplatform! ")
				.append("You can find your credentials below: \n")
				.append("Username: ")
				.append(admin.getEmail())
				.append("\nPassword: ")
				.append(password)
				.toString();
		message.setText(notification);
	}
}