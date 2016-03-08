package com.softserveinc.ita.redplatform.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.redplatform.common.dto.CustomerUserDTO;
import com.softserveinc.ita.redplatform.common.dto.OrderDTO;
import com.softserveinc.ita.redplatform.common.entity.CustomerUser;
import com.softserveinc.ita.redplatform.common.entity.Installment;
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

    /** The customer user service. */
    @Autowired
    private CustomerUserService customerUserService;
    
    /** The installment service. */
    @Autowired
    private InstallmentService installmentService;

    /**
     * CutomerUser Dao.
     */
    @Autowired
    private CustomerUserDao customerUserDao;

    /** The mapper. */
    @Autowired
    private OrderMapper mapper;

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
	CustomerUser customer = prepareCustomer(orderDTO.getCustomer());
	order.setCustomerUser(customer);
	List<Installment> installments = installmentService
		.prepareInstallments(orderDTO.getInstallment(), order);
	order.setInstallments(installments);
	orderDao.save(order);
	return mapper.toDto(order);

    }
    
    /**
     * Prepare customer.
     *
     * @param customerDTO the customer dto
     * @return the customer
     */
    private CustomerUser prepareCustomer(final CustomerUserDTO customerDTO) {
	CustomerUser customer;
	if (customerDTO.getId() != null) {
	    customer = customerUserDao.findById(customerDTO.getId());
	} else {
	    customer = (CustomerUser) customerUserService
		    .registerPreprocess(customerDTO);
	}
	return customer;
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
