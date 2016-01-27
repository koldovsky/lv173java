package com.softserveinc.ita.redplatform.common.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Payments")
public class Payment extends BaseEntity {


	@Column(name = "amount")
	private BigDecimal amount;
	
	@OneToOne
	@JoinColumn(name="currencyRate")
	private CurrencyRate currencyRate;
	
	@Enumerated(EnumType.STRING)
	private State state;
	
	@ManyToOne	
	@JoinColumn(name="ordereId")
	private Order order;


	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public CurrencyRate getCurrencyRate() {
		return currencyRate;
	}

	public void setCurrencyRate(CurrencyRate currencyRate) {
		this.currencyRate = currencyRate;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((currencyRate == null) ? 0 : currencyRate.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (currencyRate == null) {
			if (other.currencyRate != null)
				return false;
		} else if (!currencyRate.equals(other.currencyRate))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (state != other.state)
			return false;
		return true;
	}
	
	
	
}

