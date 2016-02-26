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
	orderDTO.setDescription(entity.getDescription());
	orderDTO.setArea(entity.getArea());
	orderDTO.setCustomerId(entity.getCustomerUser().getId());
	orderDTO.setRoomsQuantity(entity.getRoomsQuantity());
	return orderDTO;
    }

    @Override
    public final Order toEntity(final OrderDTO dto) {
	Order order = new Order();
	order.setId(dto.getId());
	order.setArea(dto.getArea());
	order.setRoomsQuantity(dto.getRoomsQuantity());
	order.setDescription(dto.getDescription());
	return order;
    }

}
