package com.softserveinc.ita.redplatform.common.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
  private Integer individualTaxNumber;

  /**
  * Column Address has Set of peoples.
  */
  @OneToOne(cascade = CascadeType.ALL)
  private Address address;

  /**
   * List of orders.
   */
  @OneToMany(mappedBy = "customerUser", cascade = CascadeType.ALL)
  private List<Order> orders;
	
  /**
  * Get value of column firstName.
  *
  * @return the firstName
  */
  public final String getFirstName() {
    return firstName;
  }

  /**
  * Changes firstName value to new newFirstName.
  *
  *  @param newFirstName to be set
  */
  public final void setFirstName(final String newFirstName) {
    this.firstName = newFirstName;
  }

  /**
  * Get value of column lastName.
  *
  * @return the lastName
  */
  public final String getLastName() {
    return lastName;
  }

  /**
  * Changes lastName value to newLastName.
  *
  * @param newLastName  to be set
  */
  public final void setLastName(final String newLastName) {
    this.lastName = newLastName;
  }

  /**
  * Get value of column phone.
  *
  * @return the phone
  */
  public final String getPhone() {
    return phone;
  }

  /**
  * Changes phone value to newPhone.
  *
  * @param newPhone  to be set
  */
  public final void setPhone(final String newPhone) {
    this.phone = newPhone;
  }

  /**
  * Get value of column passport.
  *
  * @return the passport
  */
  public final String getPassport() {
    return passport;
  }

  /**
  * Changes passport value to newPassport.
  *
  * @param newPassport 
  * 
  */
  public final void setPassport(final String newPassport) {
    this.passport = newPassport;
  }

  /**
  * Get value of column individualTAXNumber.
  *
  * @return the individualTaxNumber
  */
  public final Integer getIndividualTaxNumber() {
    return individualTaxNumber;
  }

  /**
  * Changes individualTaxNumber value to newIndividualTaxNumber.
  *
  * @param newIndividualTaxNumb to be set 
  */
  public final void setIndividualTaxNumber(final Integer newIndividualTaxNumb) {
    this.individualTaxNumber = newIndividualTaxNumb;
  }

  /**
  * Get value of column address.
  *
  * @return the address
  */
  public final Address getAddress() {
    return address;
  }

  /**
  * Changes address value to newAddress.
  *
  * @param newAddress  to be set
  */
  public final void setAddress(final Address newAddress) {
    this.address = newAddress;
  }
  
  /**
  * Get value of orders.
  *
  * @return the orders
  */
  public final List<Order> getOrders() {
	return orders;
  }

  /**
  * Changes orders value to newOrders.
  *
  * @param newOrders  to be set
  */
  public final void setOrders(final List<Order> newOrders) {
	this.orders = newOrders;
  }

  
}