package com.softserveinc.ita.redplatform.persistence.dao.impl;

import java.util.List;

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

    @Override
    public final RealEstateAgency findAgencyByName(final String name) {
	List agencies = getEntityManager()
		.createQuery("from " + RealEstateAgency.class.getName()
			+ " as agency where agency.name=:name")
		.setParameter("name", name).getResultList();
	return getSingleResult(agencies);
    }

  
}
