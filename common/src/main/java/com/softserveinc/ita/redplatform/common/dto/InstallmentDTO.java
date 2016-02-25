package com.softserveinc.ita.redplatform.common.dto;

/**
 * The class InstallmentDTO.
 * 
 * @author Ilona Yavorska
 */
public class InstallmentDTO {

    /** The amount. */
    private double amount;


    /** The date. */
    private String date;
    
    /** The customer id. */
    private Long customerId;

    /**
     * Gets the customer id.
     *
     * @return the customer id
     */
    public final Long getCustomerId() {
        return customerId;
    }


    /**
     * Sets the customer id.
     *
     * @param newCustomerId the new customer id
     */
    public final void setCustomerId(final Long newCustomerId) {
        customerId = newCustomerId;
    }


    /**
     * Gets the amount.
     *
     * @return the amount
     */
    public final double getAmount() {
        return amount;
    }


    /**
     * Sets the amount.
     *
     * @param newAmount the new amount
     */
    public final void setAmount(final double newAmount) {
        amount = newAmount;
    }


    /**
     * Gets the date.
     *
     * @return the date
     */
    public final String getDate() {
        return date;
    }


    /**
     * Sets the date.
     *
     * @param newDate the new date
     */
    public final void setDate(final String newDate) {
        date = newDate;
    }
}
