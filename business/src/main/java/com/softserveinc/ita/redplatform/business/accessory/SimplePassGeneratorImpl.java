package com.softserveinc.ita.redplatform.business.accessory;

import java.security.SecureRandom;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * Implementation of password generation method.
 * @author Bulhakov Alex
 *
 */
@Component
public class SimplePassGeneratorImpl implements PasswordGenerator {

    /**
     * Secure Random instance created as Spring singleton.
     */
    @Autowired
    private SecureRandom secureRandom;
    
    @Override
    public final String generatePassword(final int length) {

	return RandomStringUtils.random(length, 0, 0, true,
		true, null, secureRandom);
    }

}
