package com.softserveinc.ita.redplatform.integration;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.softserveinc.ita.redplatform.common.dto.CurrencyNbuDTO;

/**
 * Class for taking NBU course.
 * 
 * @author Roman Ivaniv
 * 
 */
@Service
public class CurrencyAmount {
    
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
     * @param date object
     * @return nbu amount
     */
    public final double getCourse(final String date) {
	ObjectMapper mapper = new ObjectMapper();
	mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	double amount = 0;
	try {
	    CurrencyNbuDTO [] currency = mapper.readValue(
		    new URL(nbuCurrency + date + json), CurrencyNbuDTO[].class);
	    amount = currency[0].getRate();
	} catch (JsonGenerationException e) {
	    e.printStackTrace();
	} catch (JsonMappingException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return amount;
    }
    
    /**
     * 
     * @return date.
     */
    public final String getDate() {
	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	Calendar cal = Calendar.getInstance();
	if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
	    cal.add(Calendar.DATE, 1);
	}
	if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
	    cal.add(Calendar.DATE, 2);
	}
	return dateFormat.format(cal.getTime());
    }
    
}
