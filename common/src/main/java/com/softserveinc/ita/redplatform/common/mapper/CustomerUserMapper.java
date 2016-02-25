package com.softserveinc.ita.redplatform.common.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.softserveinc.ita.redplatform.common.dto.CustomerUserDTO;
import com.softserveinc.ita.redplatform.common.entity.CustomerUser;

/**
 * Mapper for CustomerUser DTO and entity.
 * 
 * @author Ivaniv Roman.
 * 
 */
@Component
public class CustomerUserMapper implements 
	GenericMapper<CustomerUser, CustomerUserDTO> {
	
    /**
     * Address mapper for conversion between DTO and entity.
     */
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public final CustomerUserDTO toDto(final CustomerUser customerUser) {
	CustomerUserDTO customerUserDTO = new CustomerUserDTO();
	customerUserDTO.setFirstName(customerUser.getFirstName());
	customerUserDTO.setLastName(customerUser.getLastName());
	customerUserDTO.setEmail(customerUser.getEmail());
	customerUserDTO.setCreatedDate(customerUser.getCreatedDate());
	customerUserDTO.setPhone(customerUser.getPhone());
	customerUserDTO.setPassport(customerUser.getPassport());
	customerUserDTO.setIndividualTaxNumber(
		customerUser.getIndividualTaxNumber());
	customerUserDTO.setId(customerUser.getId());
	customerUserDTO.setAddress(addressMapper.toDto(customerUser.getAddress()));
	return customerUserDTO;
    }

    @Override
    public final CustomerUser toEntity(final CustomerUserDTO customerUserDTO) {
	CustomerUser customerUser = new CustomerUser();
	customerUser.setFirstName(customerUserDTO.getFirstName());
	customerUser.setLastName(customerUserDTO.getLastName());
	customerUser.setEmail(customerUserDTO.getEmail());
	customerUser.setCreatedDate(customerUserDTO.getCreatedDate());
	customerUser.setPhone(customerUserDTO.getPhone());
	customerUser.setPassport(customerUserDTO.getPassport());
	customerUser.setIndividualTaxNumber(
		customerUserDTO.getIndividualTaxNumber());
	customerUser.setId(customerUserDTO.getId());
	customerUser.setAddress(
			addressMapper.toEntity(customerUserDTO.getAddress()));
	return customerUser;
    }

}
