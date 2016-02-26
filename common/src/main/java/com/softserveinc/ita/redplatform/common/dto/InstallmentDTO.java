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
