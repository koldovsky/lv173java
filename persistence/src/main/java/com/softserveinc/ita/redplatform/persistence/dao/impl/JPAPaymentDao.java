package com.softserveinc.ita.redplatform.persistence.dao.impl;

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

}
