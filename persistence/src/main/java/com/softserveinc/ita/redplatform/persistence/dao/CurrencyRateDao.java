package com.softserveinc.ita.redplatform.persistence.dao;

import java.util.Date;
import java.util.List;

import com.softserveinc.ita.redplatform.common.entity.CurrencyRate;
import com.softserveinc.ita.redplatform.common.entity.RealEstateAgency;

/**
 * Currency rate dao interface.
 * 
 * @author Ivaniv Roman
 */
public interface CurrencyRateDao extends GenericDao<CurrencyRate, Long> {

    /**
     * @param fromDate
     *            param
     * @return object of Currency rate
     */
    CurrencyRate findCurrencyFromDate(final Date fromDate);
    
    /**
     * find all currencies by some company.
     * @param reAgency real estte agency.
     * @return list of Currency Rates
     */
    List<CurrencyRate> findAllCurrenciesByCompany(RealEstateAgency reAgency);
    
    /**
     * 
     * @return number of currencies
     */
    long countAll();
    
    /**
     * @param reAgency real estte agency.
     * @return number of company currencies
     */
    long countAllCompanyCurrencies(RealEstateAgency reAgency);
}
