package com.softserveinc.ita.redplatform.business.service;

import com.softserveinc.ita.redplatform.common.dto.RealEstateAgencyDTO;
/**
 * Service for work with RealEstateAgency.
 * @author Oleh Khimka
 *
 */
public interface RealEstateAgencyService {
    
    /**
     * create Agency.
     * @param realEstateAgencyDTO 
     */
    void create(RealEstateAgencyDTO realEstateAgencyDTO);

}
