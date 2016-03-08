package com.softserveinc.ita.redplatform.business.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.redplatform.common.dto.InstallmentDTO;
import com.softserveinc.ita.redplatform.common.entity.Installment;
import com.softserveinc.ita.redplatform.common.entity.Order;
import com.softserveinc.ita.redplatform.common.mapper.InstallmentMapper;

/**
 * The class InstallmentService.
 * 
 * @author Ilona Yavorska
 */
@Service
public class InstallmentService {

    /** The mapper. */
    @Autowired
    private InstallmentMapper installmentMapper;
    
    /**
     * Prepare installment list for order.
     *
     * @param dtos the list of installment DTOs
     * @param order the order
     * @return the list of installments
     */
    public List<Installment> 
    	prepareInstallments(final List<InstallmentDTO> dtos,
	    final Order order) {
	List<Installment> installments = new LinkedList<>();
	Installment installment = null;
	for (InstallmentDTO dto : dtos) {
	    installment = installmentMapper.toEntity(dto);
	    installment.setOrder(order);
	    installments.add(installment);
	}
	return installments;
    }
}
