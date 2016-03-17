package com.softserveinc.ita.redplatform.business.statistics;

/**
 * Payment Statistic.
 * 
 * @author Hryhorii
 *
 */
public class PaymentsStatistics {

	/**
	 * Percentage.
	 */
	private static final int PERCENTAGE = 100;
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

	/**
	 * Method count the amount left to pay.
	 */
	private void countLeftPayAmount() {
		leftPayAmount = apartmentPrice - totalPaidAmount;
	}
	
	public final double getProgress() {
		return totalPaidAmount / apartmentPrice * PERCENTAGE;
	}

}
