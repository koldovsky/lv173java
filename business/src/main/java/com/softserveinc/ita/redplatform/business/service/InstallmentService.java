package com.softserveinc.ita.redplatform.business.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.redplatform.common.dto.InstallmentDTO;
import com.softserveinc.ita.redplatform.common.entity.Installment;
import com.softserveinc.ita.redplatform.common.entity.Order;
import com.softserveinc.ita.redplatform.common.mapper.InstallmentMapper;
import com.softserveinc.ita.redplatform.persistence.dao.InstallmentDao;
import com.softserveinc.ita.redplatform.persistence.dao.OrderDao;

/**
 * The class InstallmentService.
 * 
 * @author Ilona Yavorska
 */
@Service
public class InstallmentService {

    /** The installment dao. */
    @Autowired
    private InstallmentDao installmentDao;

    /** The order dao. */
    @Autowired
    private OrderDao orderDao;

    /** The mapper. */
    @Autowired
    private InstallmentMapper installmentMapper;

    /**
     * Adds the installment.
     *
     * @param installmentList the installment list
     * @param orderId the order id
     * @throws ParseException the parse exception
     */
    @Transactional
    public void addInstallment(final List<InstallmentDTO> installmentList, 
	    final Long orderId) throws ParseException {
	Installment installment = null;
	Order order = null;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	Date date = null;
	for (InstallmentDTO dto : installmentList) {	    
	    installment = installmentMapper.toEntity(dto);
	    date = formatter.parse(dto.getDate());
	    installment.setDate(date);
	    order = orderDao.findById(orderId);
	    installment.setOrder(order);
	    installmentDao.save(installment);
	}
    }
}
