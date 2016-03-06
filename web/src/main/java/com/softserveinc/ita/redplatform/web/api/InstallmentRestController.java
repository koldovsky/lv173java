package com.softserveinc.ita.redplatform.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softserveinc.ita.redplatform.business.service.InstallmentService;
import com.softserveinc.ita.redplatform.common.dto.InstallmentDTO;

/**
 * The class InstallmentController.
 * 
 * @author Ilona Yavorska
 */
@RestController
public class InstallmentRestController {

    /** The installment service. */
    @Autowired
    private InstallmentService installmentService;

    /**
     * Adds installment.
     *
     * @param orderId
     *            the user id
     * @param installmentList
     *            the installmentList
     * @return the response entity
     */
    @RequestMapping(value = "/installment/{orderId}", 
	    method = RequestMethod.POST)
    public final ResponseEntity<String> addInstallment(
	    @PathVariable final Long orderId,
	    @RequestBody final List<InstallmentDTO> installmentList) {
	installmentService.addInstallment(installmentList, orderId);
	return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
