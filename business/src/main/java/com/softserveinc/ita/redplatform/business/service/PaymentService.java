package com.softserveinc.ita.redplatform.business.service;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	 * Get all payments for order by order id.
	 * 
	 * @param id
	 *            order id
	 * @param email
	 *            user email
	 * @return payments list
	 */
	@Transactional
	public List<PaymentDTO> getPayments(final Long id, final String email) {
		List<PaymentDTO> paymentDTOs = new LinkedList<>();
		Order order = orderService.getOrder(id, email);
		if (order != null) {
			for (Payment payment : order.getPayments()) {
				paymentDTOs.add(mapper.toDto(payment));
			}
			return paymentDTOs;
		}
		return null;
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
