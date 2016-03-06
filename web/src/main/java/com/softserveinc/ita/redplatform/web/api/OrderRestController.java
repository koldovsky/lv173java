package com.softserveinc.ita.redplatform.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softserveinc.ita.redplatform.business.service.OrderService;
import com.softserveinc.ita.redplatform.common.dto.OrderDTO;

/**
 * The Class OrderController.
 */
@RestController
public class OrderRestController {
    // TODO: Create rest controller for orders.

    /**
     * Order service.
     */
    @Autowired
    private OrderService orderService;

    /**
     * Adds order.
     *
     * @param orderDTO
     *            OrderDTO
     * @return the response entity
     */
    @RequestMapping(value = "api/order/", method = RequestMethod.POST)
    public final ResponseEntity<OrderDTO>
	    addOrder(@RequestBody final OrderDTO orderDTO) {
	OrderDTO responseOrder;
	responseOrder = orderService.create(orderDTO);
	return new ResponseEntity<>(responseOrder, HttpStatus.CREATED);
    }

}
