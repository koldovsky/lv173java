package com.softserveinc.ita.redplatform.persistence.dao;

import com.softserveinc.ita.redplatform.common.entity.Installment;

/**
 * The interface InstallmentDao.
 * 
 * @author Ilona Yavorska
 */
public interface InstallmentDao extends GenericDao<Installment, Long> {

	/**
	 * Gets the order cost.
	 *
	 * @param newOrderId the order id
	 * @return the order cost
	 */
	double getOrderCost(Long newOrderId);

	/**
	 * Gets the installment amount till now.
	 *
	 * @param newOrderId the order id
	 * @return the installment amount till now
	 */
	double getInstallmentAmountTillNow(Long newOrderId);

}
