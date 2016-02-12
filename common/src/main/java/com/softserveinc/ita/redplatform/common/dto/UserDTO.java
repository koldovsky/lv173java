package com.softserveinc.ita.redplatform.common.dto;

import java.util.Date;

/**
 * Data Transfer Object general for Users class.
 * 
 * @author Hryhorii
 *
 */

public class UserDTO {
	
	/**
	 * companyName.
	 */
	private String companyName;
	
	/**
	 * email.
	 */
	private String email;
	
	/**
	 * name.
	 */
	private String name;
	
	/**
	 * phone.
	 */
	private String phone;
	
	/**
	 * created.
	 */
	private Date createdDate;

	public final String getEmail() {
		return email;
	}

	public final void setEmail(final String newEmail) {
		this.email = newEmail;
	}

	public final String getName() {
		return name;
	}

	public final void setName(final String newName) {
		this.name = newName;
	}

	public final String getPhone() {
		return phone;
	}

	public final void setPhone(final String newPhone) {
		this.phone = newPhone;
	}

	public final Date getCreatedDate() {
		return createdDate;
	}

	public final void setCreatedDate(final Date newCreatedDate) {
		this.createdDate = newCreatedDate;
	}

	public final String getCompanyName() {
		return companyName;
	}

	public final void setCompanyName(final String newCompanyName) {
		this.companyName = newCompanyName;
	}

}
