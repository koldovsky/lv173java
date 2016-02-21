package com.softserveinc.ita.redplatform.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.redplatform.business.accessory.PasswordGenerator;
import com.softserveinc.ita.redplatform.common.entity.User;
import com.softserveinc.ita.redplatform.integration.MailService;
import com.softserveinc.ita.redplatform.persistence.dao.GenericDao;

/**
 * The Class AbstractUserService.
 * 
 * @author Ilona Yavorska
 */
public abstract class AbstractUserService {

    /** The mail service. */
    @Autowired
    private MailService mailService;

    /** The pass generator. */
    @Autowired
    private PasswordGenerator passGenerator;

    /** The pass encoder. */
    @Autowired
    private PasswordEncoder passEncoder;

    /**
     * Register new user.
     *
     * @param dto
     *            the dto
     */
    @Transactional
    public void register(final Object dto) {
	User user = doGetUserEntity(dto);
	String rawPassword = passGenerator.generatePassword();
	notifyUserWithMail(user, rawPassword);
	String encodedPassword = passEncoder.encode(rawPassword);
	user.setPassword(encodedPassword);
	doGetDao().save(user);
    }

    /**
     * Get user entity.
     *
     * @param dto
     *            the dto
     * @return the user
     */
    protected abstract User doGetUserEntity(Object dto);

    /**
     * Notify user with mail.
     *
     * @param recipient
     *            the recipient of the mail
     * @param password
     *            the password
     */
    private void notifyUserWithMail(final User recipient, 
	    final String password) {
	SimpleMailMessage simpleMessage = new SimpleMailMessage();
	simpleMessage.setFrom("REDplatform");
	simpleMessage.setTo(recipient.getEmail());
	simpleMessage.setSubject("Registration");
	setContentAndPassword(simpleMessage, recipient, password);
	mailService.sendMessage(simpleMessage);
    }

    /**
     * Sets the content and password.
     *
     * @param message
     *            the message
     * @param user
     *            the user
     * @param password
     *            the password
     */
    private void setContentAndPassword(final SimpleMailMessage message, 
	    final User user, final String password) {
	String notification = "Welcome to the REDplatform! "
		+ "You can find your credentials below:\nUsername: %s\nPassword: %s";
	message.setText(String.format(notification, user.getEmail(), password));
    }
    
    /**
     * Get dao.
     *
     * @return the dao
     */
    protected abstract GenericDao doGetDao();
}
