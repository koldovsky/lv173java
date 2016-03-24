package com.softserveinc.ita.redplatform.business.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.redplatform.business.dateconverter.DateConverter;
import com.softserveinc.ita.redplatform.common.dto.CurrencyRateDTO;
import com.softserveinc.ita.redplatform.common.entity.CurrencyRate;
import com.softserveinc.ita.redplatform.common.entity.RealEstateAdminUser;
import com.softserveinc.ita.redplatform.common.entity.RealEstateAgency;
import com.softserveinc.ita.redplatform.common.mapper.CurrencyRateMapper;
import com.softserveinc.ita.redplatform.common.predicate.DataTablePredicate;
import com.softserveinc.ita.redplatform.integration.CurrencyRateParser;
import com.softserveinc.ita.redplatform.persistence.dao.CurrencyRateDao;
import com.softserveinc.ita.redplatform.persistence.dao.RealEstateAdminUserDao;

/**
 * CurrencyRate Service.
 * 
 * @author Ivaniv Roman
 */
@Service
@Transactional
public class CurrencyRateService {
    
    /**
     * DateConverter object.
     */
    @Autowired
    private DateConverter dateConverter;
    /**
     * RealEstateAdminUserDao object.
     */
    @Autowired
    private RealEstateAdminUserDao redAdminDao;
    
    /**
     * currencyJson object.
     */
    @Autowired
    private CurrencyRateParser currencyRateParser;

    /**
     * User service.
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
     * one day in milliseconds. 
     */
    private static final long ONEDAYINMILLIS = 86400000;
    /**
     * 
     * @param currencyRateDTO
     *            object
     * @param email
     *            of authentication user
     */
    @Transactional
    public void create(final CurrencyRateDTO currencyRateDTO,
	    	final String email) {
	if (currencyRateDTO.isNbu()) {
	    currencyRateDTO.setAmount(currencyRateParser.getRate(
		    dateConverter.convertDate()));
	}
	CurrencyRate currencyRate = currencyRateMapper.toEntity(currencyRateDTO);
	RealEstateAdminUser redAdmin = (RealEstateAdminUser) 
			userService.loadUserByEmail(email);
	currencyRate.setReAgency(redAdmin.getAgency());
	updateCurrencyDatePeriods(email, currencyRate);
	deleteCurrencyDatePeriods(email, currencyRate);
	currencyRateDao.save(currencyRate);
    }

    /**
     * 
     * @param currencyRateDTO
     *            object
     */
    public void update(final CurrencyRateDTO currencyRateDTO) {
	CurrencyRate currencyRate = currencyRateMapper.toEntity(currencyRateDTO);
	currencyRateDao.update(currencyRate);
    }

    /**
     * 
     * @param currencyRateDTO
     *            object
     */
    public void delete(final CurrencyRateDTO currencyRateDTO) {
	CurrencyRate currencyRate = currencyRateMapper.toEntity(currencyRateDTO);
	currencyRateDao.remove(currencyRate);
    }

    /**
     * 
     * @param fromDate
     *            parameter
     * @return object of currencyRate
     */
    public CurrencyRate findCurrencyByFromDate(final Date fromDate) {
	return currencyRateDao.findCurrencyFromDate(fromDate);
    };
    
    /**
     * load all currencies.
     * @param predicate predicate
     * @return List<CurrencyRateDTO>
     */
    public List<CurrencyRateDTO> loadAllCurrencies(
	    	final DataTablePredicate predicate) {
	ArrayList<CurrencyRateDTO> currencyListDto = 
		new ArrayList<CurrencyRateDTO>();
	for (CurrencyRate currency : currencyRateDao.findAll(predicate)) {
	    currencyListDto.add(currencyRateMapper.toDto(currency));
	}
	return currencyListDto;
    }
    
    /**
     * @param predicate predicate
     * @param email of RedAdmin.
     * @return list of currencyRates
     */
    public List<CurrencyRateDTO> loadAllCurrenciesByCompany(
	    final String email, final DataTablePredicate predicate) {
	RealEstateAdminUser redAdmin = (RealEstateAdminUser) 
			userService.loadUserByEmail(email);
	ArrayList<CurrencyRateDTO> currencyListDto = 
		new ArrayList<CurrencyRateDTO>();
	for (CurrencyRate currency : currencyRateDao
		.findAllCurrenciesByCompany(redAdmin.getAgency(), predicate)) {
	    currencyListDto.add(currencyRateMapper.toDto(currency));
	}
	return currencyListDto;
    }
    
    /**
     * 
     * @return number of currencies
     */
    public long countAll() {
	return currencyRateDao.countAll();
    }
    
    /**
     * @param predicate predicate
     * @return number of currencies
     */
    public long countAll(final DataTablePredicate predicate) {
	return currencyRateDao.countAll(predicate);
    }
    
    /**
     * 
     * @param email of RedAdmin.
     * @return number of company currencies
     */
    public long countAllCompanyCurrencies(final String email) {
	RealEstateAdminUser redAdmin = (RealEstateAdminUser) 
			userService.loadUserByEmail(email);
	return currencyRateDao.countAllCompanyCurrencies(redAdmin.getAgency());
    }
    
    /**
     * @param predicate predicate
     * @param email of RedAdmin.
     * @return number of company currencies
     */
    public long countAllCompanyCurrencies(final String email, 
	    final DataTablePredicate predicate) {
	RealEstateAdminUser redAdmin = (RealEstateAdminUser) 
			userService.loadUserByEmail(email);
	return currencyRateDao.countAllCompanyCurrencies(redAdmin.getAgency(),
		predicate);
    }
    
    /**
     * 
     * @param email Real admin estate email
     * @param currencyRate currencyRate
     */
    public void updateCurrencyDatePeriods(final String email,
	    final CurrencyRate currencyRate) {
	RealEstateAgency agency = redAdminDao.findAgencyByEmail(email);
	ArrayList<CurrencyRate> currencyList = (ArrayList<CurrencyRate>)
		currencyRateDao.findAllCurrenciesByCompany(agency);
	for (CurrencyRate currency : currencyList) {
	    if ((currency.getFromDate().getTime() 
		    >= currencyRate.getFromDate().getTime()) 
		    && (currency.getToDate().getTime() 
		    > currencyRate.getToDate().getTime()
		    && (currency.getFromDate().getTime() 
		    <= currencyRate.getToDate().getTime()))) {
		if ((currencyRate.getToDate().getTime() + ONEDAYINMILLIS) 
			>= currency.getToDate().getTime()) {
		    currencyRateDao.remove(currency);
		} else {
		    currency.setFromDate(new Date(currencyRate.getToDate().getTime()
				+ ONEDAYINMILLIS));
		    currencyRateDao.update(currency);   
		}
	    }
	    if ((currency.getFromDate().getTime() 
		    < currencyRate.getFromDate().getTime()) 
		    && (currency.getToDate().getTime() 
		    <= currencyRate.getToDate().getTime())
		    && (currency.getToDate().getTime() 
		    >= currencyRate.getFromDate().getTime())) {
		if ((currencyRate.getFromDate().getTime() - ONEDAYINMILLIS) 
			<= currency.getFromDate().getTime()) {
		    currencyRateDao.remove(currency);
		} else {
		    currency.setToDate(new Date(currencyRate.getFromDate().getTime()
			- ONEDAYINMILLIS));
		    currencyRateDao.update(currency);   
		}
	    }
	    if ((currency.getFromDate().getTime() 
		    < currencyRate.getFromDate().getTime()) 
		    && (currency.getToDate().getTime() 
		    > currencyRate.getToDate().getTime())) {
		if ((currencyRate.getToDate().getTime() + ONEDAYINMILLIS) 
			>= currency.getToDate().getTime()) {
		    currencyRateDao.remove(currency);
		} else {
		    currency.setFromDate(new Date(currencyRate.getToDate().getTime()
			+ ONEDAYINMILLIS));
		    currencyRateDao.update(currency);   
		}
	    }
	}	
    }
    
    /**
     * 
     * @param email email
     * @param currencyRate object
     */
    public void deleteCurrencyDatePeriods(final String email,
	    final CurrencyRate currencyRate) {
	RealEstateAgency agency = redAdminDao.findAgencyByEmail(email);
	ArrayList<CurrencyRate> currencyList = (ArrayList<CurrencyRate>)
		currencyRateDao.findAllCurrenciesByCompany(agency);
	for (CurrencyRate currency : currencyList) {
	    if ((currency.getFromDate().getTime() 
		    == currencyRate.getFromDate().getTime()) 
		    && (currency.getToDate().getTime() 
		    == (currencyRate.getToDate().getTime()))) {
		currencyRateDao.remove(currency);
	    }
	    if ((currency.getFromDate().getTime() 
		    > currencyRate.getFromDate().getTime()) 
		    && (currency.getToDate().getTime() 
		    < currencyRate.getToDate().getTime())) {
		currencyRateDao.remove(currency);
	    }
	    if ((currency.getFromDate().getTime() 
		    == currencyRate.getFromDate().getTime()) 
		    && (currency.getToDate().getTime() 
		    < currencyRate.getToDate().getTime())) {
		currencyRateDao.remove(currency);
	    }
	    if ((currency.getFromDate().getTime() 
		    > currencyRate.getFromDate().getTime()) 
		    && (currency.getToDate().getTime() 
		    == currencyRate.getToDate().getTime())) {
		currencyRateDao.remove(currency);
	    } 
	}
    }
    
    /**
     * 
     * @param email redadmin email
     * @return current currency rate
     */
    public CurrencyRate findTodayCurrencyByCompany(final String email) {
	for (CurrencyRate currency : currencyRateDao
		.findAllCurrenciesByCompany(redAdminDao.findAgencyByEmail(email))) {
	 if ((currency.getFromDate().getTime() 
		 <= new Date().getTime())
		 && (currency.getToDate().getTime()
		 >= new Date().getTime())) {
	     return currency;
	 }   
	}
	return null;
    }
}