package com.softserveinc.ita.redplatform.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.softserveinc.ita.redplatform.business.service.CustomerUserService;
import com.softserveinc.ita.redplatform.business.service.OrderService;
import com.softserveinc.ita.redplatform.common.dto.OrderDTO;

/**
 * Controller for order creation.
 * 
 * @author Bulhakov Alex
 * 
 */
@Controller
public class OrderController {

    /**
     * Order service.
     */
    @Autowired
    private OrderService orderService;
    /**
     * Customer user service.
     */
    @Autowired
    private CustomerUserService customerUserService;

    /**
     * Gets the order page.
     *
     * @param customerId
     *            the customer id
     * @return the order page
     */
    @RequestMapping(value = "/order/{customerId}", method = RequestMethod.GET)
    public final String getOrderPage(@PathVariable final Long customerId) {
	if (customerUserService.isCustomerIdPresent(customerId)) {
	    return "order";
	} else {
	    return "404";
	}
    }

    /**
     * Adds order.
     *
     * @param customerId
     *            the user id
     * @param orderDTO
     *            OrderDTO
     * @return the response entity
     */
    @RequestMapping(value = "/order/{customerId}", method = RequestMethod.POST)
    public final String addOrder(
	    @PathVariable final Long customerId,
	    @RequestBody final OrderDTO orderDTO) {
	Long orderId = orderService.create(orderDTO, customerId);
	// TODO: Redirect user to installments page. Use FlashAttribute?
	return "/installment/" + orderId.toString();
    }

}
