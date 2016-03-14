package com.softserveinc.ita.redplatform.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Class represents Real estate administrators.
 * 
 * @author Oleksiy Bulhakov
 */
@Entity
@Table(name = "RealEstateAdminUsers")
public class RealEstateAdminUser extends User {
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
    @ManyToOne(fetch = FetchType.EAGER)
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
     * @param newAgency the new agency
     */
    public final void setAgency(final RealEstateAgency newAgency) {
	this.agency = newAgency;
    }

}
