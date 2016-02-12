package com.softserveinc.ita.redplatform.common.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.softserveinc.ita.redplatform.common.dto.RealEstateAdminUserDTO;
import com.softserveinc.ita.redplatform.common.entity.RealEstateAdminUser;

/**
 * The class RealEstateAdminUserMapper.
 * 
 * @author Ilona Yavorska
 */
@Component
public class RealEstateAdminUserMapper
			implements GenericMapper<RealEstateAdminUser, 
									RealEstateAdminUserDTO> {
	
	/** The agency mapper. */
	@Autowired
	private RealEstateAgencyMapper mapper;

	@Override
	public final RealEstateAdminUserDTO 
	toDto(final RealEstateAdminUser admin) {
		RealEstateAdminUserDTO dto = new RealEstateAdminUserDTO();
		dto.setId(admin.getId());
		dto.setFirstName(admin.getFirstName());
		dto.setLastName(admin.getLastName());
		dto.setEmail(admin.getEmail());
		dto.setPhone(admin.getPhone());
		dto.setAgency(mapper.toDto(admin.getAgency()));
		return dto;
	}

	@Override
	public final RealEstateAdminUser 
	toEntity(final RealEstateAdminUserDTO dto) {
		RealEstateAdminUser admin = new RealEstateAdminUser();
		admin.setId(dto.getId());
		admin.setFirstName(dto.getFirstName());
		admin.setLastName(dto.getLastName());
		admin.setEmail(dto.getEmail());
		admin.setPhone(dto.getPhone());
		admin.setAgency(mapper.toEntity(dto.getAgency()));
		return admin;
	} 
}
