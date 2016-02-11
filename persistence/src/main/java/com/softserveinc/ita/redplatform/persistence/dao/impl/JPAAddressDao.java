package com.softserveinc.ita.redplatform.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.redplatform.common.entity.Address;
import com.softserveinc.ita.redplatform.persistence.dao.AddressDao;

/**
 * Address dao implementation.
 * @author oleh
 *
 */
@Repository("addressDao")
public class JPAAddressDao extends JPAGenericDao<Address, Long> 
			implements AddressDao {

}
