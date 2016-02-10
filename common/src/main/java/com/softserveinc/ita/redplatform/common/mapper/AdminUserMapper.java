package com.softserveinc.ita.redplatform.common.mapper;

import org.springframework.stereotype.Component;

import com.softserveinc.ita.redplatform.common.dto.AdminUserDTO;
import com.softserveinc.ita.redplatform.common.entity.AdminUser;

/**
 * Mapper for Admin User and its entity.
 * 
 * @author Bulhakov Alex
 *
 */
@Component
public class AdminUserMapper implements GenericMapper<AdminUser, AdminUserDTO> {

    @Override
    public final AdminUserDTO toDto(final AdminUser entity) {
	AdminUserDTO adminUserDTO = new AdminUserDTO();
	adminUserDTO.setEmail(entity.getEmail());
	return adminUserDTO;
    }

    @Override
    public final AdminUser toEntity(final AdminUserDTO dto) {
	AdminUser adminUser = new AdminUser();
	adminUser.setEmail(dto.getEmail());
	return adminUser;
    }

}
