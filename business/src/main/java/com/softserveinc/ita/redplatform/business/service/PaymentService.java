package com.softserveinc.ita.redplatform.business.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.redplatform.business.statistics.PaymentsStatistics;
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
	 * Installment Service.
	 */
	@Autowired
	private InstallmentService installmentService;

	/**
	 * Method generate payments statistic for order by order id.
	 * 
	 * @param id
	 *            order id
	 * @return payment statistic
	 */
	@Transactional
	public PaymentsStatistics generateStatistics(final Long id) {
		PaymentsStatistics statistic = new PaymentsStatistics();
		Order order = orderService.getOrderById(id);
		List<Payment> payments = order.getPayments();
		List<PaymentDTO> paymentDTOs = new LinkedList<PaymentDTO>();
		for (Payment payment : payments) {
			paymentDTOs.add(mapper.toDto(payment));
		}
		statistic.setApartmentPrice(
				installmentService.getApartmentCost(order.getInstallments()));
		statistic.setTotalPaidAmount(getTotalPaidAmount(payments));
		statistic.setPayments(paymentDTOs);
		return statistic;
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
