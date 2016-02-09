package com.softserveinc.ita.redplatform.business.accessory;

import org.apache.commons.lang3.RandomStringUtils;
/**
 * Implementation of password generation method.
 * @author Bulhakov Alex
 *
 */
public class SimplePassGeneratorImpl implements PasswordGenerator {

    
    @Override
    public final String generatePassword(final int length) {
	
	return RandomStringUtils.random(length, true, true);
    }

}
