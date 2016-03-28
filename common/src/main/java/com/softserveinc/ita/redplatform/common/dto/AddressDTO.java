package com.softserveinc.ita.redplatform.common.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Data Transfer Object for Address class.
 * 
 * @author Oleh Khimka
 *
 */
public class AddressDTO {

    /** The Constant COUNTRY_REGEX. */
    public static final String COUNTRY_REGEX =
	    "^$|^(?=.*[a-zA-Z])[a-zA-Z.\\-,\\' ]+$";

    /** The Constant POSTAL_REGEX. */
    public static final String POSTAL_REGEX =
	    "^$|^(?=.*[0-9])[a-zA-Z0-9]{3,10}$";

    /** The Constant REGION_REGEX. */
    public static final String REGION_REGEX = "^$|[a-zA-Z.\\-,\\'\\s]+$";

    /** The Constant ADDITIONAL_REGEX. */
    public static final String ADDITIONAL_REGEX =
	    "^$|(^(?=.*[a-zA-Z])[a-zA-Z0-9.:\\-',\\s\\[\\]\\/]+$)";

    /** The Constant MAX_LENGTH. */
    public static final int MAX_LENGTH = 30;

    /** The Constant MIN_LENGTH. */
    public static final int MIN_LENGTH = 2;

    /** The Constant MAX_LENGTH_POSTAL_CODE. */
    public static final int MAX_LENGTH_POSTAL_CODE = 10;

    /** The Constant MIN_LENGTH_POSTAL_CODE. */
    public static final int MIN_LENGTH_POSTAL_CODE = 3;

    /** The id. */
    private Long id;

    /** The country. */
    @NotNull
    @Size(min = MIN_LENGTH, max = MAX_LENGTH)
    @Pattern(regexp = COUNTRY_REGEX)
    private String country;

    /** The region. */
    @Size(max = MAX_LENGTH)
    @Pattern(regexp = REGION_REGEX)
    private String region;

    /** The postal code. */
    @NotNull
    @Size(min = MIN_LENGTH_POSTAL_CODE, max = MAX_LENGTH_POSTAL_CODE)
    @Pattern(regexp = POSTAL_REGEX)
    private String postalCode;

    /** The locality. */
    @NotNull
    @Size(min = MIN_LENGTH, max = MAX_LENGTH)
    @Pattern(regexp = COUNTRY_REGEX)
    private String locality;

    /** The additional info. */
    @NotNull
    @Size(min = MIN_LENGTH, max = MAX_LENGTH)
    @Pattern(regexp = ADDITIONAL_REGEX)
    private String additional;

    /** default constructor. */
    public AddressDTO() {

    }

    /**
     * Instantiates a new address dto.
     *
     * @param newCountry
     *            the new country
     * @param newRegion
     *            the new region
     * @param newPostalCode
     *            the new postal code
     * @param newLocality
     *            the new locality
     * @param newAdditional
     *            the new additional
     */
    public AddressDTO(final String newCountry, final String newRegion,
	    final String newPostalCode, final String newLocality,
	    final String newAdditional) {
	super();
	this.postalCode = newPostalCode;
	this.country = newCountry;
	this.locality = newLocality;
	this.region = newRegion;
	this.additional = newAdditional;
    }

    /**
     * Gets the country.
     *
     * @return the country
     */
    public final String getCountry() {
	return country;
    }

    /**
     * Sets the country.
     *
     * @param newCountry
     *            the new country
     */
    public final void setCountry(final String newCountry) {
	this.country = newCountry;
    }

    /**
     * Gets the region.
     *
     * @return the region
     */
    public final String getRegion() {
	return region;
    }

    /**
     * Sets the region.
     *
     * @param newRegion
     *            the new region
     */
    public final void setRegion(final String newRegion) {
	this.region = newRegion;
    }

    /**
     * Gets the postal code.
     *
     * @return the postal code
     */
    public final String getPostalCode() {
	return postalCode;
    }

    /**
     * Sets the postal code.
     *
     * @param newPostalCode
     *            the new postal code
     */
    public final void setPostalCode(final String newPostalCode) {
	this.postalCode = newPostalCode;
    }

    /**
     * Gets the locality.
     *
     * @return the locality
     */
    public final String getLocality() {
	return locality;
    }

    /**
     * Sets the locality.
     *
     * @param newLocality
     *            the new locality
     */
    public final void setLocality(final String newLocality) {
	this.locality = newLocality;
    }

    /**
     * Gets the additional.
     *
     * @return the additional
     */
    public final String getAdditional() {
	return additional;
    }

    /**
     * Sets the additional.
     *
     * @param newAdditional
     *            the new additional
     */
    public final void setAdditional(final String newAdditional) {
	this.additional = newAdditional;
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
	this.id = newId;
    }

}
