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

}
