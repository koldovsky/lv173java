/*
 * 
 */
package com.softserveinc.ita.redplatform.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.redplatform.common.entity.Payment;
import com.softserveinc.ita.redplatform.persistence.dao.PaymentDao;

/**
 * Implementation of PaymentDao.
 * 
 * @author Hryhorii Somyk
 * @author Ilona Yavorska
 *
 */
@Repository
public class JPAPaymentDao extends JPAGenericDao<Payment, Long>
	implements PaymentDao {

    @Override
    public final double getPaidAmount(final Long orderId) {
	String query = "select sum(payment.amount) from "
		+ Payment.class.getName()
		+ " as payment where payment.order.id=" + orderId;
	Object result = getEntityManager().createQuery(query).getSingleResult();
	if (result == null) {
	    return 0;
	}
	return (double) result;
    }
}
