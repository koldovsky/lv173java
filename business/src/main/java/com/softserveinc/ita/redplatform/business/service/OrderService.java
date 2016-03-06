package com.softserveinc.ita.redplatform.business.service;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.redplatform.common.dto.InstallmentDTO;
import com.softserveinc.ita.redplatform.common.dto.OrderDTO;
import com.softserveinc.ita.redplatform.common.entity.CustomerUser;
import com.softserveinc.ita.redplatform.common.entity.Installment;
import com.softserveinc.ita.redplatform.common.entity.Order;
import com.softserveinc.ita.redplatform.common.mapper.InstallmentMapper;
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

    /** The customer user service. */
    @Autowired
    private CustomerUserService customerUserService;

    /**
     * CutomerUser Dao.
     */
    @Autowired
    private CustomerUserDao customerUserDao;

    /** The mapper. */
    @Autowired
    private OrderMapper mapper;

    /** The installment mapper. */
    @Autowired
    private InstallmentMapper installmentMapper;

    /**
     * Creates the order.
     *
     * @param orderDTO
     *            the order dto
     * @return OrderDTO orderDTO
     */
    @Transactional
    public OrderDTO create(final OrderDTO orderDTO) {
	Order order = mapper.toEntity(orderDTO);
	if (order.getCustomerUser().getId() != null) {
	    order.setCustomerUser(
		    customerUserDao.findById(order.getCustomerUser().getId()));
	} else {
	    CustomerUser customerUser = (CustomerUser) customerUserService
		    .registerPreprocess(orderDTO.getCustomer());
	    order.setCustomerUser(customerUser);
	}
	Installment installment = null;
	LinkedList<Installment> installments = new LinkedList<>();
	for (InstallmentDTO dto : orderDTO.getInstallment()) {
	    installment = installmentMapper.toEntity(dto);
	    installment.setOrder(order);
	    installments.add(installment);
	}
	order.setInstallments(installments);
	orderDao.save(order);
	return mapper.toDto(order);

    }

    /**
     * Checks if order id is present.
     *
     * @param orderId
     *            the order id
     * @return boolean true if order id is present
     */
    @Transactional
    public boolean isOrderIdPresent(final Long orderId) {
	return orderDao.findById(orderId) != null;
    }

}
