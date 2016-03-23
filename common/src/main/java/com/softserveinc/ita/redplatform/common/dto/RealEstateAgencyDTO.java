package com.softserveinc.ita.redplatform.common.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

/**
 * Data Transfer Object for RealEstateAgency class.
 * 
 * @author Oleh Khimka
 *
 */
public class RealEstateAgencyDTO {

    /** The Constant NAME_REGEX. */
    public static final String NAME_REGEX = "^(?=.*[a-zA-Z])[a-zA-Z0-9\\s]{1}"
	    + "[a-zA-Z0-9!.@&$():,\\-\\s\\']+[a-zA-Z0-9.!)\\'\\s]$";

    /** The Constant DESCRIPTION_REGEX. */
    public static final String DESCRIPTION_REGEX =
	    "^(?=.*[a-zA-Z])[a-zA-Z0-9\\s!.\\[\\]"
		    + "@&#%+=;:?\\/,\\-\\'$%^\\*()<>№]+$";

    /** The Constant URL_REGEX. */
    public static final String URL_REGEX = "^(https?:\\/\\/)?([\\da-z\\.-]+)"
	    + "\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?$";

    /** The Constant PHONE_NUMBER_REGEX. */
    public static final String PHONE_NUMBER_REGEX =
	    "^(?:\\+38)?(?:0\\d\\d)\\d{7}$";

    /** The Constant MAX_LENGTH_NAME. */
    public static final int MAX_LENGTH_NAME = 100;

    /** The Constant MIN_LENGTH_NAME. */
    public static final int MIN_LENGTH_NAME = 3;

    /** The Constant MAX_LENGTH_DESCRIPTION. */
    public static final int MAX_LENGTH_DESCRIPTION = 400;

    /** The Constant MIN_LENGTH_DESCRIPTION. */
    public static final int MIN_LENGTH_DESCRIPTION = 4;

    /** The id. */
    private Long id;

    /** The name. */
    @NotNull
    @Size(min = MIN_LENGTH_NAME, max = MAX_LENGTH_NAME)
    @Pattern(regexp = NAME_REGEX, message = "Invalid name")
    private String name;

    /** The description. */
    @NotNull
    @Size(min = MIN_LENGTH_DESCRIPTION, max = MAX_LENGTH_DESCRIPTION)
    @Pattern(regexp = DESCRIPTION_REGEX, message = "Invalid description")
    private String description;

    /** The site. */
    @URL
    private String site;

    /** The phone number. */
    @NotNull
    @Pattern(regexp = PHONE_NUMBER_REGEX, message = "Invalid phone number")
    private String phone;

    /** The address of the office. */
    @NotNull
    @Valid
    private AddressDTO address;

    /** The default constructor. */
    public RealEstateAgencyDTO() {

    }

    /**
     * Instantiates a new real estate agency dto.
     *
     * @param newName
     *            the new name
     * @param newDescription
     *            the new description
     * @param newPhone
     *            the new phone
     * @param newSite
     *            the new site
     * @param newAddress
     *            the new address
     */
    public RealEstateAgencyDTO(final String newName,
	    final String newDescription, final String newPhone,
	    final String newSite, final AddressDTO newAddress) {
	super();
	this.name = newName;
	this.description = newDescription;
	this.phone = newPhone;
	this.site = newSite;
	this.address = newAddress;
    }

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
     * Gets the name.
     *
     * @return the name
     */
    public final String getName() {
	return name;
    }

    /**
     * Sets the name.
     *
     * @param newName
     *            the new name
     */
    public final void setName(final String newName) {
	this.name = newName;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public final String getDescription() {
	return description;
    }

    /**
     * Sets the description.
     *
     * @param newDescription
     *            the new description
     */
    public final void setDescription(final String newDescription) {
	this.description = newDescription;
    }

    /**
     * Gets the site.
     *
     * @return the site
     */
    public final String getSite() {
	return site;
    }

    /**
     * Sets the site.
     *
     * @param newSite
     *            the new site
     */
    public final void setSite(final String newSite) {
	this.site = newSite;
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
     *            the new phone
     */
    public final void setPhone(final String newPhone) {
	this.phone = newPhone;
    }

    /**
     * Gets the address.
     *
     * @return the address
     */
    public final AddressDTO getAddress() {
	return address;
    }

    /**
     * Sets the address.
     *
     * @param newAddress
     *            the new address
     */
    public final void setAddress(final AddressDTO newAddress) {
	this.address = newAddress;
    }

}
