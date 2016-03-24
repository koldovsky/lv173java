package com.softserveinc.ita.redplatform.business.dateconverter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Component;

/**
 * class for converting date to string.
 * 
 * @author Roman Ivaniv
 *
 */
@Component
public class DateConverter {

    /**
     * 
     * @return date in String format
     */
    public final String convertDate() {
	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	Calendar date = Calendar.getInstance();
	return dateFormat.format(checkIfWeekend(date).getTime());
    }

    /**
     * 
     * @param date
     *            date
     * @return date in String format
     */
    public final String convertDate(final Calendar date) {
	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	return dateFormat.format(checkIfWeekend(date).getTime());
    }
    
    /**
     * 
     * @param date date
     * @return date
     */
    public final Calendar checkIfWeekend(final Calendar date) {
	if (date.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
	    date.add(Calendar.DATE, 1);
	}
	if (date.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
	    date.add(Calendar.DATE, 2);
	 }
	return date;
    }
}
