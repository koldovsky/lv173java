package com.softserveinc.ita.redplatform.persistence.dao.impl;

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

}
