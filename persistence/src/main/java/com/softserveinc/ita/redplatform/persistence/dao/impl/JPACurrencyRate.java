package com.softserveinc.ita.redplatform.persistence.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.redplatform.common.entity.CurrencyRate;
import com.softserveinc.ita.redplatform.common.entity.RealEstateAgency;
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
    public final CurrencyRate findCurrencyFromDate(final Date fromDate) {
	@SuppressWarnings("unchecked")
	ArrayList<CurrencyRate> list = (ArrayList<CurrencyRate>) getEntityManager()
		.createQuery("from " + CurrencyRate.class.getName() 
			+ " as currency where currency.fromDate=:fromDate")
		.setParameter("fromDate", fromDate).getResultList();
	return getSingleResult(list);
    }

    @SuppressWarnings("unchecked")
    @Override
    public final List<CurrencyRate> findAllCurrenciesByCompany(
	    	final RealEstateAgency reAgency) {
	return (List<CurrencyRate>) getEntityManager().createQuery(
		"from " + CurrencyRate.class.getName() 
		+ " as currency where currency.reAgency=:reAgency")
		.setParameter("reAgency", reAgency).getResultList();
    }

    @Override
    public final long countAll() {
	return (long) getEntityManager()
		.createQuery("select count(*) from "
		+ CurrencyRate.class.getName()).getSingleResult();
    }
    
    @Override
    public final long countAllCompanyCurrencies(
	    	final RealEstateAgency reAgency) {
	return (long) getEntityManager()
		.createQuery("select count(*) from "
			+ CurrencyRate.class.getName() 
			+ " as currency where currency.reAgency=:reAgency")
			.setParameter("reAgency", reAgency).getSingleResult();
    }
    
}
