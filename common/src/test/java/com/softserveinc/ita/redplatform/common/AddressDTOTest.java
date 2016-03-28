package com.softserveinc.ita.redplatform.common;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

import com.softserveinc.ita.redplatform.common.dto.AddressDTO;

public class AddressDTOTest {
    
    private static Validator validator;

    @BeforeClass
    public static void setUp() {
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	validator = factory.getValidator();
    }

    @Test
    public void testRealAddress() {
	AddressDTO address = new AddressDTO("Ukraine", "Lviv", "79000", "Lviv",
		"Shevchenka 12");

	Set<ConstraintViolation<AddressDTO>> constraintViolations =
		validator.validate(address);
	
	assertEquals(0, constraintViolations.size());
    }

    @Test
    public void testNullParameters() {
	AddressDTO address = new AddressDTO(null, null, null, null, null);

	Set<ConstraintViolation<AddressDTO>> constraintViolations =
		validator.validate(address);

	assertEquals(4, constraintViolations.size());
    }

    @Test
    public void testEmptyParameters() {
	AddressDTO address = new AddressDTO("", "", "", "", "");

	Set<ConstraintViolation<AddressDTO>> constraintViolations =
		validator.validate(address);

	assertEquals(4, constraintViolations.size());
    }

    @Test
    public void testNumbersAndLetters() {
	AddressDTO address = new AddressDTO("1243", "Lviv", "aaaaa", "Lviv",
		"Shevchenka 12");

	Set<ConstraintViolation<AddressDTO>> constraintViolations =
		validator.validate(address);

	assertEquals(2, constraintViolations.size());
    }

    @Test
    public void testHyphens() {
	AddressDTO address = new AddressDTO("U.S.A-Country", "New-York",
		"78a89", "Rio-De-Jineiro", "Shevchenka 12/2a");

	Set<ConstraintViolation<AddressDTO>> constraintViolations =
		validator.validate(address);

	assertEquals(0, constraintViolations.size());
    }

    @Test
    public void testSpaces() {
	AddressDTO address = new AddressDTO("New Zealand", "Lviv oblast",
		"78 987", "New York", "Shevchenka 12 2a");

	Set<ConstraintViolation<AddressDTO>> constraintViolations =
		validator.validate(address);

	assertEquals(1, constraintViolations.size());
    }
    
    @Test
    public void testSpecialCharacters() {
	AddressDTO address = new AddressDTO("U&SA!", "L'viv oblast", "78-987", "New,York",
		"Shevchenka' 12:2a");

	Set<ConstraintViolation<AddressDTO>> constraintViolations =
		validator.validate(address);

	assertEquals(2, constraintViolations.size());
    }
    
    @Test
    public void testTooShortParameters() {
	AddressDTO address = new AddressDTO("Ua", "Lv", "78", "NY",
		"Lv 12/22");

	Set<ConstraintViolation<AddressDTO>> constraintViolations =
		validator.validate(address);

	assertEquals(2, constraintViolations.size());
    }
    
    
}
