package com.softserveinc.ita.redplatform.web.api;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softserveinc.ita.redplatform.business.service.OrderService;
import com.softserveinc.ita.redplatform.common.dto.OrderDTO;
import com.softserveinc.ita.redplatform.web.controller
	.ResourceNotFoundException;

/**
 * The Class OrderController.
 */
@RestController
public class OrderRestController {

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

    /**
     * Gets the order list.
     *
     * @return the order list
     */
    @RequestMapping(value = "/api/orderlist", method = RequestMethod.GET)
    public final ResponseEntity<List<OrderDTO>> getOrderList() {
	Collection<? extends GrantedAuthority> authorities =
		SecurityContextHolder.getContext().getAuthentication()
			.getAuthorities();
	if (authorities.contains(new SimpleGrantedAuthority("ROLE_REDADMIN"))
		|| authorities.contains(new SimpleGrantedAuthority("ROLE_USER"))) {
	    String email = SecurityContextHolder.getContext().getAuthentication()
			.getName();
	    List<OrderDTO> orders = orderService.getOrders(email);
	    return new ResponseEntity<List<OrderDTO>>(orders,
		    HttpStatus.OK);
	}
	throw new ResourceNotFoundException();
    }
}
