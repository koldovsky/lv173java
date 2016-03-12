package com.softserveinc.ita.redplatform.business.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.redplatform.common.dto.CurrencyRateDTO;
import com.softserveinc.ita.redplatform.common.entity.CurrencyRate;
import com.softserveinc.ita.redplatform.common.entity.RealEstateAdminUser;
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
    
    /**
     *  User service.
     */
    @Autowired
    private UserService userService;
    
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
	return currencyRateDao.findAll();
    };
    
    /**
     * 
     * @param currencyRateDTO object
     * @param email of authentication user
     */
    @Transactional
    public void create(final CurrencyRateDTO currencyRateDTO, 
	    final String email) {
	CurrencyRate currencyRate = currencyRateMapper
		.toEntity(currencyRateDTO);
	RealEstateAdminUser redAdmin = (RealEstateAdminUser)
		userService.loadUserByEmail(email);
	currencyRate.setReAgency(redAdmin.getAgency());
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
     * @param fromDate parameter
     * @return object of currencyRate
     */
    public CurrencyRate findCurrencyByFromDate(final Date fromDate) {
	return currencyRateDao.findCurrencyFromDate(fromDate);
    };
}
