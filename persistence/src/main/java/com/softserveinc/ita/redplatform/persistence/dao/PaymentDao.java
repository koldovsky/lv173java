package com.softserveinc.ita.redplatform.persistence.dao;

import java.util.List;

import com.softserveinc.ita.redplatform.common.entity.Payment;

/**
 * Payment dao interface.
 * 
 * @author Hryhorii Somyk
 *
 */
public interface PaymentDao extends GenericDao<Payment, Long> {

	/**
	 * Method return all payments by order id.
	 * 
	 * @param id
	 *            order id
	 * @return list of payments
	 */
	List<Payment> getPaymentsByOrderId(Long id);

}
