package com.softserveinc.ita.redplatform.business.statistics;

import com.softserveinc.ita.redplatform.common.dto.InstallmentDTO;

/**
 * Payment Statistic.
 * 
 * @author Hryhorii Somyk
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

	/**
	 * Next installment.
	 */
	private InstallmentDTO nextInstallment;

	/**
	 * Missed installment.
	 */
	private InstallmentDTO missedInstallment;

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

	public final InstallmentDTO getNextInstallment() {
		return nextInstallment;
	}

	public final void
			setNextInstallment(final InstallmentDTO newNextInstallment) {
		this.nextInstallment = newNextInstallment;
	}

	public final InstallmentDTO getMissedInstallment() {
		return missedInstallment;
	}

	public final void
			setMissedInstallment(final InstallmentDTO newMissedInstallment) {
		this.missedInstallment = newMissedInstallment;
	}

}
