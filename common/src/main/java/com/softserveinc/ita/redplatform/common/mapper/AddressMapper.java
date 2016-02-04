package com.softserveinc.ita.redplatform.common.mapper;

import org.springframework.stereotype.Component;

import com.softserveinc.ita.redplatform.common.dto.AddressDTO;
import com.softserveinc.ita.redplatform.common.entity.Address;

/**
 * Address mapper for conversion between DTO and entity.
 * @author oleh
 *
 */
@Component
public class AddressMapper implements GenericMapper<Address, AddressDTO> {

    /**
     * convert to DTO.
     */
    @Override
    public final AddressDTO toDto(final Address entity) {
	AddressDTO dto = new AddressDTO();
	
	dto.setCountry(entity.getCountry());
	dto.setRegion(entity.getRegion());
	dto.setPostalCode(entity.getPostalCode());
	dto.setLocality(entity.getLocality());
	dto.setAdditional(entity.getAdditional());
	
	return dto;
    }

    /**
     * convert to entity.
     */
    @Override
    public final Address toEntity(final AddressDTO dto) {
	Address entity = new Address();
	
        entity.setCountry(dto.getCountry());
        entity.setRegion(dto.getRegion());
        entity.setPostalCode(dto.getPostalCode());
        entity.setLocality(dto.getLocality());
        entity.setAdditional(dto.getAdditional());
	
	return entity;
    }

}
