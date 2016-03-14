package com.softserveinc.ita.redplatform.common.dto;

import java.util.Date;

import com.softserveinc.ita.redplatform.common.entity.State;

/**
 * Payment DTO.
 * 
 * @author Hryhorii
 *
 */
public class PaymentDTO {
	/**
	 * Amount.
	 */
	private double amount;
	
	/**
	 * State.
	 */
	private State state;
	
	/**
	 * Created date.
	 */
	private Date createdDate;

	public final double getAmount() {
		return amount;
	}

	public final void setAmount(final double newAmount) {
		this.amount = newAmount;
	}

	public final State getState() {
		return state;
	}

	public final void setState(final State newState) {
		this.state = newState;
	}

	public final Date getCreatedDate() {
		return createdDate;
	}

	public final void setCreatedDate(final Date newCreatedDate) {
		this.createdDate = newCreatedDate;
	}

}
