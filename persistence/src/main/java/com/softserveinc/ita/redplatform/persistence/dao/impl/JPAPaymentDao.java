package com.softserveinc.ita.redplatform.persistence.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.redplatform.common.entity.Payment;
import com.softserveinc.ita.redplatform.persistence.dao.PaymentDao;
/**
 * Implementation of PaymentDao.
 * 
 * @author Hryhorii Somyk
 *
 */
@Repository
public class JPAPaymentDao extends JPAGenericDao<Payment, Long>
		implements PaymentDao {
	
	/**
	 * Method return all payments by order id.
	 * 
	 * @param id
	 *            order id
	 * @return list of payments
	 */
	@Override
	public final List<Payment> getPaymentsByOrderId(final Long id) {
		return (List<Payment>) getEntityManager()
				.createQuery("select payment from " + Payment.class.getName()
						+ " as payment where payment.order.id =:id")
				.setParameter("id", id).getResultList();
	}

}
