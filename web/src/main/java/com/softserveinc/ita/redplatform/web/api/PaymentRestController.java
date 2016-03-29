package com.softserveinc.ita.redplatform.web.api;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softserveinc.ita.redplatform.business.service.OrderService;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import com.softserveinc.ita.redplatform.business.service.PaymentService;
import com.softserveinc.ita.redplatform.business.statistics.PaymentsStatistics;
import com.softserveinc.ita.redplatform.common.dto.PaymentDTO;
import com.softserveinc.ita.redplatform.web.controller.
ResourceNotFoundException;

/**
 * Rest Controller for payments.
 * 
 * @author Hryhorii Somyk
 *
 */
@RestController
public class PaymentRestController {

    /**
     * Payment service.
     */
    @Autowired
    private PaymentService paymentService;

    /**
     * Order service.
     */
    @Autowired
    private OrderService orderService;

    /**
     * Method return payments statistic by order id.
     * 
     * @param id
     *            order id
     * @return payments statistic
     */
    @RequestMapping(value = "api/statistics/order/{id}/payments",
	    method = RequestMethod.GET)
    public final ResponseEntity<PaymentsStatistics>
	    getPaymentsStatistics(@PathVariable final Long id) {
	PaymentsStatistics statistics = orderService
		.generatePaymentsStatistics(id, SecurityContextHolder
			.getContext().getAuthentication().getName());
	if (statistics == null) {
	    throw new ResourceNotFoundException();
	}
	return new ResponseEntity<PaymentsStatistics>(statistics,
		HttpStatus.OK);
    }

    /**
     * Method return payments by order id.
     * 
     * @param id
     *            order id
     * @return list of payments
     */
    @RequestMapping(value = "api/order/{id}/payments",
	    method = RequestMethod.GET)
    public final ResponseEntity<List<PaymentDTO>>
	    getPayments(@PathVariable final Long id) {
	List<PaymentDTO> paymentDTOs =
		paymentService.getPayments(id, SecurityContextHolder
			.getContext().getAuthentication().getName());
	if (paymentDTOs == null) {
	    throw new ResourceNotFoundException();
	}
	return new ResponseEntity<List<PaymentDTO>>(paymentDTOs, HttpStatus.OK);
    }

    /**
     * Upload multiple file handler.
     *
     * @param orderId
     *            the order id
     * @param amount
     *            the amount
     * @param date
     *            the date
     * @param image
     *            the image
     * @return the response entity
     */
    @RequestMapping(value = "api/uploadPaymentImage/{orderId}/{amount}/{date}",
	    method = RequestMethod.POST)
    public final ResponseEntity<String> uploadMultipleFileHandler(
	    @PathVariable final long orderId, @PathVariable final double amount,
	    @PathVariable final long date,
	    @RequestBody final MultipartFile image) {
	ResponseEntity<String> responseEntity;
	try {
	    paymentService.createPayment(orderId, amount, date,
		    image.getBytes(), SecurityContextHolder.getContext()
			    .getAuthentication().getName());
	    responseEntity =
			new ResponseEntity<String>("OK", HttpStatus.OK);
	} catch (MaxUploadSizeExceededException e) {
	    responseEntity =
		    new ResponseEntity<String>("The file size is too big.",
			    HttpStatus.INTERNAL_SERVER_ERROR);
	} catch (IOException e) {
	    responseEntity =
		    new ResponseEntity<String>("Error while saving the file.",
			    HttpStatus.INTERNAL_SERVER_ERROR);
	}
	return responseEntity;
    }

}
