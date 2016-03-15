package com.softserveinc.ita.redplatform.common.mapper;



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

    @Override
    public final PaymentDTO toDto(final Payment entity) {
	PaymentDTO dto = new PaymentDTO();
	dto.setAmount(entity.getAmount());
	dto.setOrder(entity.getOrder());
	dto.setCurrencyRate(entity.getCurrencyRate());
	dto.setPicturePath(entity.getPicturePath());
	dto.setCreatedDate(entity.getCreatedDate());
	return dto;
    }

    @Override
    public final Payment toEntity(final PaymentDTO dto) {
	Payment entity = new Payment();
	entity.setAmount(dto.getAmount());
	entity.setCurrencyRate(dto.getCurrencyRate());
	entity.setOrder(dto.getOrder());
	return entity;
    }
}
