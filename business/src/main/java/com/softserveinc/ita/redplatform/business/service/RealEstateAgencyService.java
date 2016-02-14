package com.softserveinc.ita.redplatform.business.service;

import java.util.ArrayList;
import java.util.List;

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
   
    public void create(final RealEstateAgencyDTO realEstateAgencyDTO) {
		
	RealEstateAgency realEstateAgency = realEstateAgencyMapper
					.toEntity(realEstateAgencyDTO);
	realEstateAgencyDao.save(realEstateAgency);
    }
    
    /**
     * update realEstateAgency.
     * @param realEstateAgencyDTO realEstateAgencyDTO
     */
   
    public void update(final RealEstateAgencyDTO realEstateAgencyDTO) {
		
	RealEstateAgency realEstateAgency = realEstateAgencyMapper
					.toEntity(realEstateAgencyDTO);
	realEstateAgencyDao.update(realEstateAgency);
    }

    /**
     * Retrieves id and name info about 
     * all agencies already registered in the system.
     *
     * @author Ilona Yavorska
     * @return the list of RealEstateAgency entities.
     */
    public List<RealEstateAgencyDTO> retrieveAllIdName() {
    	List<RealEstateAgency> agencies = realEstateAgencyDao.findAll();
    	List<RealEstateAgencyDTO> dtos = new ArrayList<>();
    	for (RealEstateAgency agency : agencies) {
    		RealEstateAgencyDTO dto = new RealEstateAgencyDTO();
    		dto.setId(agency.getId());
    		dto.setName(agency.getName());
    		dtos.add(dto);
    	}
    	return dtos;
    }
    
    /**
     * Gets the agency by id.
     *
     * @author Ilona Yavorska
     * @param id the id
     * @return the RealEstateAgency entity
     */
    public RealEstateAgencyDTO getById(final String id) {
    	RealEstateAgency agency = realEstateAgencyDao
    			.findById(Long.parseLong(id));
    	return realEstateAgencyMapper.toDto(agency);
    }
    
    /**
     * Gets the agency by id.
     *
     * @author Ilona Yavorska
     * @param id the id
     * @return the RealEstateAgency entity
     */
    public RealEstateAgencyDTO getById(final long id) {
    	RealEstateAgency agency = realEstateAgencyDao
    			.findById(id);
    	if (agency == null) {
            return null;
        }
    	return realEstateAgencyMapper.toDto(agency);
    }
    
}
