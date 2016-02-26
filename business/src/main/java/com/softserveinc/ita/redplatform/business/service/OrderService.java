package com.softserveinc.ita.redplatform.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.redplatform.common.dto.OrderDTO;
import com.softserveinc.ita.redplatform.common.entity.Order;
import com.softserveinc.ita.redplatform.common.mapper.OrderMapper;
import com.softserveinc.ita.redplatform.persistence.dao.CustomerUserDao;
import com.softserveinc.ita.redplatform.persistence.dao.OrderDao;

/**
 * Order Service.
 * 
 * @author Bulhakov Alex
 */
@Service
@Secured("ROLE_REDADMIN")
public class OrderService {

    /** The order dao. */
    @Autowired
    private OrderDao orderDao;

    /** The customer user dao. */
    @Autowired
    private CustomerUserDao customerUserDao;

    /** The mapper. */
    @Autowired
    private OrderMapper mapper;

    /**
     * Creates the order.
     *
     * @param orderDTO the order dto
     */
    @Transactional
    public void create(final OrderDTO orderDTO) {
	Order order = mapper.toEntity(orderDTO);
	order.setCustomerUser(
		customerUserDao.findById(orderDTO.getCustomerId()));
	orderDao.save(order);

    }
    
    /**
     * Checks if order id is present.
     *
     * @param orderId the order id
     * @return true, if order id is present
     */
    @Transactional
    public boolean isOrderIdPresent(final Long orderId) {
	return orderDao.findById(orderId) != null;
    }

}
