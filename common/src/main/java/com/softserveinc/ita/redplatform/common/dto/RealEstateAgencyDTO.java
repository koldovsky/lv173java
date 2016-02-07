package com.softserveinc.ita.redplatform.common.dto;



/**
 * Data Transfer Object for RealEstateAgency class.
 * @author Oleh Khimka
 *
 */
public class RealEstateAgencyDTO {

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
	
	public final String getName() {
	    return name;
	}

	public final void setName(final String newName) {
	    this.name = newName;
	}

	public final String getDescription() {
	    return description;
	}

	public final void setDescription(final String newDescription) {
	    this.description = newDescription;
	}

	public final String getSite() {
	    return site;
	}

	public final void setSite(final String newSite) {
	    this.site = newSite;
	}

	public final String getPhone() {
	    return phone;
	}

	public final void setPhone(final String newPhone) {
	    this.phone = newPhone;
	}

	public final AddressDTO getAddress() {
	    return address;
	}

	public final void setAddress(final AddressDTO newAddress) {
	    this.address = newAddress;
	}
	
	
}
