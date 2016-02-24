package com.softserveinc.ita.redplatform.persistence.dao.impl;

import org.springframework.stereotype.Repository;
import com.softserveinc.ita.redplatform.common.entity.Order;
import com.softserveinc.ita.redplatform.persistence.dao.OrderDao;

/**
 * Implementation of OrderDao.
 * @author Bulhakov Alex
 *
 */
@Repository
public class JPAOrderDao extends JPAGenericDao<Order, Long>
       implements OrderDao {

}