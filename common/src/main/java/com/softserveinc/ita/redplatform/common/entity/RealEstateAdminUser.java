package com.softserveinc.ita.redplatform.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Class represents Real estate administrators
 * 
 * @author Oleksiy Bulhakov
 */
@Entity
@Table(name = "RealEstateAdminUsers")
public class RealEstateAdminUser extends User {
    /**
     * Serializable UID.
     */
    private static final long serialVersionUID = 6731612338595564614L;

    /**
     * Column for first admin`s name.
     */
    @Column(name = "firstName")
    private String firstName;

    /**
     * Column for last admin`s name.
     */
    @Column(name = "lastName")
    private String lastName;

    /**
     * Column for phone.
     */
    @Column(name = "phone")
    private String phone;

    /**
     * Many to One connection to Real Estate Agencies.
     */
    @ManyToOne
    private RealEstateAgency agency;

    /**
     * Get value of column first name.
     *
     * @return first name
     */
    public final String getFirstName() {
	return firstName;
    }

    /**
     * Changes first name.
     *
     * @param newFirstName
     *            is name to be set
     */
    public final void setFirstName(final String newFirstName) {
	this.firstName = newFirstName;
    }

    /**
     * Get value of column last name.
     *
     * @return last name
     */
    public final String getLastName() {
	return lastName;
    }

    /**
     * Changes last name.
     *
     * @param newLastName
     *            is name to be set
     */
    public final void setLastName(final String newLastName) {
	this.lastName = newLastName;
    }

    /**
     * Get value of column phone.
     *
     * @return phone
     */
    public final String getPhone() {
	return phone;
    }

    /**
     * Changes phone.
     *
     * @param newPhone
     *            is phone to be set
     */
    public final void setPhone(final String newPhone) {
	this.phone = newPhone;
    }

    /**
     * Get value of column agency.
     *
     * @return agency
     */
    public final RealEstateAgency getAgency() {
	return agency;
    }

    /**
     * Changes agency.
     *
     * @param newAgency
     *            is phone to be set
     */
    public final void setAgency(final RealEstateAgency newAgency) {
	this.agency = newAgency;
    }
/*
    @Override
    public final boolean equals(final Object obj) {
	if (this == obj) {
	    return true;
	}
	if (!super.equals(obj)) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	RealEstateAdminUser other = (RealEstateAdminUser) obj;
	if (agency == null) {
	    if (other.agency != null) {
		return false;
	    }
	} else if (!agency.equals(other.agency)) {
	    return false;
	}
	if (firstName == null) {
	    if (other.firstName != null) {
		return false;
	    }
	} else if (!firstName.equals(other.firstName)) {
	    return false;
	}
	if (lastName == null) {
	    if (other.lastName != null) {
		return false;
	    }
	} else if (!lastName.equals(other.lastName)) {
	    return false;
	}
	if (phone == null) {
	    if (other.phone != null) {
		return false;
	    }
	} else if (!phone.equals(other.phone)) {
	    return false;
	}
	return true;
    }

    @Override
    public final int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((agency == null) ? 0 : agency.hashCode());
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
	result = prime * result + ((phone == null) ? 0 : phone.hashCode());
	return result;
    }*/

}
