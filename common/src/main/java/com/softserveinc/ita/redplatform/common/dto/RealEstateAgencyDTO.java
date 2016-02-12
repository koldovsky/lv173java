package com.softserveinc.ita.redplatform.common.dto;

/**
 * Data Transfer Object for RealEstateAgency class.
 * @author Oleh Khimka
 *
 */
public class RealEstateAgencyDTO {
	
	/** The id. */
	private Long id;

	/** The name. */
	private String name;
	
	/** The description. */
	private String description;
	
	/** The site. */
	private String site;
	
	/** The phone number. */
	private String phone;
	
	/** The address of the office. */
	private AddressDTO address;

	/** The default constructor. */
	public RealEstateAgencyDTO() {
	    
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
	 * @param newId the new id
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
	 * @param newName the new name
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
	 * @param newDescription the new description
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
	 * @param newSite the new site
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
	 * @param newPhone the new phone
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
	 * @param newAddress the new address
	 */
	public final void setAddress(final AddressDTO newAddress) {
	    this.address = newAddress;
	}
	
	
}
