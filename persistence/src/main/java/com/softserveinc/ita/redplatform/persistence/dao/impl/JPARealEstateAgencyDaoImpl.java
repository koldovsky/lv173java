package com.softserveinc.ita.redplatform.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.redplatform.common.entity.RealEstateAgency;
import com.softserveinc.ita.redplatform.persistence.dao.RealEstateAgencyDao;

/**
 * Implementation for RealEstateAgency Dao.
 * 
 * @author Oleh Khimka
 */
@Repository
public class JPARealEstateAgencyDaoImpl 
				extends GenericDaoImpl<RealEstateAgency, Long> 
	implements RealEstateAgencyDao {

}
