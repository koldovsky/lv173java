package com.softserveinc.ita.redplatform.common.mapper;

import org.springframework.stereotype.Component;

import com.softserveinc.ita.redplatform.common.dto.CurrencyRateDTO;
import com.softserveinc.ita.redplatform.common.entity.CurrencyRate;

/**
 * Mapper for CurrencyRate DTO and entity.
 * 
 * @author Ivaniv Roman.
 * 
 */
@Component(value = "currencyRateMapper")
public class CurrencyRateMapper implements 
GenericMapper<CurrencyRate, CurrencyRateDTO> {

    @Override
    public final CurrencyRateDTO toDto(final CurrencyRate currencyRate) {
	CurrencyRateDTO currencyRateDTO = new CurrencyRateDTO();
	currencyRateDTO.setAmount(currencyRate.getAmount());
	currencyRateDTO.setCreatedDate(currencyRate.getCreatedDate());
	currencyRateDTO.setFromDate(currencyRate.getFromDate());
	currencyRateDTO.setId(currencyRate.getId());
	currencyRateDTO.setToDate(currencyRate.getToDate());
	return currencyRateDTO;
    }

    @Override
    public final CurrencyRate toEntity(final CurrencyRateDTO currencyRateDTO) {
	CurrencyRate currencyRate = new CurrencyRate();
	currencyRate.setAmount(currencyRateDTO.getAmount());
	currencyRate.setCreatedDate(currencyRateDTO.getCreatedDate());
	currencyRate.setFromDate(currencyRateDTO.getFromDate());
	currencyRate.setId(currencyRateDTO.getId());
	currencyRate.setToDate(currencyRateDTO.getToDate());
	return currencyRate;
    }

}
