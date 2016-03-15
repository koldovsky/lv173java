package com.softserveinc.ita.redplatform.business.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.redplatform.common.dto.PaymentDTO;
import com.softserveinc.ita.redplatform.common.entity.Payment;
import com.softserveinc.ita.redplatform.common.mapper.PaymentMapper;
import com.softserveinc.ita.redplatform.persistence.dao.PaymentDao;

/**
 * Payment Service.
 * 
 * @author Hryhorii
 * 
 */
@Service
public class PaymentService {

	/**
	 * Payment dao.
	 */
	@Autowired
	private PaymentDao paymentDao;

	/**
	 * Payment mapper.
	 */
	@Autowired
	private PaymentMapper mapper;

	/**
	 * Method returns payments list by order id.
	 * 
	 * @param id
	 *            order id
	 * @return list of payments
	 */
	public List<PaymentDTO> getPayments(final Long id) {
		List<PaymentDTO> payments = new LinkedList<>();
		for (Payment payment : paymentDao.getPaymentsByOrderId(id)) {
			payments.add(mapper.toDto(payment));
		}
		return payments;
	}
	
	/**
	 * Gets the total paid amount.
	 *
	 * @param payments the payments
	 * @return the total paid amount
	 */
	public double getTotalPaidAmount(final List<Payment> payments) {
	    	double total = 0;
	    	for (Payment payment : payments) {
	    	    total += payment.getAmount();
	    	}
	    	return total;
	}

}
