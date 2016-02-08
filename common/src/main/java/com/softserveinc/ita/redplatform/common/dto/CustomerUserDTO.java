package com.softserveinc.ita.redplatform.common.dto;

import javax.persistence.Column;

/**
 * Data Transfer Object for CustomerUser class.
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
    private long individualTaxNumber;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPassport() {
    return passport;
  }

  public void setPassport(String passport) {
    this.passport = passport;
  }

  public long getIndividualTaxNumber() {
    return individualTaxNumber;
  }

  public void setIndividualTaxNumber(long individualTaxNumber) {
    this.individualTaxNumber = individualTaxNumber;
  }
    
}
