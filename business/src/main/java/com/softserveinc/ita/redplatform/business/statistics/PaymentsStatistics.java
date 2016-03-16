package com.softserveinc.ita.redplatform.business.statistics;

import java.util.List;

import com.softserveinc.ita.redplatform.common.dto.PaymentDTO;

/**
 * Payment Statistic.
 * 
 * @author Hryhorii
 *
 */
public class PaymentsStatistics {

	/**
	 * Total paid amount.
	 */
	private double totalPaidAmount;

	/**
	 * Total Apartment price.
	 */
	private double apartmentPrice;

	/**
	 * Left to pay amount.
	 */
	private double leftPayAmount;

	/**
	 * List of payments.
	 */
	private List<PaymentDTO> payments;

	public final double getTotalPaidAmount() {
		return totalPaidAmount;
	}

	/**
	 * Method set new total paid amount and count amount left to pay.
	 * 
	 * @param newTotalPaidAmount
	 *            total paid amount
	 */
	public final void setTotalPaidAmount(final double newTotalPaidAmount) {
		this.totalPaidAmount = newTotalPaidAmount;
		countLeftPayAmount();
	}

	public final double getApartmentPrice() {
		return apartmentPrice;
	}

	/**
	 * Method set new apartment price and count amount left to pay.
	 * 
	 * @param newApartmentPrice
	 *            apartment price
	 */
	public final void setApartmentPrice(final double newApartmentPrice) {
		this.apartmentPrice = newApartmentPrice;
		countLeftPayAmount();
	}

	public final double getLeftPayAmount() {
		return leftPayAmount;
	}

	public final List<PaymentDTO> getPayments() {
		return payments;
	}

	public final void setPayments(final List<PaymentDTO> newPayments) {
		this.payments = newPayments;
	}

	/**
	 * Method count the amount left to pay.
	 */
	private void countLeftPayAmount() {
		leftPayAmount = apartmentPrice - totalPaidAmount;
	}

}
