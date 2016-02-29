package com.softserveinc.ita.redplatform.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

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
    
    /**
     * finding all currency rates.
     * @return list of currency rates
     */
    @SuppressWarnings("unchecked")
    @Override
    public final List<CurrencyRate> findAllCurrency() {
	ArrayList<CurrencyRate> list = (ArrayList<CurrencyRate>) getEntityManager()
		.createQuery("from " + CurrencyRate.class.getName())
		.getResultList();
	return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public final CurrencyRate findCurrencyById(final Long id) {
	ArrayList<CurrencyRate> list = (ArrayList<CurrencyRate>) getEntityManager()
		.createQuery("from " + CurrencyRate.class.getName()
		+ " as currency where currency.id=:id")
		.setParameter("id", id).getResultList();
	return getSingleResult(list);
    };

}
