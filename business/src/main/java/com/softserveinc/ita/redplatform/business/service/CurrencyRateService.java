package com.softserveinc.ita.redplatform.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.redplatform.common.dto.CurrencyRateDTO;
import com.softserveinc.ita.redplatform.common.entity.CurrencyRate;
import com.softserveinc.ita.redplatform.common.mapper.CurrencyRateMapper;
import com.softserveinc.ita.redplatform.persistence.dao.CurrencyRateDao;

/**
 * CurrencyRate Service.
 * 
 * @author Ivaniv Roman
 */
@Service
@Transactional
public class CurrencyRateService {
    
    /** The currency dao. */
    @Autowired
    private CurrencyRateDao currencyRateDao;

    /** The mapper. */
    @Autowired
    private CurrencyRateMapper currencyRateMapper;
    
    /**
     * 
     * @return list of currency rates
     */
    public List<CurrencyRate> findAllCurrency() {
	ArrayList<CurrencyRate> list = (ArrayList<CurrencyRate>) 
		currencyRateDao.findAllCurrency();
	return list;
    };
    
    /**
     * 
     * @param currencyRateDTO object
     */
    @Transactional
    public void create(final CurrencyRateDTO currencyRateDTO) {
	CurrencyRate currencyRate = currencyRateMapper
		.toEntity(currencyRateDTO);
	currencyRateDao.save(currencyRate);
    }
    
    /**
     * 
     * @param currencyRateDTO object
     */
    public void update(final CurrencyRateDTO currencyRateDTO) {
	CurrencyRate currencyRate = currencyRateMapper
		.toEntity(currencyRateDTO);
	currencyRateDao.update(currencyRate);
    }
    
    /**
     * 
     * @param currencyRateDTO object
     */
    public void delete(final CurrencyRateDTO currencyRateDTO) {
	CurrencyRate currencyRate = currencyRateMapper
		.toEntity(currencyRateDTO);
	currencyRateDao.remove(currencyRate);
    }
    /**
     * 
     * @param id parameter
     * @return object of currencyRate
     */
    public CurrencyRate findCurrencyById(final Long id) {
	CurrencyRate currencyRate = currencyRateDao.findCurrencyById(id);
	return currencyRate;
    };
}