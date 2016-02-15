package com.softserveinc.ita.redplatform.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.redplatform.business.accessory.PasswordGenerator;
import com.softserveinc.ita.redplatform.common.entity.User;
import com.softserveinc.ita.redplatform.integration.MailService;
import org.springframework.mail.SimpleMailMessage;

/**
 * The Class AbstractUserService.
 * 
 * @author Ilona Yavorska
 */
@Service
public abstract class AbstractUserService {
	
    /** The mail service. */
    @Autowired
    private MailService mailService;
	
	/** The pass generator. */
	@Autowired
	private PasswordGenerator passGenerator;
	
	/** The pass encoder. */
	private PasswordEncoder passEncoder = new BCryptPasswordEncoder();

	/**
	 * Register new user.
	 *
	 * @param dto the dto
	 */
	@Transactional
	public void register(final Object dto) {
		User user = doGetUserEntity(dto);
		String rawPassword = passGenerator.generatePassword();
		notifyUserWithMail(user, rawPassword);
		String encodedPassword = passEncoder.encode(rawPassword);
		user.setPassword(encodedPassword);
		doSave(user);
	}
	
	/**
	 * Get user entity.
	 *
	 * @param dto the dto
	 * @return the user
	 */
	protected abstract User doGetUserEntity(Object dto);
	
	/**
	 * Notify user with mail.
	 *
	 * @param recipient the recipient of the mail
	 * @param password the password
	 */
	private void notifyUserWithMail(final User recipient, 
			final String password) {
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		simpleMessage.setFrom("REDplatform");
		simpleMessage.setTo(recipient.getEmail());
		doSetContentAndPassword(simpleMessage, recipient, password);
		mailService.sendMessage(simpleMessage);
	}
	
	/**
	 * Set content and password.
	 *
	 * @param message the message
	 * @param user the user
	 * @param password the raw password
	 */
	protected abstract void doSetContentAndPassword(
			final SimpleMailMessage message, 
			final User user, final String password);
	
	/**
	 * Save user in the database.
	 *
	 * @param user the user
	 */
	protected abstract void doSave(final User user);
}
