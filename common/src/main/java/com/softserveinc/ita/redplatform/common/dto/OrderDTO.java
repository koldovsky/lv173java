package com.softserveinc.ita.redplatform.common.dto;

import java.util.Date;
import java.util.List;

/**
 * DTO for Order.
 * 
 * @author Bulhakov Alex
 *
 */
public class OrderDTO {
    /**
     * Customer ID of Order.
     */
    private CustomerUserDTO customer;

    /**
     * Order ID.
     */
    private Long id;

    /**
     * Description.
     */
    private String description;

    /**
     * Area in square meters.
     */
    private double area;

    /**
     * Number of rooms.
     */
    private int roomsQuantity;

    /** The address of the real estate. */
    private AddressDTO address;

    /**
     * List of installments.
     */
    private List<InstallmentDTO> installment;
    
    /**
     * Created date.
     */
    private Date createdDate; 

    public final Long getId() {
	return id;
    }

    public final void setId(final Long newId) {
	this.id = newId;
    }

    public final String getDescription() {
	return description;
    }

    public final void setDescription(final String newDescription) {
	this.description = newDescription;
    }

    public final double getArea() {
	return area;
    }

    public final void setArea(final double newArea) {
	this.area = newArea;
    }

    public final int getRoomsQuantity() {
	return roomsQuantity;
    }

    public final void setRoomsQuantity(final int newRoomsQuantity) {
	this.roomsQuantity = newRoomsQuantity;
    }

    public final AddressDTO getAddress() {
	return address;
    }

    public final void setAddress(final AddressDTO newAddress) {
	this.address = newAddress;
    }

    public final CustomerUserDTO getCustomer() {
	return customer;
    }

    public final void setCustomer(final CustomerUserDTO newCustomer) {
	this.customer = newCustomer;
    }

    public final List<InstallmentDTO> getInstallment() {
	return installment;
    }

    public final void
	    setInstallment(final List<InstallmentDTO> newInstallment) {
	this.installment = newInstallment;
    }

    public final Date getCreatedDate() {
        return createdDate;
    }

    public final void setCreatedDate(final Date newCreatedDate) {
        this.createdDate = newCreatedDate;
    }

}
