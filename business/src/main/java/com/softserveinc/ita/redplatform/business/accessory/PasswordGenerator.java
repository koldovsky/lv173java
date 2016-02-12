package com.softserveinc.ita.redplatform.business.accessory;

/**
 * Interface for generating passwords.
 * 
 * @author Bulhakov Alex
 */
public interface PasswordGenerator {
    /**
     * Method returns password.
     * 
     * @return String password
     *            Describes the length of password
     */
    String generatePassword();

}
