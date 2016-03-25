package com.softserveinc.ita.redplatform.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.redplatform.business.statistics.PaymentsStatistics;
import com.softserveinc.ita.redplatform.common.dto.CustomerUserDTO;
import com.softserveinc.ita.redplatform.common.dto.OrderDTO;
import com.softserveinc.ita.redplatform.common.entity.CustomerUser;
import com.softserveinc.ita.redplatform.common.entity.Installment;
import com.softserveinc.ita.redplatform.common.entity.Order;
import com.softserveinc.ita.redplatform.common.mapper.OrderMapper;
import com.softserveinc.ita.redplatform.persistence.dao.CustomerUserDao;
import com.softserveinc.ita.redplatform.persistence.dao.InstallmentDao;
import com.softserveinc.ita.redplatform.persistence.dao.OrderDao;
import com.softserveinc.ita.redplatform.persistence.dao.PaymentDao;

/**
 * Order Service.
 * 
 * @author Bulhakov Alex
 * @author Ilona Yavorska
 */
@Service
public class OrderService {

    /**
     * Percentage.
     */
    private static final int PERCENTAGE = 100;

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

    /** The order dao. */
    @Autowired
    private OrderDao orderDao;

    /** The installment dao. */
    @Autowired
    private InstallmentDao installmentDao;

    /** The payment dao. */
    @Autowired
    private PaymentDao paymentDao;

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
     * Gets the orders.
     *
     * @param userMail
     *            the user email
     * @return the order list
     */
    @Transactional
    public List<OrderDTO> getOrders(final String userMail) {
	List<Order> orders = orderDao.loadOrders(userMail);
	List<OrderDTO> orderDTOs = new ArrayList<>();
	OrderDTO orderDTO;
	for (Order order : orders) {
	    orderDTO = mapper.toDto(order);
	    orderDTO.setStatus(getOrderStatus(order).toString());
	    orderDTO.setProgress(getProgress(order));
	    orderDTO.setAgency(orderDao.getAgencyName(order.getId()));
	    orderDTOs.add(orderDTO);
	}
	return orderDTOs;

    }

    /**
     * Gets the order status.
     *
     * @param order
     *            the order
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
     * @param order
     *            the order
     * @return true, if order is in progress
     */
    private boolean isInProgress(final Order order) {
	return installmentDao.getOrderCost(order.getId())
		- paymentDao.getPaidAmount(order.getId()) > 0;
    }
    
    /**
     * Checks if order is missed fulfillment.
     *
     * @param order
     *            the order
     * @return true, if order is missed fulfillment
     */
    private boolean isMissedFulfillment(final Order order) {
	return paymentDao.getPaidAmount(order.getId())
		- installmentDao.getInstallmentAmountTillNow(order.getId()) < 0;
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
     * @param order
     *            the order
     * @return the progress
     */
    private double getProgress(final Order order) {
	return paymentDao.getPaidAmount(order.getId())
		/ installmentDao.getOrderCost(order.getId());
    }

    /**
     * Method return order by order id.
     * 
     * @param id
     *            order id
     * @return oder order
     */
    @Secured({ "ROLE_REDADMIN", "ROLE_USER" })
    @Transactional
    public Order getOrderById(final Long id) {
	return orderDao.findById(id);
    }

    /**
     * Method return get order by order id and user email. Check if user has
     * access to order info then return order else return null.
     * 
     * @param id
     *            order id
     * @param email
     *            user email
     * @return order
     */
    @Secured({ "ROLE_USER", "ROLE_REDADMIN" })
    public Order getOrder(final Long id, final String email) {
	return orderDao.getOrder(id, email);
    }

    /**
     * Method generate payments statistics for order. Check if user has access
     * to this order.
     * 
     * @param id
     *            order id
     * @param email
     *            user email
     * @return payments statistics
     */
    @Transactional
    @Secured({ "ROLE_USER", "ROLE_REDADMIN" })
    public PaymentsStatistics generatePaymentsStatistics(final Long id,
	    final String email) {
	Order order = getOrder(id, email);
	if (order != null) {
	    PaymentsStatistics statistics = new PaymentsStatistics();
	    double apartmentPrice = installmentDao.getOrderCost(id);
	    double totalPaidAmount = paymentDao.getPaidAmount(id);
		double leftPayAmount = apartmentPrice - totalPaidAmount;
		double progress = totalPaidAmount / apartmentPrice * PERCENTAGE;
		if (leftPayAmount < 0) {
			leftPayAmount = 0;
		}
		if (progress > PERCENTAGE) {
			progress = PERCENTAGE;
		}
	    statistics.setApartmentPrice(apartmentPrice);
	    statistics.setTotalPaidAmount(totalPaidAmount);
	    statistics.setLeftPayAmount(leftPayAmount);
	    statistics.setNextInstallment(installmentService
		    .getNextInstallment(order, totalPaidAmount));
	    statistics.setMissedInstallment(installmentService
		    .getMissedInstallment(order, totalPaidAmount));
	    statistics.setProgress(progress);
	    return statistics;
	}
	return null;
    }

}
