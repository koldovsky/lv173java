package com.softserveinc.ita.redplatform.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.redplatform.business.accessory.PasswordGenerator;
import com.softserveinc.ita.redplatform.common.dto.RealEstateAdminUserDTO;
import com.softserveinc.ita.redplatform.common.entity.RealEstateAdminUser;
import com.softserveinc.ita.redplatform.common.mapper.RealEstateAdminUserMapper;
import com.softserveinc.ita.redplatform.persistence.dao.RealEstateAdminUserDao;

/**
 * The class RealEstateAdminService.
 * 
 * @author Ilona Yavorska
 */
@Service
public class RealEstateAdminUserService {
	
	/** The admin dao. */
	@Autowired
	private RealEstateAdminUserDao dao;
	
	/** The admin mapper. */
	@Autowired
	private RealEstateAdminUserMapper mapper;
	
	/** The pass generator. */
	@Autowired
	private PasswordGenerator passGenerator;
	
	/** The password encoder. */
	private PasswordEncoder passEncoder = new BCryptPasswordEncoder();
	
	/**
	 * Register new admin in the system.
	 *
	 * @param dto the dto
	 */
	@Transactional
	public void register(final RealEstateAdminUserDTO dto) {
		RealEstateAdminUser admin = mapper.toEntity(dto);
		assignPassword(admin);
		dao.save(admin);
	}
	
	/**
	 * Assigns password.
	 *
	 * @param admin the admin
	 */
	private void assignPassword(final RealEstateAdminUser admin) {
		String rawPass = passGenerator.generatePassword();
		composePassMail(admin, rawPass);
		String encodedPass = passEncoder.encode(rawPass);
		admin.setPassword(encodedPass);
	}
	
	/**
	 * Composes password mail.
	 *
	 * @param dest the destination of the mail
	 * @param pass the password
	 */
	private void composePassMail(final RealEstateAdminUser dest, 
			final String pass) {
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		simpleMessage.setFrom("REDplatform");
		simpleMessage.setTo(dest.getEmail());
		simpleMessage.setText(pass);
	}
}