package com.softserveinc.ita.redplatform.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Payments statistics page controller.
 * 
 * @author Hryhorii Somyk
 *
 */
@Controller
public class PaymentsStatisticsController {

	/**
	 * Payments statistics page mapping.
	 * 
	 * @return payments statistics page
	 */
	@RequestMapping(value = "/statistics/order/{id}/payments",
			method = RequestMethod.GET)
	public final String getPaymentsStatisticsPage() {
		return "statistics/payments";
	}
}
