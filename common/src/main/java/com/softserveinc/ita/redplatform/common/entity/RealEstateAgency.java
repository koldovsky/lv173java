package com.softserveinc.ita.redplatform.common.entity;

import java.net.URL;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;

/**
 * The Class RealEstateAgency.
 * 
 * @author Ilona Yavorska
 */
@Entity
public class RealEstateAgency extends BaseEntity {
	
	/** The name. */
	private String name;
	
	/** The description. */
	private String description;
	
	/** The site. */
	private URL site;
	
	/** The phone number. */
	private String phone;
	
	/** The address of the office. */
	private Address address;
	
	/** The main office. */
	private RealEstateAgency mainOffice;
	
	/** The branches. */
	private Set<RealEstateAgency> branches;
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	@Column(nullable = false)
	public final String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param newName the new name
	 */
	public final void setName(final String newName) {
		name = newName;
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
		description = newDescription;
	}
	
	/**
	 * Gets the site.
	 *
	 * @return the site
	 */
	public final URL getSite() {
		return site;
	}
	
	/**
	 * Sets the site.
	 *
	 * @param newSite the new site
	 */
	public final void setSite(final URL newSite) {
		site = newSite;
	}
	
	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	@JoinColumn(nullable = false)
	public final String getPhone() {
		return phone;
	}
	
	/**
	 * Sets the phone.
	 *
	 * @param newPhone the new phone
	 */
	public final void setPhone(final String newPhone) {
		phone = newPhone;
	}
	
	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	public final Address getAddress() {
		return address;
	}
	
	/**
	 * Sets the address.
	 *
	 * @param newAddress the new address
	 */
	public final void setAddress(final Address newAddress) {
		address = newAddress;
	}
	
	/**
	 * Gets the main office.
	 *
	 * @return the main office
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "main_office")
	public final RealEstateAgency getMainOffice() {
		return mainOffice;
	}
	
	/**
	 * Sets the main office.
	 *
	 * @param newMainOffice the new main office
	 */
	public final void setMainOffice(final RealEstateAgency newMainOffice) {
		mainOffice = newMainOffice;
	}
	
	/**
	 * Gets the branches.
	 *
	 * @return the branches
	 */
	@OneToMany(mappedBy = "main_office")
	public final Set<RealEstateAgency> getBranches() {
		return branches;
	}
	
	/**
	 * Sets the branches.
	 *
	 * @param newBranches the new branches
	 */
	public final void setBranches(final Set<RealEstateAgency> newBranches) {
		branches = newBranches;
	}
	
}
