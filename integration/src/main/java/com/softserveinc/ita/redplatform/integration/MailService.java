package com.softserveinc.ita.redplatform.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * Service for mailing clients.
 * 
 * @author Bulhakov Alex
 *
 */
@Service("mailService")
public class MailService {

    /**
     * Get mailSender bean.
     */
    @Autowired
    private MailSender mailSender;

    /**
     * Get ordinary message bean.
     */
    @Autowired
    private SimpleMailMessage ordinaryMessage;

    /**
     * Message sending with preconstructed FROM field.
     * 
     * @param to
     *            Mail recipient e-mail
     * @param subject
     *            Subject of an e-mail
     * @param body
     *            Main body of a letter
     */
    public final void sendMessage(final String to, final String subject, 
	    final String body) {
	ordinaryMessage.setTo(to);
	ordinaryMessage.setSubject(subject);
	ordinaryMessage.setText(body);

	mailSender.send(ordinaryMessage);
    }
    
    /**
     * Send preconstructed email.
     * @param simpleMessage Simple Message preconstructed by developer
     */
    public final void sendMessage(final SimpleMailMessage simpleMessage) {
	
	mailSender.send(simpleMessage);
    }
    
}
