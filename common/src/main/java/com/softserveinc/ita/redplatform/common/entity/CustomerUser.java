package com.softserveinc.ita.redplatform.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Class that represents Currency Rate.
 *
 * @author Roman Ivaniv
 */
@Entity
@Table(name = "CustomerUsers")
public class CustomerUser extends User {
    /**
     * Column for First name of Customer.
     */
    @Column(name = "firstName")
    private String firstName;

    /**
     * Column for Last name of Customer.
     */
    @Column(name = "lastName")
    private String lastName;

    /**
     * Column for Customer phone.
     */
    @Column(name = "phone")
    private String phone;

    /**
     * Column for Customer passport.
     */
    @Column(name = "passport")
    private String passport;

    /**
     * Column for Customer individualTaxNumber.
     */
    @Column(name = "individualTaxNumber")
    private long individualTaxNumber;

    /**
     * Column Address has Set of peoples.
     */
    @ManyToOne
    @JoinColumn(name = "addressId")
    private Address address;

    /**
     * Get value of column firstName.
     *
     * @return the firstName
     */
    public String getFirstName() {
	return firstName;
    }

    /**
     * Changes firstName value to new newFirstName.
     *
     * @param newFirstName
     *            amount to be set
     */
    public void setFirstName(String newFirstName) {
	this.firstName = newFirstName;
    }

    /**
     * Get value of column lastName.
     *
     * @return the lastName
     */
    public String getLastName() {
	return lastName;
    }

    /**
     * Changes lastName value to newLastName.
     *
     * @param newLastName
     *            amount to be set
     */
    public void setLastName(String newLastName) {
	this.lastName = newLastName;
    }

    /**
     * Get value of column phone.
     *
     * @return the phone
     */
    public String getPhone() {
	return phone;
    }

    /**
     * Changes phone value to newPhone.
     *
     * @param newPhone
     *            amount to be set
     */
    public void setPhone(String newPhone) {
	this.phone = newPhone;
    }

    /**
     * Get value of column passport.
     *
     * @return the passport
     */
    public String getPassport() {
	return passport;
    }

    /**
     * Changes passport value to newPassport.
     *
     * @param newPassport
     *            amount to be set
     */
    public void setPassport(String newPassport) {
	this.passport = newPassport;
    }

    /**
     * Get value of column individualTAXNumber.
     *
     * @return the individualTaxNumber
     */
    public long getIndividualTaxNumber() {
	return individualTaxNumber;
    }

    /**
     * Changes individualTaxNumber value to newIndividualTaxNumber.
     *
     * @param newIndividualTaxNumber
     *            amount to be set
     */
    public void setIndividualTaxNumber(long newIndividualTaxNumber) {
	this.individualTaxNumber = newIndividualTaxNumber;
    }

    /**
     * Get value of column address.
     *
     * @return the address
     */
    public Address getAddress() {
	return address;
    }

    /**
     * Changes address value to newAddress.
     *
     * @param newAddress
     *            amount to be set
     */
    public void setAddress(Address newAddress) {
	this.address = newAddress;
    }

    /**
     * Overriding toString method()
     *
     */
    @Override
    public String toString() {
	return "CustomerUser [FirstName=" + firstName + ", LastName=" + lastName + ", phone=" + phone + ", passport="
		+ passport + ", individualTaxNumber=" + individualTaxNumber + "]";
    }

}