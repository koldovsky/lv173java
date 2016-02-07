package com.softserveinc.ita.redplatform.common.mapper;

import com.softserveinc.ita.redplatform.common.dto.AdminUserDTO;
import com.softserveinc.ita.redplatform.common.entity.AdminUser;

/**
 * Mapper for Admin User and its entity.
 * 
 * @author Bulhakov Alex
 *
 */
public class AdminUserMapper implements GenericMapper<AdminUser, AdminUserDTO> {

    @Override
    public final AdminUserDTO toDto(final AdminUser entity) {
	AdminUserDTO adminUserDTO = new AdminUserDTO();
	adminUserDTO.setEmail(entity.getEmail());
	adminUserDTO.setPassword(entity.getPassword());
	return adminUserDTO;
    }

    @Override
    public final AdminUser toEntity(final AdminUserDTO dto) {
	AdminUser adminUser = new AdminUser();
	adminUser.setEmail(dto.getEmail());
	adminUser.setPassword(dto.getPassword());
	return adminUser;
    }

}
