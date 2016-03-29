package com.softserveinc.ita.redplatform.common.mapper;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.softserveinc.ita.redplatform.common.dto.PaymentDTO;
import com.softserveinc.ita.redplatform.common.entity.Payment;

/**
 * The class PaymentMapper.
 * 
 * @author Bulhakov Alex
 */
@Component
public class PaymentMapper 
	implements GenericMapper<Payment, PaymentDTO> {
	
	/** 
	 * Currency rate mapper.
	 */
	@Autowired
	private CurrencyRateMapper currencyRateMapper;

    @Override
    public final PaymentDTO toDto(final Payment entity) {
	PaymentDTO dto = new PaymentDTO();
	dto.setAmount(entity.getAmount());
	dto.setCurrencyRate(currencyRateMapper.toDto(entity.getCurrencyRate()));
	dto.setPicturePath(entity.getPicturePath());
	dto.setCreatedDate(entity.getCreatedDate());
	return dto;
    }

    @Override
    public final Payment toEntity(final PaymentDTO dto) {
	Payment entity = new Payment();
	entity.setAmount(dto.getAmount());
	entity.setCurrencyRate(currencyRateMapper.toEntity(dto.getCurrencyRate()));
	entity.setOrder(dto.getOrder());
	entity.setDate(new Date(dto.getDate()));
	return entity;
    }
}
