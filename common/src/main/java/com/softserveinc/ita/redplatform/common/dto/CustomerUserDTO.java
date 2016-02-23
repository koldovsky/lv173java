package com.softserveinc.ita.redplatform.common.dto;

/**
 * Data Transfer Object for CustomerUser class.
 * 
 * @author Ivaniv Roman
 *
 */

public class CustomerUserDTO {
    
	/**
     * first name.
     */
    private String firstName;

    /**
     * last name.
     */
    private String lastName;

    /**
     * phone. 
     */
    private String phone;

    /**
     * passport. 
     */
    private String passport;

    /** individual tax number. */
    private Integer individualTaxNumber;
    
    /**
     * address.
     */
    private AddressDTO address;
    
    /**
     * id.
     */
    private long id;
    

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

	public final AddressDTO getAddress() {
		return address;
	}

	public final void setAddress(final AddressDTO newAddress) {
		this.address = newAddress;
	}

	public final long getId() {
		return id;
	}

	public final void setId(final long newId) {
		this.id = newId;
	}

}
