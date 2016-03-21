package com.softserveinc.ita.redplatform.business.statistics;

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
	 * Progress.
	 */
	private double progress;

	public final double getTotalPaidAmount() {
		return totalPaidAmount;
	}

	public final void setTotalPaidAmount(final double newTotalPaidAmount) {
		this.totalPaidAmount = newTotalPaidAmount;
	}

	public final double getApartmentPrice() {
		return apartmentPrice;
	}

	public final void setApartmentPrice(final double newApartmentPrice) {
		this.apartmentPrice = newApartmentPrice;
	}

	public final double getLeftPayAmount() {
		return leftPayAmount;
	}

	public final void setLeftPayAmount(final double newLeftPayAmount) {
		this.leftPayAmount = newLeftPayAmount;
	}

	public final double getProgress() {
		return progress;
	}

	public final void setProgress(final double newProgress) {
		this.progress = newProgress;
	}

}
