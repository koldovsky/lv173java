package com.softserveinc.ita.redplatform.business.service;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.redplatform.business.statistics.PaymentsStatistics;
import com.softserveinc.ita.redplatform.common.dto.PaymentDTO;
import com.softserveinc.ita.redplatform.common.entity.Order;
import com.softserveinc.ita.redplatform.common.entity.Payment;
import com.softserveinc.ita.redplatform.common.mapper.PaymentMapper;
import com.softserveinc.ita.redplatform.persistence.dao.PaymentDao;

/**
 * Payment Service.
 * 
 * @author Hryhorii
 * 
 */
@Service
public class PaymentService {

    /**
     * Order service.
     */
    @Autowired
    private OrderService orderService;

    /**
     * Payment mapper.
     */
    @Autowired
    private PaymentMapper mapper;

    /**
     * Installment Service.
     */
    @Autowired
    private InstallmentService installmentService;

    /**
     * Payment dao.
     */
    @Autowired
    private PaymentDao paymentDao;

    /**
     * Service for handling images.
     */
    @Autowired
    private ImageHandlingService imageHandlingService;

    /**
     * User service.
     */
    @Autowired
    private UserService userService;

    /**
     * Method generate payments statistic for order by order id.
     * 
     * @param id
     *            order id
     * @return payment statistic
     */
    @Transactional
    public PaymentsStatistics generateStatistics(final Long id) {
	PaymentsStatistics statistic = new PaymentsStatistics();
	Order order = orderService.getOrderById(id);
	statistic.setApartmentPrice(
		installmentService.getApartmentCost(order.getInstallments()));
	statistic.setTotalPaidAmount(getTotalPaidAmount(order.getPayments()));
	return statistic;
    }

    /**
     * Gets the total paid amount.
     *
     * @param payments
     *            the payments
     * @return the total paid amount
     */
    public double getTotalPaidAmount(final List<Payment> payments) {
	double total = 0;
	for (Payment payment : payments) {
	    total += payment.getAmount();
	}
	return total;
    }

    /**
     * Get all payments for order by order id.
     * 
     * @param id
     *            order id
     * @return payments list
     */
    @Transactional
    public List<PaymentDTO> getPayments(final Long id) {
	List<PaymentDTO> paymentDTOs = new LinkedList<>();
	for (Payment payment : orderService.getOrderById(id).getPayments()) {
	    paymentDTOs.add(mapper.toDto(payment));
	}
	return paymentDTOs;
    }

    /**
     * Creates the payment.
     *
     * @param orderId
     *            the order id
     * @param amount
     *            the amount
     * @param image
     *            the image
     * @param customerEmail
     *            the customer email
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    @Secured("ROLE_USER")
    @Transactional
    public void createPayment(final Long orderId, final double amount,
	    final byte[] image, 
	    final String customerEmail) throws IOException {
	Payment payment = new Payment();
	Order order = orderService.getOrderById(orderId);
	if (order.getCustomerUser().getId() != userService
		.loadUserByEmail(customerEmail).getId()) {
	    throw new SecurityException("Wrong user tries to create payment!");
	}
	payment.setOrder(order);
	payment.setAmount(amount);
	payment.setPicturePath(imageHandlingService.saveImage(image));
	paymentDao.save(payment);

    }
}
