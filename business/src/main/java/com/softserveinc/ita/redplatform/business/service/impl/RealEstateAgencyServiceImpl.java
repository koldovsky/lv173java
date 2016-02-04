package com.softserveinc.ita.redplatform.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.redplatform.business.service.RealEstateAgencyService;
import com.softserveinc.ita.redplatform.common.dto.RealEstateAgencyDTO;
import com.softserveinc.ita.redplatform.common.entity.RealEstateAgency;
import com.softserveinc.ita.redplatform.common.mapper.RealEstateAgencyMapper;
import com.softserveinc.ita.redplatform.persistence.dao.RealEstateAgencyDao;


@Service
public class RealEstateAgencyServiceImpl implements RealEstateAgencyService {
    
    @Autowired
    private RealEstateAgencyDao realEstateAgencyDao;
    
    @Autowired
    private RealEstateAgencyMapper realEstateAgencyMapper;

    @Override
    public void create(RealEstateAgencyDTO realEstateAgencyDTO) {
	RealEstateAgency realEstateAgency = realEstateAgencyMapper.toEntity(realEstateAgencyDTO);
	realEstateAgencyDao.save(realEstateAgency);
    }
    
    
    
}
