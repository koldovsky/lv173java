package com.softserveinc.ita.redplatform.persistence.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.redplatform.common.entity.CurrencyRate;
import com.softserveinc.ita.redplatform.common.entity.RealEstateAgency;
import com.softserveinc.ita.redplatform.common.predicate.DataTablePredicate;
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
     * Search fields string.
     */
    private final String searchFields = "amount like concat('%',:search,'%')"
					+ " or fromDate like concat('%',:search,'%')"
					+ " or toDate like concat('%',:search,'%')";
    
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
    public final List<CurrencyRate> findAll(
	    	final DataTablePredicate predicate) {
	return (List<CurrencyRate>) getEntityManager()
		.createQuery("from " + CurrencyRate.class.getName() 
		+ " where " + searchFields
		+ " order by " + getOrderField(predicate)
		+ " " + getOrderDirection(predicate))
		.setParameter("search", predicate.getSearch())
		.setFirstResult(predicate.getStart())
		.setMaxResults(predicate.getLength())
		.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public final List<CurrencyRate> findAllCurrenciesByCompany(
	    final RealEstateAgency reAgency, final DataTablePredicate predicate) {
	return (List<CurrencyRate>) getEntityManager()
		.createQuery("from " + CurrencyRate.class.getName() 
		+ " where reAgency=:reAgency"
		+ " and (" + searchFields + ")"
		+ " order by " + getOrderField(predicate)
		+ " " + getOrderDirection(predicate))
		.setParameter("reAgency", reAgency)
		.setParameter("search", predicate.getSearch())
		.setFirstResult(predicate.getStart())
		.setMaxResults(predicate.getLength())
		.getResultList();
    }
    
    /**
     * Get order Column name.
     * @param predicate predicate
     * @return order column name
     */
    private String getOrderField(
	final DataTablePredicate predicate) {
		if (predicate.getColumn() == 0) {
		    return "amount ";
		} else 
		    if (predicate.getColumn() == 1) {
		    return "fromDate ";
		} else if (predicate.getColumn() == 2) {
		    return "toDate ";
		}
		return "createdDate ";   
    }
    
    /**
     * Get order direction.
     * @param predicate predicate
     * @return order column name
     */
    private String getOrderDirection(
	    final DataTablePredicate predicate) {
	if (predicate.getOrder().equalsIgnoreCase("desc")) {
	    return "desc";
	}
	    return "asc";   
    }

    @Override
    public final long countAll() {
	return (long) getEntityManager()
		.createQuery("select count(*) from "
		+ CurrencyRate.class.getName()).getSingleResult();
    }
    
    @Override
    public final long countAll(final DataTablePredicate predicate) {
	return Long.parseLong((String) getEntityManager()
		.createQuery("select count(*) from " + CurrencyRate.class.getName()
			+ " where " + searchFields)
			.setParameter("search", predicate.getSearch())
			.getSingleResult().toString());
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

    @Override
    public final long countAllCompanyCurrencies(
	    final RealEstateAgency reAgency, final DataTablePredicate predicate) {
	  return Long.parseLong((String) getEntityManager().
			createQuery("select count(*) from " + CurrencyRate.class.getName() 
				+ " where reAgency=:reAgency "
				+ " and (" + searchFields + ")")
				.setParameter("reAgency", reAgency)
				.setParameter("search", predicate.getSearch())
				.getSingleResult().toString());
    }
    
}
