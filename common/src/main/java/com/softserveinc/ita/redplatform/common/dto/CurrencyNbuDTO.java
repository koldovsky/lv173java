package com.softserveinc.ita.redplatform.common.dto;

/**
 * Data Transfer Object for CurrencyNbuDTO class.
 * 
 * @author Ivaniv Roman
 *
 */
public class CurrencyNbuDTO {

    /**
     * Number of currency.
     */
    private int r030;

    /**
     * Currency name.
     */
    private String txt;

    /**
     * Currency amount.
     */
    private double rate;

    /**
     * Currency short name.
     */
    private String cc;

    /**
     * Currency exchange date.
     */
    private String exchangedate;

    public final int getR030() {
	return r030;
    }

    public final void setR030(final int newR030) {
	this.r030 = newR030;
    }

    public final String getTxt() {
	return txt;
    }

    public final void setTxt(final String newTxt) {
	this.txt = newTxt;
    }

    public final double getRate() {
	return rate;
    }

    public final void setRate(final double newRate) {
	this.rate = newRate;
    }

    public final String getCc() {
	return cc;
    }

    public final void setCc(final String newCc) {
	this.cc = newCc;
    }

    public final String getExchangedate() {
	return exchangedate;
    }

    public final void setExchangedate(final String newExchangedate) {
	this.exchangedate = newExchangedate;
    }

}
