package com.softserveinc.ita.redplatform.common.entity;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Class that represents installment for the order.
 *
 * @author Oleh Khimka
 */
@Entity
@Table(name = "Installments")
public class Installment extends BaseEntity {

    /**
    * Id for serialization.
    */
    private static final long serialVersionUID = -5028225244571023001L;

    /**
     * Column for amount.
     */
    @Column(name = "amount")
    private double amount;

    /**
     * Column for date.
     */
    @Column(name = "date")
    private Date date;

    /**
     * Column for order.
     */
    @ManyToOne
    private Order order;

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
     * Get value of column Date.
     *
     * @return the Date
     */
    public final Date getDate() {
      return date;
    }

    /**
     * Changes date to new date.
     *
     * @param newDate date to be set
     */
    public final void setDate(final Date newDate) {
      this.date = newDate;
    }

    /**
     * Get value of column order.
     *
     * @return the order
     */
    public final Order getOrder() {
      return order;
    }

    /**
     * Changes order to new order.
     *
     * @param newOrder order to be set
     */
    public final void setOrder(final Order newOrder) {
      this.order = newOrder;
    }

}
