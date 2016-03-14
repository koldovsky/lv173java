package com.softserveinc.ita.redplatform.common.mapper;

import org.springframework.stereotype.Component;

import com.softserveinc.ita.redplatform.common.dto.PaymentDTO;
import com.softserveinc.ita.redplatform.common.entity.Payment;

/**
 * Payment Mapper.
 * 
 * @author Hryhorii
 *
 */
@Component
public class PaymentMapper implements GenericMapper<Payment, PaymentDTO> {

	@Override
	public final PaymentDTO toDto(final Payment entity) {
		PaymentDTO paymentDTO = new PaymentDTO();
		paymentDTO.setAmount(entity.getAmount());
		paymentDTO.setState(entity.getState());
		paymentDTO.setCreatedDate(entity.getCreatedDate());
		return paymentDTO;
	}

	@Override
	public final Payment toEntity(final PaymentDTO dto) {
		Payment payment = new Payment();
		payment.setAmount(dto.getAmount());
		payment.setState(dto.getState());
		return payment;
	}
	

}
