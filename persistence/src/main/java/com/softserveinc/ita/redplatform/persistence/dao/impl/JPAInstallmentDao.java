package com.softserveinc.ita.redplatform.persistence.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.redplatform.common.entity.Installment;
import com.softserveinc.ita.redplatform.persistence.dao.InstallmentDao;

/**
 * The class JPAInstallmentDao.
 * 
 * @author Ilona Yavorska
 */
@Repository
public class JPAInstallmentDao extends JPAGenericDao<Installment, Long>
	implements InstallmentDao {

    @Override
    public final double getOrderCost(final Long orderId) {
	String query = "select sum(installment.amount) from "
		+ Installment.class.getName()
		+ " as installment where installment.order.id=" + orderId;
	return (double) getEntityManager().createQuery(query).getSingleResult();
    }

    @Override
    public final double getInstallmentAmountTillNow(final Long orderId) {
	String query = "select sum(installment.amount) from "
		+ Installment.class.getName()
		+ " as installment where installment.order.id=" + orderId
		+ " and installment.date<current_date";
	Object result = getEntityManager().createQuery(query).getSingleResult();
	if (result == null) {
	    return 0;
	}
	return (double) result;
    }

    @Override
    public final Installment getLastInstallmentTillNow(final Long id) {
	List<Installment> list = (List<Installment>) getEntityManager()
		.createQuery("from " + Installment.class.getName()
			+ " as installment where installment.order.id=:id"
			+ " and installment.date < current_date"
			+ " order by installment.date desc")
		.setParameter("id", id).getResultList();
	return getSingleResult(list);
    }

}
