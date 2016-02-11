package com.softserveinc.ita.redplatform.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.redplatform.common.dto.RealEstateAgencyDTO;
import com.softserveinc.ita.redplatform.common.entity.RealEstateAgency;
import com.softserveinc.ita.redplatform.common.mapper.RealEstateAgencyMapper;
import com.softserveinc.ita.redplatform.persistence.dao.RealEstateAgencyDao;

/**
 * Implementation of Service for RealEstateAgency.
 * @author Oleh Khimka
 *
 */
@Service
@Transactional
public class RealEstateAgencyService {
    
    /** 
     * realEstateAgencyDao for storing to database.
     */
    @Autowired
    private RealEstateAgencyDao realEstateAgencyDao;
    

    /**
     * realEstateAgencyMapper for conversion between DTO and entity.
     */
    @Autowired
    private RealEstateAgencyMapper realEstateAgencyMapper;
    

    /**
     * create realEstateAgency.
     * @param realEstateAgencyDTO realEstateAgencyDTO
     */
    public final void create(final RealEstateAgencyDTO realEstateAgencyDTO) {
		
	RealEstateAgency realEstateAgency = realEstateAgencyMapper
					.toEntity(realEstateAgencyDTO);
	realEstateAgencyDao.save(realEstateAgency);
    }
    
    
    
}
