package com.softserveinc.ita.redplatform.common.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "customerId")
	private CustomerUser customerUser;

	@OneToOne(mappedBy = "order")
	private Installment installment;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	List<Payment> payments = new ArrayList<>();

	public CustomerUser getCustomerUser() {
		return customerUser;
	}

	public void setCustomerUser(CustomerUser customerUser) {
		this.customerUser = customerUser;
	}

	public Installment getInstallment() {
		return installment;
	}

	public void setInstallment(Installment installment) {
		this.installment = installment;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public void addPayment(Payment payment) {
		payment.setOrder(this);
		this.payments.add(payment);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((customerUser == null) ? 0 : customerUser.hashCode());
		result = prime * result + ((installment == null) ? 0 : installment.hashCode());
		result = prime * result + ((payments == null) ? 0 : payments.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Order other = (Order) obj;
		if (customerUser == null) {
			if (other.customerUser != null) {
				return false;
			}
		} else if (!customerUser.equals(other.customerUser)) {
			return false;
		}
		if (installment == null) {
			if (other.installment != null) {
				return false;
			}
		} else if (!installment.equals(other.installment)) {
			return false;
		}
		if (payments == null) {
			if (other.payments != null) {
				return false;
			}
		} else if (!payments.equals(other.payments)) {
			return false;
		}
		return true;
	}

}
