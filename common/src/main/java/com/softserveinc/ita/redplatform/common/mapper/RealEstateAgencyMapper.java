package com.softserveinc.ita.redplatform.common.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import com.softserveinc.ita.redplatform.common.dto.RealEstateAgencyDTO;
import com.softserveinc.ita.redplatform.common.entity.RealEstateAgency;

/**
 * Mapper for RealEstateAgency DTO and entity.
 * 
 * @author Oleh Khimka.
 *         
 */
public class RealEstateAgencyMapper 
			implements GenericMapper<RealEstateAgency, RealEstateAgencyDTO> {
    
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public final RealEstateAgencyDTO toDto(final RealEstateAgency realEstateAgency) {
	RealEstateAgencyDTO realEstateAgencyDTO = new RealEstateAgencyDTO();
	realEstateAgencyDTO.setName(realEstateAgency.getName());
	realEstateAgencyDTO.setDescription(realEstateAgency.getDescription());
	realEstateAgencyDTO.setPhone(realEstateAgency.getPhone());
	realEstateAgencyDTO.setSite(realEstateAgency.getSite());
	
	realEstateAgencyDTO.setAddress(addressMapper.toDto(realEstateAgency.getAddress()));
	
	return realEstateAgencyDTO;
    }

    @Override
    public final RealEstateAgency 
    				toEntity(final RealEstateAgencyDTO realEstateAgencyDTO) {
	RealEstateAgency realEstateAgency = new RealEstateAgency();
	realEstateAgency.setName(realEstateAgencyDTO.getName());
	realEstateAgency.setDescription(realEstateAgencyDTO.getDescription());
	realEstateAgency.setPhone(realEstateAgencyDTO.getPhone());
	realEstateAgency.setSite(realEstateAgencyDTO.getSite());
	
	realEstateAgency.setAddress(addressMapper.toEntity(realEstateAgencyDTO.getAddress()));
	
	return realEstateAgency;
    }

}
