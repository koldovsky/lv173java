package com.softserveinc.ita.redplatform.common.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Class that represents the Order.
 * 
 * @author Hryhorii Somyk
 */
@Entity
@Table(name = "Orders")
public class Order extends BaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 4135117256506949773L;

    /**
     * Column for customerId.
     */
    @ManyToOne
    @JoinColumn(name = "customerId")
    private CustomerUser customerUser;

    /**
     * Column for installment.
     */
    @OneToOne(mappedBy = "order")
    private Installment installment;

    /**
     * List of payments.
     */
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Payment> payments = new ArrayList<>();

    /**
     * Get customerUser.
     * 
     * @return customerUser
     */
    public final CustomerUser getCustomerUser() {
	return customerUser;
    }

    /**
     * Set CustomerUser.
     * 
     * @param newCustomerUser to set
     */
    public final void setCustomerUser(final CustomerUser newCustomerUser) {
	this.customerUser = newCustomerUser;
    }

    /**
     * Get Installment.
     * 
     * @return installment
     */
    public final Installment getInstallment() {
	return installment;
    }

    /**
     * Set Installment value.
     * 
     * @param newInstallment to set
     */
    public final void setInstallment(final Installment newInstallment) {
	this.installment = newInstallment;
    }

    /**
     * Get list of payments.
     * 
     * @return payments
     */
    public final List<Payment> getPayments() {
	return payments;
    }

    /**
     * Set list of payments.
     * 
     * @param newPayments to set
     */
    public final void setPayments(final List<Payment> newPayments) {
	this.payments = newPayments;
    }

}
