package com.softserveinc.ita.redplatform.persistence.dao;

import com.softserveinc.ita.redplatform.common.entity.Payment;

/**
 * Payment dao interface.
 * 
 * @author Hryhorii Somyk
 *
 */
public interface PaymentDao extends GenericDao<Payment, Long> {

	/**
	 * Gets the paid amount.
	 *
	 * @param newOrderId the order id
	 * @return the paid amount
	 */
	double getPaidAmount(Long newOrderId);

}
