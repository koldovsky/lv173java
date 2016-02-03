package com.softserveinc.ita.redplatform.common.mapper;

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

    @Override
    public final RealEstateAgencyDTO toDto(final RealEstateAgency agency) {
	RealEstateAgencyDTO realEstateAgencyDTO = new RealEstateAgencyDTO();
	realEstateAgencyDTO.setName(agency.getName());
	realEstateAgencyDTO.setDescription(agency.getDescription());
	realEstateAgencyDTO.setPhone(agency.getPhone());
	realEstateAgencyDTO.setSite(agency.getSite());
	realEstateAgencyDTO.setAddress(agency.getAddress());
	return realEstateAgencyDTO;
    }

    @Override
    public final RealEstateAgency 
    				toEntity(final RealEstateAgencyDTO agencyDTO) {
	RealEstateAgency realEstateAgency = new RealEstateAgency();
	realEstateAgency.setName(agencyDTO.getName());
	realEstateAgency.setDescription(agencyDTO.getDescription());
	realEstateAgency.setPhone(agencyDTO.getPhone());
	realEstateAgency.setSite(agencyDTO.getSite());
	realEstateAgency.setAddress(agencyDTO.getAddress());
	return realEstateAgency;
    }

}
