package com.softserveinc.ita.redplatform.common.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Class that represents Currency Rate.
 *
 * @author Oleh Khimka
 */
@Entity
@Table(name = "CurrencyRates")
public class CurrencyRate extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = -1119782516427107943L;

    /**
     * Column for amount.
     */
    @Column(name = "amount")
    private double amount;

    /**
     * Column for date since the currency rate is set.
     */
    @Column(name = "fromDate")
    private Date fromDate;

    /**
     * Column for date until the currency rate is set.
     */
    @Column(name = "toDate")
    private Date toDate;

    /**
     * Column for real estate dev agency that have set given currency rates.
     */
    @ManyToOne
    @JoinColumn(name = "reAgencyId")
    private RealEstateAgency reAgency;

    /**
     * Get value of column amount.
     *
     * @return the amount
     */
    public final double getAmount() {
       return amount;
    }

    /**
     * Changes amount value to new amount.
     *
     * @param newAmount amount to be set
     */
    public final void setAmount(final double newAmount) {
      this.amount = newAmount;
    }

    /**
     * Get value of column fromDate.
     *
     * @return the date since currency rate is set
     */
    public final Date getFromDate() {
      return fromDate;
    }

    /**
     * Changes fromDate value.
     *
     * @param newFromDate  Date since currency rate is set
     */
    public final void setFromDate(final Date newFromDate) {
      this.fromDate = newFromDate;
    }

    /**
     * Get value of column toDate.
     *
     * @return the date until currency rate is set
     */
    public final Date getToDate() {
      return toDate;
    }

    /**
     * Changes toDate value.
     *
     * @param newToDate  Date until currency rate is set
     */
    public final void setToDate(final Date newToDate) {
      this.toDate = newToDate;
    }

    /**
     * Get Column for real estate dev agency.
     *
     * @return real estate dev agency
     */
    public final RealEstateAgency getReAgency() {
      return reAgency;
    }

    /**
     * Changes real estate dev agency.
     * 
     * @param newReAgency  new real estate dev agency
     */
    public final void setReAgency(final RealEstateAgency newReAgency) {
      this.reAgency = newReAgency;
    }

}
