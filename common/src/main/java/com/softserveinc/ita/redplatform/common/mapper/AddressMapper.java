package com.softserveinc.ita.redplatform.common.mapper;

import com.softserveinc.ita.redplatform.common.dto.AddressDTO;
import com.softserveinc.ita.redplatform.common.entity.Address;

public class AddressMapper implements GenericMapper<Address, AddressDTO> {

    @Override
    public AddressDTO toDto(Address entity) {
	AddressDTO dto = new AddressDTO();
	
	dto.setCountry(entity.getCountry());
	dto.setRegion(entity.getRegion());
	dto.setPostalCode(entity.getPostalCode());
	dto.setLocality(entity.getLocality());
	dto.setAdditional(entity.getAdditional());
	
	return dto;
    }

    @Override
    public Address toEntity(AddressDTO dto) {
	Address entity = new Address();
	
        entity.setCountry(dto.getCountry());
        entity.setRegion(dto.getRegion());
        entity.setPostalCode(dto.getPostalCode());
        entity.setLocality(dto.getLocality());
        entity.setAdditional(dto.getAdditional());
	
	return entity;
    }

}
