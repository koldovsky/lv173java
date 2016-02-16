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
		userDTO.setEmail(entity.getEmail());
		userDTO.setCreatedDate(entity.getCreatedDate());
		if (entity instanceof AdminUser) {
			userDTO.setName("admin");
			userDTO.setPhone("none");
			return userDTO;
		} else if (entity instanceof CustomerUser) {
			userDTO.setName(((CustomerUser) entity).getFirstName() 
					+ " " + ((CustomerUser) entity).getLastName());
			userDTO.setPhone(((CustomerUser) entity).getPhone());
			return userDTO;
		} else if (entity instanceof RealEstateAdminUser) {
			userDTO.setName(((RealEstateAdminUser) entity).getFirstName() 
					+ " " + ((RealEstateAdminUser) entity).getLastName());
			userDTO.setPhone(((RealEstateAdminUser) entity).getPhone());
			return userDTO;
		}
		return null;
	}

	@Override
	public final User toEntity(final UserDTO dto) {
		return null;
	}

}
