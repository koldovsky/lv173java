package com.softserveinc.ita.redplatform.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.redplatform.common.dto.RealEstateAdminUserDTO;
import com.softserveinc.ita.redplatform.common.entity.RealEstateAdminUser;
import com.softserveinc.ita.redplatform.common.entity.User;
import com.softserveinc.ita.redplatform.common.mapper.RealEstateAdminUserMapper;
import com.softserveinc.ita.redplatform.persistence.dao.RealEstateAdminUserDao;

/**
 * The class RealEstateAdminService.
 * 
 * @author Ilona Yavorska
 */
@Service
public class RealEstateAdminUserService extends AbstractUserService {
	
    /** The admin user dao. */
    @Autowired
    private RealEstateAdminUserDao dao;

    /** The admin user mapper. */
    @Autowired
    private RealEstateAdminUserMapper mapper;
    
    @Override
    protected void doSave(final User user) {
    	dao.save((RealEstateAdminUser) user);
   }
	
	@Override
	protected User doGetUserEntity(final Object dto) {
		return mapper.toEntity((RealEstateAdminUserDTO) dto);
	}

	@Override
	protected void doSetContentAndPassword(final SimpleMailMessage message,
			final User user, final String password) {
		RealEstateAdminUser admin = (RealEstateAdminUser) user;
		String notification =
				(new StringBuilder())
				.append("Hi, ")
				.append(admin.getFirstName())
				.append(" ")
				.append(admin.getLastName())
				.append(", ")
				.append("and welcome to the REDplatform! ")
				.append("You can find your credentials below: \n")
				.append("Username: ")
				.append(admin.getEmail())
				.append("\nPassword: ")
				.append(password)
				.toString();
		message.setText(notification);
	}
}