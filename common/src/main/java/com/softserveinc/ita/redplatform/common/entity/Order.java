package com.softserveinc.ita.redplatform.common.entity;

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
     * ID for serialization.
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
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Installment> installments;

    /**
     * List of payments.
     */
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Payment> payments;

    /**
     * Description of an order.
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
    
    
    /** The address of the real estate. */
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

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
     * @param newCustomerUser
     *            to set
     */
    public final void setCustomerUser(final CustomerUser newCustomerUser) {
	this.customerUser = newCustomerUser;
    }

    /**
     * Get Installment.
     * 
     * @return installment
     */
    public final List<Installment> getInstallment() {
	return installments;
    }

    /**
     * Set Installments value.
     * 
     * @param newInstallments
     *            to set
     */
    public final void setInstallment(final List<Installment> newInstallments) {
	this.installments = newInstallments;
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
     * @param newPayments
     *            to set
     */
    public final void setPayments(final List<Payment> newPayments) {
	this.payments = newPayments;
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

    public final Address getAddress() {
        return address;
    }

    public final void setAddress(final Address newAddress) {
        this.address = newAddress;
    }

}
