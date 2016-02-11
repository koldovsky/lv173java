package com.softserveinc.ita.redplatform.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.redplatform.common.entity.RealEstateAgency;
import com.softserveinc.ita.redplatform.persistence.dao.RealEstateAgencyDao;

/**
 * Implementation for RealEstateAgency Dao.
 * 
 * @author Oleh Khimka
 */
@Repository("realEstateAgencyDao")
public class JPARealEstateAgencyDao 
				extends JPAGenericDao<RealEstateAgency, Long> 
	implements RealEstateAgencyDao {

}
