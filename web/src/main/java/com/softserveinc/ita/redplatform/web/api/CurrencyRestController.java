package com.softserveinc.ita.redplatform.web.api;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softserveinc.ita.redplatform.business.service.CurrencyRateService;
import com.softserveinc.ita.redplatform.common.dto.CurrencyRateDTO;
import com.softserveinc.ita.redplatform.common.entity.CurrencyRate;
import com.softserveinc.ita.redplatform.integration.CurrencyJson;

/**
 * Rest Controller for registration new Real Estate Agency.
 * 
 * @author Roman Ivaniv
 * 
 */
@RestController
public class CurrencyRestController {

    /**
     * currencyJson object.
     */
    @Autowired
    private CurrencyJson currencyJson;
    /**
     * Logger for CurrencyRate Controller class.
     */
    private static final Logger LOGGER = 
	    Logger.getLogger(AgencyRestController.class);

    /**
     * currencyRateService object.
     */
    @Autowired
    private CurrencyRateService currencyRateService;

    /**
     * Get agency by id to edit.
     * 
     * @param fromDate
     *            fromDate
     * @return ResponseEntity ResponseEntity
     * @throws ParseException 
     */
    @RequestMapping(value = "/api/currency/{fromDate}", 
	    method = RequestMethod.GET)
    public final ResponseEntity<CurrencyRate> getCurrency(
	    @PathVariable("fromDate") final Date fromDate) {
	CurrencyRate currencyRate = 
		currencyRateService.findCurrencyByFromDate(fromDate);
	if (currencyRate == null) {
	    LOGGER.info("currency not found");
	    return new ResponseEntity<CurrencyRate>(HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<CurrencyRate>(currencyRate, HttpStatus.OK);
    }
    
    /**
     * 
     * @param binder binder
     */
    @InitBinder
    public final void initBinder(final WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, 
        	new CustomDateEditor(dateFormat, false));
    }

    /**
     * add currency rate.
     * 
     * @return status.
     * @param currencyRateDTO
     *            currencyRateDTO
     */
    @RequestMapping(value = "currency", method = RequestMethod.POST)
    public final ResponseEntity<CurrencyRateDTO> addCurrency(
	    @RequestBody final CurrencyRateDTO currencyRateDTO) {

	if (currencyRateDTO.isNbu()) {
	    currencyRateDTO.setAmount(currencyJson.getCourse());
	}
	
	Authentication auth = SecurityContextHolder.getContext().
		getAuthentication();
	currencyRateService.create(currencyRateDTO, auth.getName());

	return new ResponseEntity<CurrencyRateDTO>(currencyRateDTO, HttpStatus.OK);
    }

}
