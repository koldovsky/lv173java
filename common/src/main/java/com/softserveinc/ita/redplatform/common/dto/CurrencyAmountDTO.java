package com.softserveinc.ita.redplatform.common.dto;

/**
 * Data Transfer Object for CurrencyNbuDTO class.
 * 
 * @author Ivaniv Roman
 *
 */
public class CurrencyAmountDTO {

    /**
     * Currency amount.
     */
    private double rate;

    public final double getRate() {
	return rate;
    }

    public final void setRate(final double newRate) {
	this.rate = newRate;
    }

}
