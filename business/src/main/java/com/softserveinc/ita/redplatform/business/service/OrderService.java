package com.softserveinc.ita.redplatform.business.service;

import java.util.LinkedList;
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
import com.softserveinc.ita.redplatform.common.entity.Payment;
import com.softserveinc.ita.redplatform.common.mapper.OrderMapper;
import com.softserveinc.ita.redplatform.common.predicate.DataTablePredicate;
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

    /** The customer user service. */
    @Autowired
    private CustomerUserService customerUserService;

    /** The installment service. */
    @Autowired
    private InstallmentService installmentService;
    
    /** The payment service. */
    @Autowired
    private PaymentService paymentService;

    /**
     * CutomerUser Dao.
     */
    @Autowired
    private CustomerUserDao customerUserDao;
    
    /** The order dao. */
    @Autowired
    private OrderDao orderDao;

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
     * @param customerDTO
     *            the customer dto
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

    /**
     * Count company orders by email.
     *
     * @param email
     *            the email
     * @return the long
     */
    @Transactional
    public Long countCompanyOrdersByEmail(final String email) {
	return orderDao.countCompanyOrders(email);
    }

    /**
     * Load company orders by email.
     *
     * @param email
     *            the email
     * @param predicate
     *            the predicate
     * @return the list
     */
    @Transactional
    public List<OrderDTO> loadCompanyOrdersByEmail(final String email,
	    final DataTablePredicate predicate) {
	List<Order> orders = orderDao.loadCompanyOrders(email, predicate);
	LinkedList<OrderDTO> orderDTOs = new LinkedList<>();
	OrderDTO orderDTO;
	for (Order order : orders) {
	    orderDTO = mapper.toDto(order);
	    orderDTO.setStatus(getOrderStatus(order).toString());
	    orderDTO.setProgress(getProgress(order));
	    orderDTOs.add(orderDTO);
	}
	return orderDTOs;

    }
    
    /**
     * Gets the order status.
     *
     * @param order the order
     * @return the order status
     */
    private OrderStatus getOrderStatus(final Order order) {
	if (isInProgress(order)) {
	    if (isMissedFulfillment(order)) {
		return OrderStatus.MISSED_FULFILLMENT;
	    }
	    return OrderStatus.IN_PROGRESS;
	}
	return OrderStatus.FINISHED;
    }
    
    /**
     * Checks if order is in progress.
     *
     * @param order the order
     * @return true, if order is in progress
     */
    private boolean isInProgress(final Order order) {
	List<Installment> installments = order.getInstallments();
	List<Payment> payments = order.getPayments();
	return installmentService.getApartmentCost(installments) 
		- paymentService.getTotalPaidAmount(payments) > 0;
    }
    
    /**
     * Checks if order is missed fulfillment.
     *
     * @param order the order
     * @return true, if order is missed fulfillment
     */
    private boolean isMissedFulfillment(final Order order) {
	List<Installment> installments = order.getInstallments();
	List<Payment> payments = order.getPayments();
	return paymentService.getPaidAmountTillNow(payments)
		- installmentService.getInstallmentsAmountTillNow(installments) < 0;
    }
    
    /**
     * Represents order status.
     */
    private enum OrderStatus {
	/** The in progress status. */
	IN_PROGRESS, 
	/** The finished status. */
	FINISHED, 
	/** The missed fulfillment status. */
	MISSED_FULFILLMENT;
    }
    
    /**
     * Gets the progress.
     *
     * @param order the order
     * @return the progress
     */
    private double getProgress(final Order order) {
	List<Installment> installments = order.getInstallments();
	List<Payment> payments = order.getPayments();
	return paymentService.getPaidAmountTillNow(payments) 
		/ installmentService.getApartmentCost(installments);
    }
    
	/**
	 * Method return order by order id.
	 * 
	 * @param id
	 *            order id
	 * @return oder order
	 */
    @Transactional
	public Order getOrderById(final Long id) {
		return orderDao.findById(id);
	}

}
