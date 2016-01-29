package com.softserveinc.ita.redplatform.common.entity;

import javax.persistence.Entity;

/**
 * The Class User.
 * 
 * @author Ivaniv Roman
 */
@Entity
public abstract class User extends BaseEntity {

	/** The email. */
	private String email;
	
	/** The password. */
	private String password;
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public final String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param newEmail the new email
	 */
	public final void setEmail(final String newEmail) {
		email = newEmail;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public final String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param newPassword the new password
	 */
	public final void setPassword(final String newPassword) {
		password = newPassword;
	}	
}
