package com.softserveinc.ita.redplatform.common;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

import com.softserveinc.ita.redplatform.common.dto.AddressDTO;
import com.softserveinc.ita.redplatform.common.dto.RealEstateAgencyDTO;

public class RealEstateAgencyDTOTest {
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	validator = factory.getValidator();
    }

    @Test
    public void testValidAgency() {
	RealEstateAgencyDTO agency = new RealEstateAgencyDTO("test1", "tEst1",
		"+380975649564", "http://vk.com.ua", new AddressDTO("Ukraine",
			"Lviv", "79000", "Lviv", "Shevchenka 12"));

	Set<ConstraintViolation<RealEstateAgencyDTO>> constraintViolations =
		validator.validate(agency);

	assertEquals(0, constraintViolations.size());
    }

    @Test
    public void testNullAddress() {
	RealEstateAgencyDTO agency = new RealEstateAgencyDTO("test1", "tEst1",
		"+380975649564", "http://vk.com", null);

	Set<ConstraintViolation<RealEstateAgencyDTO>> constraintViolations =
		validator.validate(agency);

	assertEquals(1, constraintViolations.size());
    }
    
    @Test
    public void testNull() {
	RealEstateAgencyDTO agency = new RealEstateAgencyDTO(null, null,
		null, null, null);

	Set<ConstraintViolation<RealEstateAgencyDTO>> constraintViolations =
		validator.validate(agency);

	assertEquals(4, constraintViolations.size());
    }
    
    @Test
    public void testEmptyParameters() {
	RealEstateAgencyDTO agency = new RealEstateAgencyDTO("", "",
		"", "", new AddressDTO("Ukraine",
			"Lviv", "79000", "Lviv", "Shevchenka 12"));

	Set<ConstraintViolation<RealEstateAgencyDTO>> constraintViolations =
		validator.validate(agency);

	assertEquals(5, constraintViolations.size());
    }
    
    @Test
    public void testSpaces() {
	RealEstateAgencyDTO agency = new RealEstateAgencyDTO("A B A", "A S F A",
		"+380975649564", "", new AddressDTO("Ukraine",
			"Lviv", "79000", "Lviv", "Shevchenka 12"));

	Set<ConstraintViolation<RealEstateAgencyDTO>> constraintViolations =
		validator.validate(agency);

	assertEquals(0, constraintViolations.size());
    }
    
    @Test
    public void testSpecialCharacters() {
	RealEstateAgencyDTO agency = new RealEstateAgencyDTO("A&B.", "A&S'F@A.f,!fa",
		"+380975649564", "", new AddressDTO("Ukraine",
			"Lviv", "79000", "Lviv", "Shevchenka 12"));

	Set<ConstraintViolation<RealEstateAgencyDTO>> constraintViolations =
		validator.validate(agency);

	assertEquals(0, constraintViolations.size());
    }
    
    @Test
    public void testShortParameters() {
	RealEstateAgencyDTO agency = new RealEstateAgencyDTO("DO", "DOA",
		"+38097569586", "", new AddressDTO("Ukraine",
			"Lviv", "79000", "Lviv", "Shevchenka 12"));

	Set<ConstraintViolation<RealEstateAgencyDTO>> constraintViolations =
		validator.validate(agency);

	assertEquals(4, constraintViolations.size());	
    }

}
