package com.softserveinc.ita.redplatform.web.api;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import com.softserveinc.ita.redplatform.business.service.PaymentService;
import com.softserveinc.ita.redplatform.business.statistics.PaymentsStatistics;
import com.softserveinc.ita.redplatform.common.dto.PaymentDTO;

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
     * Method return payments statistic by order id.
     * 
     * @param id
     *            order id
     * @return payments statistic
     */
    @RequestMapping(value = "api/statistics/order/{id}/payments",
	    method = RequestMethod.GET)
    public final PaymentsStatistics
	    getPaymentsStatistics(@PathVariable final Long id) {
	return paymentService.generateStatistics(id);
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
    public final List<PaymentDTO> getPayments(@PathVariable final Long id) {
	return paymentService.getPayments(id);
    }

    /**
     * Upload multiple file handler.
     *
     * @param orderId
     *            the order id
     * @param amount
     *            the amount
     * @param image
     *            the image
     * @return the response entity
     */
    @RequestMapping(value = "/uploadPaymentImage", method = RequestMethod.POST)
    public final ResponseEntity<String> uploadMultipleFileHandler(
	    @RequestParam("orderId") final Long orderId,
	    @RequestParam("amount") final double amount,
	    @RequestParam("image") final MultipartFile image) {
	ResponseEntity<String> responseEntity = null;
	try {
	    responseEntity = new ResponseEntity<String>("OK", HttpStatus.OK);
	    paymentService.createPayment(orderId, amount, image.getBytes(),
		    SecurityContextHolder.getContext().getAuthentication()
			    .getName());
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
