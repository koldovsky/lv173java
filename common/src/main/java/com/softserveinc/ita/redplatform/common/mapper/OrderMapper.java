package com.softserveinc.ita.redplatform.common.mapper;

import org.springframework.stereotype.Component;
import com.softserveinc.ita.redplatform.common.dto.OrderDTO;
import com.softserveinc.ita.redplatform.common.entity.Order;

/**
 * Mapper for Orders and its entity.
 * 
 * @author Bulhakov Alex
 *
 */
@Component
public class OrderMapper implements GenericMapper<Order, OrderDTO> {

    @Override
    public final OrderDTO toDto(final Order entity) {
	OrderDTO orderDTO = new OrderDTO();
	orderDTO.setId(entity.getId());
	orderDTO.setCustomerId(entity.getCustomerUser().getId());
	return orderDTO;
    }

    @Override
    public final Order toEntity(final OrderDTO dto) {
	Order order = new Order();
	order.setId(dto.getId());
	return order;
    }

}
