package com.softserveinc.ita.redplatform.persistence.dao;

import java.util.Date;
import java.util.List;

import com.softserveinc.ita.redplatform.common.entity.CurrencyRate;
import com.softserveinc.ita.redplatform.common.entity.RealEstateAgency;
import com.softserveinc.ita.redplatform.common.predicate.DataTablePredicate;

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
     * @param predicate predicate
     * @param reAgency real estte agency.
     * @return list of Currency Rates
     */
    List<CurrencyRate> findAllCurrenciesByCompany(RealEstateAgency reAgency,
	    DataTablePredicate predicate);
    
    /**
     * 
     * @return number of currencies
     */
    long countAll();
    
    /**
     * @param predicate predicate
     * @return number of currencies
     */
    long countAll(DataTablePredicate predicate);
    
    /**
     * @param reAgency real estte agency.
     * @return number of company currencies
     */
    long countAllCompanyCurrencies(RealEstateAgency reAgency);
    
    /**
     * 
     * @param reAgency reAgency
     * @param predicate predicate
     * @return number of company currencies
     */
    long countAllCompanyCurrencies(RealEstateAgency reAgency,
	    DataTablePredicate predicate);
    
    /**
     * 
     * @param predicate predicate
     * @return list of currency rates
     */
    List<CurrencyRate> findAll(DataTablePredicate predicate);
}
