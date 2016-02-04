package com.softserveinc.ita.redplatform.common.dto;


/**
 * Data Transfer Object for Address class.
 * @author Oleh Khimka
 *
 */
public class AddressDTO {
	/** The country. */
	private String country;
	
	/** The region. */
	private String region;
	
	/** The postal code. */
	private String postalCode;
	
	/** The locality. */
	private String locality;
	
	/** The additional info. */
	private String additional;

	public final String getCountry() {
	    return country;
	}

	public final void setCountry(final String newCountry) {
	    this.country = newCountry;
	}

	public final String getRegion() {
	    return region;
	}

	public final void setRegion(final String newRegion) {
	    this.region = newRegion;
	}

	public final String getPostalCode() {
	    return postalCode;
	}

	public final void setPostalCode(final String newPostalCode) {
	    this.postalCode = newPostalCode;
	}

	public final String getLocality() {
	    return locality;
	}

	public final void setLocality(final String newLocality) {
	    this.locality = newLocality;
	}

	public final String getAdditional() {
	    return additional;
	}

	public final void setAdditional(final String newAdditional) {
	    this.additional = newAdditional;
	}
	
	
}