package com.softserveinc.ita.redplatform.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softserveinc.ita.redplatform.business.service.PaymentService;
import com.softserveinc.ita.redplatform.common.dto.PaymentDTO;

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
	 * Method return payments list by order id.
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
