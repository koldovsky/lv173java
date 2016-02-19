package com.softserveinc.ita.redplatform.common.dto;

/**
 * The class RealEstateAdminUserDTO.
 * 
 * @author Ilona Yavorska
 */
public class RealEstateAdminUserDTO {

    /** The id. */
    private Long id;

    /** The first name. */
    private String firstName;

    /** The last name. */
    private String lastName;

    /** The email. */
    private String email;

    /** The phone. */
    private String phone;

    /** The agency id. */
    private Long agencyId;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public final Long getId() {
	return id;
    }

    /**
     * Sets the id.
     *
     * @param newId
     *            the new id
     */
    public final void setId(final Long newId) {
	id = newId;
    }

    /**
     * Gets the firstName.
     * 
     * @return the firstName
     */
    public final String getFirstName() {
	return firstName;
    }

    /**
     * Sets the firstName.
     * 
     * @param newFirstName
     *            the firstName to set
     */
    public final void setFirstName(final String newFirstName) {
	firstName = newFirstName;
    }

    /**
     * Gets the lastName.
     * 
     * @return the lastName
     */
    public final String getLastName() {
	return lastName;
    }

    /**
     * Sets the lastName.
     * 
     * @param newLastName
     *            the lastName to set
     */
    public final void setLastName(final String newLastName) {
	lastName = newLastName;
    }

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
     * @param newEmail
     *            the email to set
     */
    public final void setEmail(final String newEmail) {
	email = newEmail;
    }

    /**
     * Gets the phone.
     * 
     * @return the phone
     */
    public final String getPhone() {
	return phone;
    }

    /**
     * Sets the phone.
     * 
     * @param newPhone
     *            the phone to set
     */
    public final void setPhone(final String newPhone) {
	phone = newPhone;
    }

    /**
     * Gets the agency id.
     * 
     * @return the agency id
     */
    public final Long getAgencyId() {
	return agencyId;
    }

    /**
     * Sets the agency id.
     * 
     * @param newAgencyId
     *            the agency id to set
     */
    public final void setAgencyId(final Long newAgencyId) {
	agencyId = newAgencyId;
    }
}
