package com.softserveinc.ita.redplatform.persistence.dao;

import com.softserveinc.ita.redplatform.common.entity.RealEstateAgency;

/**
 * Real estate agency dao interface.
 * 
 * @author Oleh Khimka
 */
public interface RealEstateAgencyDao 
				extends GenericDao<RealEstateAgency, Long> {

    /**
     * This method returns RealEstateAgency by name. 
     *
     * @param name the name
     * @return RealEstateAgency
     * 
     * @author Oleh Khimka
     */
    RealEstateAgency findAgencyByName(final String name);
}
