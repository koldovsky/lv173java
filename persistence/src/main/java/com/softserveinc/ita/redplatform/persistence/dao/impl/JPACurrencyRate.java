package com.softserveinc.ita.redplatform.persistence.dao.impl;

import java.util.ArrayList;
import java.util.Date;

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
    @Override
    public final CurrencyRate findCurrencyByDate(final Date fromDate) {
	@SuppressWarnings("unchecked")
	ArrayList<CurrencyRate> list = (ArrayList<CurrencyRate>) getEntityManager()
		.createQuery("from " + CurrencyRate.class.getName() 
			+ " as currency where currency.fromDate=:fromDate")
		.setParameter("fromDate", fromDate).getResultList();
	return getSingleResult(list);
    }

}
