package com.softserveinc.ita.redplatform.common.mapper;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.softserveinc.ita.redplatform.common.dto.InstallmentDTO;
import com.softserveinc.ita.redplatform.common.dto.OrderDTO;
import com.softserveinc.ita.redplatform.common.entity.Installment;
import com.softserveinc.ita.redplatform.common.entity.Order;

/**
 * Mapper for Orders and its entity.
 * 
 * @author Bulhakov Alex
 *
 */
@Component
public class OrderMapper implements GenericMapper<Order, OrderDTO> {

    /**
     * Address mapper for conversion between DTO and entity.
     */
    @Autowired
    private AddressMapper addressMapper;

    /**
     * CustomerUser mapper for conversion between DTO and entity.
     */
    @Autowired
    private CustomerUserMapper customerUserMapper;

    /**
     * Installment mapper for conversion between DTO and entity.
     */
    @Autowired
    private InstallmentMapper installmentMapper;

    @Override
    public final OrderDTO toDto(final Order entity) {
	OrderDTO orderDTO = new OrderDTO();
	orderDTO.setId(entity.getId());
	orderDTO.setDescription(entity.getDescription());
	orderDTO.setArea(entity.getArea());
	orderDTO.setCustomer(
		customerUserMapper.toDto(entity.getCustomerUser()));
	orderDTO.setRoomsQuantity(entity.getRoomsQuantity());
	orderDTO.setAddress(addressMapper.toDto(entity.getAddress()));
	
	List<InstallmentDTO> installmentDTOs = new LinkedList<>();
	for (Installment installment : entity.getInstallments()) {
	    installmentDTOs.add(installmentMapper.toDto(installment));
	}
	orderDTO.setInstallment(installmentDTOs);
	
	return orderDTO;
    }

    @Override
    public final Order toEntity(final OrderDTO dto) {
	Order order = new Order();
	order.setId(dto.getId());
	order.setArea(dto.getArea());
	order.setRoomsQuantity(dto.getRoomsQuantity());
	order.setDescription(dto.getDescription());
	order.setAddress(addressMapper.toEntity(dto.getAddress()));
	order.setCustomerUser(customerUserMapper.toEntity(dto.getCustomer()));
	return order;
    }

}
