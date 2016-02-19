package com.softserveinc.ita.redplatform.common.mapper;

import org.springframework.stereotype.Component;

import com.softserveinc.ita.redplatform.common.dto.RealEstateAdminUserDTO;
import com.softserveinc.ita.redplatform.common.entity.RealEstateAdminUser;
import com.softserveinc.ita.redplatform.common.entity.RealEstateAgency;

/**
 * The class RealEstateAdminUserMapper.
 * 
 * @author Ilona Yavorska
 */
@Component
public class RealEstateAdminUserMapper 
implements GenericMapper<RealEstateAdminUser, RealEstateAdminUserDTO> {
    @Override
    public final RealEstateAdminUserDTO toDto(final RealEstateAdminUser admin) {
	RealEstateAdminUserDTO dto = new RealEstateAdminUserDTO();
	dto.setId(admin.getId());
	dto.setFirstName(admin.getFirstName());
	dto.setLastName(admin.getLastName());
	dto.setEmail(admin.getEmail());
	dto.setPhone(admin.getPhone());
	dto.setAgencyId(admin.getAgency().getId());
	return dto;
    }

    @Override
    public final RealEstateAdminUser toEntity(
	    final RealEstateAdminUserDTO dto) {
	RealEstateAdminUser admin = new RealEstateAdminUser();
	admin.setId(dto.getId());
	admin.setFirstName(dto.getFirstName());
	admin.setLastName(dto.getLastName());
	admin.setEmail(dto.getEmail());
	admin.setPhone(dto.getPhone());
	RealEstateAgency agency = new RealEstateAgency();
	agency.setId(dto.getAgencyId());
	admin.setAgency(agency);
	return admin;
    }
}
