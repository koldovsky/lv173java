package com.softserveinc.ita.redplatform.web.api;

import org.apache.log4j.Logger;
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
public class OrderController {
    /**
     * Logger for Order Controller class.
     */
    private static final Logger LOGGER =
	    Logger.getLogger(OrderController.class);

    /** The order service. */
    @Autowired
    private OrderService orderService;

    /**
     * Creates the order.
     *
     * @param orderDTO the order dto
     * @return the response entity
     */
    @RequestMapping(value = "order", method = RequestMethod.POST)
    public final ResponseEntity<OrderDTO>
	    createOrder(@RequestBody final OrderDTO orderDTO) {

	orderService.create(orderDTO);

	return new ResponseEntity<OrderDTO>(orderDTO, HttpStatus.OK);
    }

}
