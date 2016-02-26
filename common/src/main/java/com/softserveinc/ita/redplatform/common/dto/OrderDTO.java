package com.softserveinc.ita.redplatform.common.dto;

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
    private Long customerId;

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

    public final Long getCustomerId() {
	return customerId;
    }

    public final void setCustomerId(final Long newCustomerId) {
	this.customerId = newCustomerId;
    }

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

}
