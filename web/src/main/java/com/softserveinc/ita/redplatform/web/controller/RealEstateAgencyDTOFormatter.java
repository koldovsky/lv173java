package com.softserveinc.ita.redplatform.web.controller;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.softserveinc.ita.redplatform.business.service
									.RealEstateAgencyService;
import com.softserveinc.ita.redplatform.common.dto.RealEstateAgencyDTO;

/**
 * The class RealEstateAgencyFormatter.
 * 
 * @author Ilona Yavorska
 */
@Component
public class RealEstateAgencyDTOFormatter 
		implements Formatter<RealEstateAgencyDTO> {
	
	/** The agency service. */
	@Autowired
	private RealEstateAgencyService service;

	@Override
	public final String print(final RealEstateAgencyDTO agencyDto, 
				final Locale locale) {
		return agencyDto.getId().toString();
	}

	@Override
	public final RealEstateAgencyDTO parse(final String agencyId, 
			final Locale locale) throws ParseException {
		RealEstateAgencyDTO agencyDto = new RealEstateAgencyDTO();
		agencyDto = service.getById(agencyId);
		return agencyDto;
	}
	
}
