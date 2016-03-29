package com.softserveinc.ita.redplatform.business.service;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.redplatform.common.dto.InstallmentDTO;
import com.softserveinc.ita.redplatform.common.entity.Installment;
import com.softserveinc.ita.redplatform.common.entity.Order;
import com.softserveinc.ita.redplatform.common.mapper.InstallmentMapper;
import com.softserveinc.ita.redplatform.persistence.dao.InstallmentDao;

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

    /** Installment Dao. */
    @Autowired
    private InstallmentDao installmentDao;

    /**
     * Prepare installment list for order.
     *
     * @param dtos
     *            the list of installment DTOs
     * @param order
     *            the order
     * @return the list of installments
     */
    public List<Installment> prepareInstallments(
	    final List<InstallmentDTO> dtos, final Order order) {
	List<Installment> installments = new LinkedList<>();
	Installment installment = null;
	for (InstallmentDTO dto : dtos) {
	    installment = installmentMapper.toEntity(dto);
	    installment.setOrder(order);
	    installments.add(installment);
	}
	return installments;
    }

    /**
     * Method return today date with time 00:00:00.
     * 
     * @return date
     */
    private Date getTodayDate() {
	Calendar calendar = Calendar.getInstance();
	calendar.set(Calendar.HOUR_OF_DAY, 0);
	calendar.clear(Calendar.HOUR);
	calendar.clear(Calendar.MINUTE);
	calendar.clear(Calendar.SECOND);
	calendar.clear(Calendar.MILLISECOND);
	return new Date(calendar.getTimeInMillis());
    }

    /**
     * Method get next installment. If order is already paid return null;
     * 
     * @param order
     *            order
     * @param totalPaidAmount
     *            total paid amount
     * @return next installment
     */
    @Transactional
    public InstallmentDTO getNextInstallment(final Order order,
	    final double totalPaidAmount) {
	Installment installment;
	Date date = getTodayDate();
	double sum = 0;
	Iterator<Installment> iterator = order.getInstallments().iterator();
	do {
	    installment = iterator.next();
	    sum += installment.getAmount();
	} while (iterator.hasNext() && (!date.before(installment.getDate())
		|| sum <= totalPaidAmount));
	double left = sum - totalPaidAmount;
	if (date.after(installment.getDate()) || left <= 0) {
	    return null;
	}
	InstallmentDTO nextInstallment = new InstallmentDTO();
	nextInstallment.setAmount(left);
	nextInstallment.setDate(installment.getDate().getTime());
	return nextInstallment;
    }

    /**
     * Method return missed installment if exists else return null.
     * 
     * @param order
     *            order
     * @param totalPaidAmount
     *            total paid amount
     * @return missed installment
     */
    @Transactional
    public InstallmentDTO getMissedInstallment(final Order order,
	    final double totalPaidAmount) {
	double left = installmentDao.getInstallmentAmountTillNow(order.getId())
		- totalPaidAmount;
	if (left > 0) {
	    InstallmentDTO installmentDTO = new InstallmentDTO();
	    installmentDTO.setDate(
		    installmentDao.getLastInstallmentTillNow(order.getId())
			    .getDate().getTime());
	    installmentDTO.setAmount(left);
	    return installmentDTO;
	}
	return null;
    }

}
