package com.softserveinc.ita.redplatform.business.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.redplatform.common.dto.PaymentDTO;
import com.softserveinc.ita.redplatform.common.entity.Order;
import com.softserveinc.ita.redplatform.common.entity.Payment;
import com.softserveinc.ita.redplatform.common.mapper.PaymentMapper;

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
	private OrderService orderService;

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
	@Transactional
	public List<PaymentDTO> getPayments(final Long id) {
		List<PaymentDTO> payments = new LinkedList<>();
		Order order = orderService.getOrderById(id);
		for (Payment payment : order.getPayments()) {
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
