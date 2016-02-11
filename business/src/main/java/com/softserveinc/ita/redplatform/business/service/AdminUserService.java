package com.softserveinc.ita.redplatform.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.redplatform.business.accessory.PasswordGenerator;
import com.softserveinc.ita.redplatform.common.dto.AdminUserDTO;
import com.softserveinc.ita.redplatform.common.entity.AdminUser;
import com.softserveinc.ita.redplatform.common.mapper.AdminUserMapper;
import com.softserveinc.ita.redplatform.integration.MailService;
import com.softserveinc.ita.redplatform.persistence.dao.AdminUserDao;


/**
 * Service for AdminUser.
 *
 * @author Bulhakov Alex
 */
@Service
public class AdminUserService {
    
    /** The admin user dao. */
    @Autowired
    private AdminUserDao adminUserDao;
    
    /** The admin user mapper. */
    @Autowired
    private AdminUserMapper adminUserMapper;
    
    /** The mail service. */
    @Autowired
    private MailService mailService;
    
    /** The password generator. */
    @Autowired
    private PasswordGenerator passwordGenerator;
    
    /** The length of password. */
    private final int length = 10; 
    
    /**
     * Creates the.
     *
     * @param adminUserDTO the admin user dto
     */
    @Transactional
    public void create(final AdminUserDTO adminUserDTO) {
	AdminUser adminUser = adminUserMapper.toEntity(adminUserDTO);
	adminUser.setPassword(passwordGenerator.generatePassword(length));
	SimpleMailMessage simpleMessage = new SimpleMailMessage();
	simpleMessage.setFrom("Me");
	simpleMessage.setTo(adminUser.getEmail());
	simpleMessage.setText(adminUser.getPassword());
	mailService.sendMessage(simpleMessage);
	
	
    }
    

}
