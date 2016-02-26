package com.softserveinc.ita.redplatform.common.mapper;

import org.springframework.stereotype.Component;

import com.softserveinc.ita.redplatform.common.dto.InstallmentDTO;
import com.softserveinc.ita.redplatform.common.entity.Installment;

/**
 * The class InstallmentMapper.
 * 
 * @author Ilona Yavorska
 */
@Component
public class InstallmentMapper 
	implements GenericMapper<Installment, InstallmentDTO> {
    
    /** The order mapper. */
    private OrderMapper orderMapper;

    @Override
    public final InstallmentDTO toDto(final Installment entity) {
	InstallmentDTO dto = new InstallmentDTO();
	dto.setAmount(entity.getAmount());
	dto.setDate(dto.getDate().toString());
	return dto;
    }

    @Override
    public final Installment toEntity(final InstallmentDTO dto) {
	Installment entity = new Installment();
	entity.setAmount(dto.getAmount());
	return entity;
    }
}
