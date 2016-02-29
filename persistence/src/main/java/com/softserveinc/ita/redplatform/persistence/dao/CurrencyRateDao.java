package com.softserveinc.ita.redplatform.persistence.dao;

import java.util.List;

import com.softserveinc.ita.redplatform.common.entity.CurrencyRate;

/**
 * Currency rate dao interface.
 * 
 * @author Ivaniv Roman
 */
public interface CurrencyRateDao extends GenericDao<CurrencyRate, Long> {
    /**
     * find all currency rates.
     * @return list of all currency rates.
     */
    List<CurrencyRate> findAllCurrency();

    /**
     * find currency rate using id.
     * @param id of currency rate.
     * @return one currency rate.
     */
    CurrencyRate findCurrencyById(Long id);
}
