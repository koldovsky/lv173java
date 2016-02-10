package com.softserveinc.ita.redplatform.common.dto;

import javax.persistence.Column;

/**
 * Data Transfer Object for CustomerUser class.
 * 
 * @author Ivaniv Roman
 *
 */
public class CustomerUserDTO {
    /** first name. */
    @Column(name = "firstName")
    private String firstName;

    /** last name. */
    @Column(name = "lastName")
    private String lastName;

    /** phone. */
    @Column(name = "phone")
    private String phone;

    /** passport. */
    @Column(name = "passport")
    private String passport;

    /** individual tax number. */
    @Column(name = "individualTaxNumber")
    private Integer individualTaxNumber;

    public final String getFirstName() {
	return firstName;
    }

    public final void setFirstName(final String newFirstName) {
	this.firstName = newFirstName;
    }

    public final String getLastName() {
	return lastName;
    }

    public final void setLastName(final String newLastName) {
	this.lastName = newLastName;
    }

    public final String getPhone() {
	return phone;
    }

    public final void setPhone(final String newPhone) {
	this.phone = newPhone;
    }

    public final String getPassport() {
	return passport;
    }

    public final void setPassport(final String newPassport) {
	this.passport = newPassport;
    }

    public final Integer getIndividualTaxNumber() {
	return individualTaxNumber;
    }

    public final void 
    setIndividualTaxNumber(final Integer newIndividualTaxNumber) {
	this.individualTaxNumber = newIndividualTaxNumber;
    }

}
