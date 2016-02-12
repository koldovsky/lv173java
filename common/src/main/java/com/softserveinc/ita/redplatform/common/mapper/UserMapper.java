package com.softserveinc.ita.redplatform.common.mapper;

import org.springframework.stereotype.Component;

import com.softserveinc.ita.redplatform.common.dto.UserDTO;
import com.softserveinc.ita.redplatform.common.entity.AdminUser;
import com.softserveinc.ita.redplatform.common.entity.CustomerUser;
import com.softserveinc.ita.redplatform.common.entity.RealEstateAdminUser;
import com.softserveinc.ita.redplatform.common.entity.User;

/**
 * Mapper for User class.
 * 
 * @author Hryhorii Somyk
 *
 */

@Component(value = "userMapper")
public class UserMapper implements GenericMapper<User, UserDTO> {

	/**
	 * Convert User to UserDTO.
	 */
	@Override
	public final UserDTO toDto(final User entity) {

		UserDTO userDTO = new UserDTO();
		if (entity instanceof AdminUser) {
			userDTO.setName("admin");
			userDTO.setCreatedDate(entity.getCreatedDate());
			userDTO.setEmail(entity.getEmail());
			userDTO.setPhone("none");
			userDTO.setCompanyName("SYSTEM");
			return userDTO;
		} else if (entity instanceof RealEstateAdminUser) {
			userDTO.setName(
					((RealEstateAdminUser) entity).getFirstName() + " "
			+ ((RealEstateAdminUser) entity).getLastName());
			userDTO.setCreatedDate(entity.getCreatedDate());
			userDTO.setEmail(entity.getEmail());
			userDTO.setPhone(((RealEstateAdminUser) entity).getPhone());
			userDTO.setCompanyName(((RealEstateAdminUser) entity)
					.getAgency().getName());
			return userDTO;
		} else if (entity instanceof CustomerUser) {
			userDTO.setName(
					((CustomerUser) entity).getFirstName() + " "
			+ ((CustomerUser) entity).getLastName());
			userDTO.setCreatedDate(entity.getCreatedDate());
			userDTO.setEmail(entity.getEmail());
			userDTO.setPhone(((CustomerUser) entity).getPhone());
			RealEstateAdminUser creator = 
					(RealEstateAdminUser) entity.getCreatedBy();
			userDTO.setCompanyName(creator.getAgency().getName());
			return userDTO;
		}

		return null;
	}

	@Override
	public final User toEntity(final UserDTO dto) {
		return new CustomerUser();
	}

}
