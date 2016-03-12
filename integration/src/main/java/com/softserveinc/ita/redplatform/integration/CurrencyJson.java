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
public class CurrencyJson {
    
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
    public final double getCourse() {
	ObjectMapper mapper = new ObjectMapper();
	mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	double amount = 0;
	try {
	    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	    Calendar cal = Calendar.getInstance();
	    String date = dateFormat.format(cal.getTime());
	    CurrencyNbuDTO [] currency = mapper.readValue(
		    new URL(nbuCurrency + date + json), 
		    	CurrencyNbuDTO[].class);
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

}
