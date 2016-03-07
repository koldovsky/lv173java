package com.softserveinc.ita.redplatform.integration;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;

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

	    // Convert JSON string from file to Object
	    CurrencyNbuDTO currency = mapper.readValue(
		    new URL("http://bank.gov.ua/NBUStatService/v1/statdirectory/exch"
		    	+ "ange?valcode=USD&date=20160307&json"), CurrencyNbuDTO.class);
	    DecimalFormat format = new DecimalFormat("###.###");
	    amount = Double.parseDouble(format.format(currency.getRate()));
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
