package com.softserveinc.ita.redplatform.common.dto;

import java.util.Date;


/**
 * Data Transfer Object for CurrencyRate class.
 * 
 * @author Ivaniv Roman
 *
 */
public class CurrencyRateDTO {
    
    /**
     * id.
     */
    private Long id;
   
    /**
     * Created date.
     */
    private Date createdDate;
    
    /**
     * Column for amount.
     */
    private double amount;
    
    /**
     * Column for date since the currency rate is set.
     */
    private Date fromDate;

    /**
     * Column for date until the currency rate is set.
     */
    private Date toDate;

    public final Long getId() {
        return id;
    }

    public final void setId(final Long newId) {
        this.id = newId;
    }

    public final Date getCreatedDate() {
        return createdDate;
    }

    public final void setCreatedDate(final Date newCreatedDate) {
        this.createdDate = newCreatedDate;
    }

    public final double getAmount() {
        return amount;
    }

    public final void setAmount(final double newAmount) {
        this.amount = newAmount;
    }

    public final Date getFromDate() {
        return fromDate;
    }

    public final void setFromDate(final Date newFromDate) {
        this.fromDate = newFromDate;
    }

    public final Date getToDate() {
        return toDate;
    }

    public final void setToDate(final Date newToDate) {
        this.toDate = newToDate;
    }
    
}
