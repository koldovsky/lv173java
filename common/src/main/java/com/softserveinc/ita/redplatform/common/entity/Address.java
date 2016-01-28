package com.softserveinc.ita.redplatform.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * The Class Address.
 * 
 * @author Ilona Yavorska
 */
@Entity
public class Address extends BaseEntity {
	
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
	
	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	@Column(nullable = false)
	public final String getCountry() {
		return country;
	}
	
	/**
	 * Sets the country.
	 *
	 * @param newCountry the new country
	 */
	public final void setCountry(final String newCountry) {
		country = newCountry;
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
	 * @param newRegion the new region
	 */
	public final void setRegion(final String newRegion) {
		region = newRegion;
	}

	/**
	 * Gets the postal code.
	 *
	 * @return the postal code
	 */
	@Column(name = "postal_code", nullable = false)
	public final String getPostalCode() {
		return postalCode;
	}
	
	/**
	 * Sets the postal code.
	 *
	 * @param newPostalCode the new postal code
	 */
	public final void setPostalCode(final String newPostalCode) {
		postalCode = newPostalCode;
	}
	
	/**
	 * Gets the locality.
	 *
	 * @return the locality
	 */
	@Column(nullable = false)
	public final String getLocality() {
		return locality;
	}
	
	/**
	 * Sets the locality.
	 *
	 * @param newLocality the new locality
	 */
	public final void setLocality(final String newLocality) {
		locality = newLocality;
	}
	
	/**
	 * Gets the additional info.
	 *
	 * @return the additional
	 */
	@Column(nullable = false)
	public final String getAdditional() {
		return additional;
	}
	
	/**
	 * Sets the additional info.
	 *
	 * @param newAdditional the new additional
	 */
	public final void setAdditional(final String newAdditional) {
		additional = newAdditional;
	}
}
