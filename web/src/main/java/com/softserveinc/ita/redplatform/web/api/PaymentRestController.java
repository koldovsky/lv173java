package com.softserveinc.ita.redplatform.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softserveinc.ita.redplatform.business.service.OrderService;
import com.softserveinc.ita.redplatform.business.service.PaymentService;
import com.softserveinc.ita.redplatform.business.statistics.PaymentsStatistics;
import com.softserveinc.ita.redplatform.common.dto.PaymentDTO;
import com.softserveinc.ita.redplatform.web.controller
.ResourceNotFoundException;

/**
 * Rest Controller for payments.
 * 
 * @author Hryhorii Somyk
 *
 */
@RestController
public class PaymentRestController {

	/**
	 * Payment service.
	 */
	@Autowired
	private PaymentService paymentService;

	/**
	 * Order service.
	 */
	@Autowired
	private OrderService orderService;

	/**
	 * Method return payments statistic by order id.
	 * 
	 * @param id
	 *            order id
	 * @return payments statistic
	 */
	@RequestMapping(value = "api/statistics/order/{id}/payments",
			method = RequestMethod.GET)
	public final PaymentsStatistics
			getPaymentsStatistics(@PathVariable final Long id) {
		PaymentsStatistics statistics = orderService
				.generatePaymentsStatistics(id, SecurityContextHolder
						.getContext().getAuthentication().getName());
		if (statistics == null) {
			throw new ResourceNotFoundException();
		}
		return statistics;
	}

	/**
	 * Method return payments by order id.
	 * 
	 * @param id
	 *            order id
	 * @return list of payments
	 */
	@RequestMapping(value = "api/order/{id}/payments",
			method = RequestMethod.GET)
	public final List<PaymentDTO> getPayments(@PathVariable final Long id) {
		return paymentService.getPayments(id);
	}

}
