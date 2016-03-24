package com.softserveinc.ita.redplatform.integration;

import org.apache.log4j.Logger;
import java.io.IOException;
import java.net.URL;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.softserveinc.ita.redplatform.common.dto.CurrencyAmountDTO;
import com.softserveinc.ita.redplatform.common.entity.CurrencyRate;

/**
 * Class for taking NBU course.
 * 
 * @author Roman Ivaniv
 * 
 */
@Service
public class CurrencyRateParser {
    
    /**
     * 
     */
    private static final Logger LOGGER = Logger.getLogger(CurrencyRate.class);

    /**
     * NBU url.
     */
    private static String nbuCurrency = "http://bank.gov.ua/NBUStatService/"
	    + "v1/statdirectory/exchange?valcode=USD&date=";

    /**
     * ending of NBU url.
     */
    private static String json = "&json";

    /**
     * @param date date
     * @return nbu amount
     */
    public final double getRate(final String date) {
	ObjectMapper mapper = new ObjectMapper();
	mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	double amount = 0;
	try {
	    CurrencyAmountDTO[] currency = mapper.readValue(
		    new URL(nbuCurrency + date + json), CurrencyAmountDTO[].class);
	    amount = currency[0].getRate();
	} catch (IOException e) {
	    LOGGER.info("Error with parsing currency rate", e);
	}
	return amount;
    }
}
