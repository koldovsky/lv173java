package com.softserveinc.ita.redplatform.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
    @Secured("ROLE_ADMIN")
    public void create(final RealEstateAgencyDTO realEstateAgencyDTO) {
		
	RealEstateAgency realEstateAgency = realEstateAgencyMapper
					.toEntity(realEstateAgencyDTO);
	realEstateAgencyDao.save(realEstateAgency);
    }
    
    /**
     * update realEstateAgency.
     * @param realEstateAgencyDTO realEstateAgencyDTO
     */
    @Secured({"ROLE_ADMIN", "ROLE_REDADMIN"})
    public void update(final RealEstateAgencyDTO realEstateAgencyDTO) {
		
	RealEstateAgency realEstateAgency = realEstateAgencyMapper
					.toEntity(realEstateAgencyDTO);
	realEstateAgencyDao.update(realEstateAgency);
    }

    /**
     * Retrieves id and name info about 
     * all RED agencies already registered in the system.
     *
     * @return the list of RED agency entities.
     */
    public List<RealEstateAgencyDTO> retrieveAllIdName() {
    	List<RealEstateAgency> agencies = realEstateAgencyDao.findAll();
    	List<RealEstateAgencyDTO> dtoList = new ArrayList<>();
    	for (RealEstateAgency agency : agencies) {
    		dtoList.add(realEstateAgencyMapper.toIdNameDto(agency));
    	}
    	return dtoList;
    }
    
    /**
     * Gets the agency by id.
     *
     * @param id the id
     * @return the RealEstateAgency entity
     */
    @Secured({"ROLE_ADMIN", "ROLE_REDADMIN"})
    public RealEstateAgencyDTO getById(final long id) {
    	RealEstateAgency agency = realEstateAgencyDao
    			.findById(id);
    	if (agency == null) {
            return null;
        }
    	return realEstateAgencyMapper.toDto(agency);
    }
    
    /**
     * Check if agency exists.
     *
     * @author Oleh Khimka
     * @param name name
     * @return boolean
     */
    public boolean isNameAvailable(final String name) {
	return realEstateAgencyDao.findAgencyByName(name) == null;
    }
    
}
