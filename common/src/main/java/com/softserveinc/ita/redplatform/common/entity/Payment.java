package com.softserveinc.ita.redplatform.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Class that represents Payment.
 * 
 * @author Hryhorii Somyk
 */
@Entity
@Table(name = "Payments")
public class Payment extends BaseEntity {

    /**
     * Id for serialization.
     */
    private static final long serialVersionUID = -3035724760433561273L;

    /**
     * Column for amount.
     */
    @Column(name = "amount")
    private double amount;

    /**
     * Column for currencyRate.
     */
    @OneToOne
    @JoinColumn(name = "currencyRate")
    private CurrencyRate currencyRate;

    /**
     * Column for state.
     */
    @Enumerated(EnumType.STRING)
    private State state;

    /**
     * Column for orderId.
     */
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    /**
     * Get amount.
     * 
     * @return amount
     */
    public final double getAmount() {
	return amount;
    }

    /**
     * Set amount.
     * 
     * @param newAmount to set
     */
    public final void setAmount(final double newAmount) {
	this.amount = newAmount;
    }

    /**
     * Get currencyRate.
     * 
     * @return currencyRate
     */
    public final CurrencyRate getCurrencyRate() {
	return currencyRate;
    }

    /**
     * Set currencyRate.
     * 
     * @param newCurrencyRate to set
     */
    public final void setCurrencyRate(final CurrencyRate newCurrencyRate) {
	this.currencyRate = newCurrencyRate;
    }
    
    /**
     * Get state.
     * 
     * @return state
     */
    public final State getState() {
	return state;
    }
    
    /**
     * Set state.
     * 
     * @param newState to set
     */
    public final void setState(final State newState) {
	this.state = newState;
    }

    /**
     * Get order.
     * 
     * @return order
     */
    public final Order getOrder() {
	return order;
    }

    /**
     * Set order.
     * 
     * @param newOrder to set
     */
    public final void setOrder(final Order newOrder) {
	this.order = newOrder;
    }

}