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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softserveinc.ita.redplatform.business.service.OrderService;
import com.softserveinc.ita.redplatform.common.dto.OrderDTO;
import com.softserveinc.ita.redplatform.common.predicate.DataTablePredicate;
import com.softserveinc.ita.redplatform.web.controller
	.ResourceNotFoundException;
import com.softserveinc.ita.redplatform.web.datatables.DataTablesResponse;

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
     * @param draw
     *            the draw
     * @param length
     *            the length
     * @param start
     *            the start
     * @param search
     *            the search
     * @param column
     *            the column
     * @param order
     *            the order
     * @return the order list
     */
    @RequestMapping(value = "/api/orderlist", method = RequestMethod.GET)
    public final ResponseEntity<DataTablesResponse<OrderDTO>> getOrderList(
	    @RequestParam final int draw, @RequestParam final int length,
	    @RequestParam final int start,
	    @RequestParam(value = "search[value]") final String search,
	    @RequestParam(value = "order[0][column]") final int column,
	    @RequestParam(value = "order[0][dir]") final String order) {

	Collection<? extends GrantedAuthority> authorities =
		SecurityContextHolder.getContext().getAuthentication()
			.getAuthorities();
	if (authorities.contains(new SimpleGrantedAuthority("ROLE_REDADMIN"))
		|| authorities.contains(new SimpleGrantedAuthority("ROLE_USER"))) {
	    DataTablePredicate predicate = new DataTablePredicate(draw, start,
		    length, column, order, search);
	    DataTablesResponse<OrderDTO> dtResponse =
		    configureDTResponse(predicate);
	    return new ResponseEntity<DataTablesResponse<OrderDTO>>(dtResponse,
		    HttpStatus.OK);
	} else {
	    throw new ResourceNotFoundException();
	}

    }

    /**
     * Configure generic DataTablesResponse.
     *
     * @param predicate
     *            the predicate
     * @return the DataTablesResponse
     */
    private DataTablesResponse<OrderDTO>
	    configureDTResponse(final DataTablePredicate predicate) {
	String email = SecurityContextHolder.getContext().getAuthentication()
		.getName();
	List<OrderDTO> orders = orderService.getOrders(email, predicate);
	DataTablesResponse<OrderDTO> dtResp =
		new DataTablesResponse<OrderDTO>();
	dtResp.setDraw(predicate.getDraw());
	dtResp.setTotalDisplayRecords(orders.size());
	dtResp.setTotalRecords(orders.size());
	dtResp.setData(orders);
	return dtResp;
    }

}
