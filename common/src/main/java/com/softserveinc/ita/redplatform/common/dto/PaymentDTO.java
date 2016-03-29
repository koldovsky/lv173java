package com.softserveinc.ita.redplatform.common.dto;

import java.util.Date;

import com.softserveinc.ita.redplatform.common.entity.Order;

/**
 * The class PaymentDTO.
 * 
 * @author Bulhakov Alex
 */
public class PaymentDTO {

    /** The amount. */
    private double amount;
    
    /** The order. */
    private Order order;
    
    /** The currency rate. */
    private CurrencyRateDTO currencyRateDTO;
    
    /** Path or an URI of picture that has been attached.  */
    private String picturePath;
    
    /** Date created.  */
    private Date createdDate;
    
    /** The date. */
    private long date;

    /**
     * Gets the date.
     *
     * @return the date
     */
    public final long getDate() {
        return date;
    }

    /**
     * Sets the date.
     *
     * @param newDate the new date
     */
    public final void setDate(final long newDate) {
        date = newDate;
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

    public final CurrencyRateDTO getCurrencyRate() {
        return currencyRateDTO;
    }


    public final void setCurrencyRate(final CurrencyRateDTO newCurrencyRate) {
        this.currencyRateDTO = newCurrencyRate;
    }


    public final String getPicturePath() {
        return picturePath;
    }


    public final void setPicturePath(final String newPicturePath) {
        this.picturePath = newPicturePath;
    }


    public final Date getCreatedDate() {
        return createdDate;
    }


    public final void setCreatedDate(final Date newCreatedDate) {
        this.createdDate = newCreatedDate;
    }


    public final Order getOrder() {
        return order;
    }
    
	public final double getAmoutAccordingToRate() {
		return amount * currencyRateDTO.getAmount();
	}

    public final void setOrder(final Order newOrder) {
        this.order = newOrder;
    }
}
