package com.softserveinc.ita.redplatform.persistence.dao;

import java.util.Date;

import com.softserveinc.ita.redplatform.common.entity.CurrencyRate;

/**
 * Currency rate dao interface.
 * 
 * @author Ivaniv Roman
 */
public interface CurrencyRateDao extends GenericDao<CurrencyRate, Long> {
    
    /**
     * @param fromDate param
     * @return object of Currency rate
     */
    CurrencyRate findCurrencyFromDate(final Date fromDate);
}
