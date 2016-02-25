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
import com.softserveinc.ita.redplatform.common.mapper.OrderMapper;
import com.softserveinc.ita.redplatform.persistence.dao.CustomerUserDao;
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

    /** The customer user dao. */
    @Autowired
    private CustomerUserDao customerUserDao;

    /** The mapper. */
    @Autowired
    private InstallmentMapper installmentMapper;

    /** The mapper. */
    @Autowired
    private OrderMapper orderMapper;

    /**
     * Adds the installment.
     *
     * @param dtos
     *            the dtos
     * @throws ParseException
     *             the parse exception
     */
    @Transactional
    public void addInstallment(final List<InstallmentDTO> dtos) 
	    throws ParseException {
	Installment installment = null;
	Order order = new Order();
	order.setCustomerUser(customerUserDao
		.findById(dtos.get(0).getCustomerId()));
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	Date date = null;
	for (InstallmentDTO dto : dtos) {
	    installment = installmentMapper.toEntity(dto);
	    date = formatter.parse(dto.getDate());
	    installment.setDate(date);
	    installment.setOrder(order);
	    installmentDao.save(installment);
	}
    }
}
