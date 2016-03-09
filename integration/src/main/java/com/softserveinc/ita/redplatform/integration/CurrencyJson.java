package com.softserveinc.ita.redplatform.integration;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonGenerationException;
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
     * 
     * @return nbu amount
     */
    public final double setNbuCourse() {
	ObjectMapper mapper = new ObjectMapper();
	double amount = 0;
	try {
	    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	    Calendar cal = Calendar.getInstance();
	    String date = dateFormat.format(cal.getTime());
	    CurrencyNbuDTO [] currency = mapper.readValue(
		    new URL("http://bank.gov.ua/NBUStatService/v1/statdirectory/exch"
		    	+ "ange?valcode=USD&date=" + date + "&json"), 
		    	CurrencyNbuDTO[].class);
	    DecimalFormat format = new DecimalFormat("###.###");
	    amount = Double.parseDouble(format.format(currency[0].getRate()));
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
