package com.softserveinc.ita.redplatform.integration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Class for taking NBU course.
 * 
 * @author Roman Ivaniv
 * 
 */
public class NbuJSON {

    /**
     * 
     * @return nbu amount
     */
    public final double setNbuCourse() {

	JSONParser parser = new JSONParser();
	Double amount = null;

	try {
	    URL nbu = new URL("http://bank.gov.ua/NBUStatService/"
	    	+ "v1/statdirectory/exchange?json");
	    URLConnection connection = nbu.openConnection();
	    BufferedReader reader = new BufferedReader(
		    new InputStreamReader(connection.getInputStream()));

	    String inputLine;
	    while ((inputLine = reader.readLine()) != null) {

		JSONArray currencies = (JSONArray) parser.parse(inputLine);

		for (Object o : currencies) {
		    JSONObject usd = (JSONObject) o;

		    if (usd.get("cc").equals("USD")) {
			amount = (Double) usd.get("rate");
			DecimalFormat format = new DecimalFormat("##.###");
			amount = Double.parseDouble(format.format(amount));
		    }
		}
	    }
	    reader.close();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e1) {
	    e1.printStackTrace();
	} catch (ParseException e2) {
	    e2.printStackTrace();
	}

	return amount;
    }

}
