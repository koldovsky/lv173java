package com.softserveinc.ita.redplatform.common.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.softserveinc.ita.redplatform.common.dto.RealEstateAgencyDTO;
import com.softserveinc.ita.redplatform.common.entity.RealEstateAgency;

/**
 * Mapper for RealEstateAgency DTO and entity.
 * 
 * @author Oleh Khimka.
 * 
 */
@Component(value = "realEstateAgencyMapper")
public class RealEstateAgencyMapper 
	implements GenericMapper<RealEstateAgency, RealEstateAgencyDTO> {

    /**
     * Address mapper for conversion between DTO and entity.
     */
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public final RealEstateAgencyDTO toDto(
	    			final RealEstateAgency realEstateAgency) {
	
	RealEstateAgencyDTO realEstateAgencyDTO = new RealEstateAgencyDTO();
	realEstateAgencyDTO.setId(realEstateAgency.getId());
	realEstateAgencyDTO.setName(realEstateAgency.getName());
	realEstateAgencyDTO.setDescription(realEstateAgency.getDescription());
	realEstateAgencyDTO.setPhone(realEstateAgency.getPhone());
	realEstateAgencyDTO.setSite(realEstateAgency.getSite());

	realEstateAgencyDTO.setAddress(
			addressMapper.toDto(realEstateAgency.getAddress())
		);

	return realEstateAgencyDTO;
    }
    
    /**
     * Transforms RED agency entity into dto 
     * that contains only id and name info.
     *
     * @param realEstateAgency the RED agency
     * @return the dto
     */
    public final RealEstateAgencyDTO toIdNameDto(
	    			final RealEstateAgency realEstateAgency) {
	RealEstateAgencyDTO realEstateAgencyDTO = new RealEstateAgencyDTO();
	realEstateAgencyDTO.setId(realEstateAgency.getId());
	realEstateAgencyDTO.setName(realEstateAgency.getName());
	return realEstateAgencyDTO;
    }
    

    @Override
    public final RealEstateAgency toEntity(
	    	final RealEstateAgencyDTO realEstateAgencyDTO) {
	
	RealEstateAgency realEstateAgency = new RealEstateAgency();
	realEstateAgency.setId(realEstateAgencyDTO.getId());
	realEstateAgency.setName(realEstateAgencyDTO.getName());
	realEstateAgency.setDescription(realEstateAgencyDTO.getDescription());
	realEstateAgency.setPhone(realEstateAgencyDTO.getPhone());
	realEstateAgency.setSite(realEstateAgencyDTO.getSite());

	realEstateAgency.setAddress(
		addressMapper.toEntity(realEstateAgencyDTO.getAddress())
	);

	return realEstateAgency;
    }

}
