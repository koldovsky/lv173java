package com.softserveinc.ita.redplatform.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softserveinc.ita.redplatform.business.service.PaymentService;
import com.softserveinc.ita.redplatform.business.statistics.PaymentsStatistics;

/**
 * Rest Controller for payments.
 * 
 * @author Hryhorii
 *
 */
@RestController
public class PaymentsStatisticRestController {

	/**
	 * Payment service.
	 */
	@Autowired
	private PaymentService paymentService;

	/**
	 * Method return payments statistic by order id.
	 * 
	 * @param id
	 *            order id
	 * @return payments statistic
	 */
	@RequestMapping(value = "api/order/{id}/payments",
			method = RequestMethod.GET)
	public final PaymentsStatistics
			getPaymentsStatistics(@PathVariable final Long id) {
		return paymentService.generateStatistics(id);
	}

}
