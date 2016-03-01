package com.softserveinc.ita.redplatform.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.redplatform.common.entity.CurrencyRate;
import com.softserveinc.ita.redplatform.persistence.dao.CurrencyRateDao;

/**
 * Implementation for CurrencyRate Dao.
 * 
 * @author Ivaniv Roman
 */
@Repository("currencyRateDao")
public class JPACurrencyRate extends JPAGenericDao<CurrencyRate, Long> 
                        implements CurrencyRateDao {
    
}
