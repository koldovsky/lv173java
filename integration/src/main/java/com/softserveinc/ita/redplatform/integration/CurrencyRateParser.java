package com.softserveinc.ita.redplatform.integration;

import org.apache.log4j.Logger;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
     *
     * @return nbu amount
     */
    public final double getRate() {
	ObjectMapper mapper = new ObjectMapper();
	mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	double amount = 0;
	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	Calendar cal = Calendar.getInstance();
	if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
	    cal.add(Calendar.DATE, 1);
	}
	if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
	    cal.add(Calendar.DATE, 2);
	}
	String date = dateFormat.format(cal.getTime());
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
