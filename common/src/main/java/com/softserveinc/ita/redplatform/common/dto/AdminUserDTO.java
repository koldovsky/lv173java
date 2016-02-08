package com.softserveinc.ita.redplatform.common.dto;

/**
 * DTO for Admin User.
 * 
 * @author Bulhakov Alex
 *
 */
public class AdminUserDTO {
    /**
     * The login(and email at the same time) of Admin User.
     */
    private String email;
    /**
     * Password of the user.
     */
    private String password;

    /**
     * Default constructor.
     */
    public AdminUserDTO() {
    }

    public final String getEmail() {
	return email;
    }

    public final void setEmail(final String newEmail) {
	this.email = newEmail;
    }

    public final String getPassword() {
	return password;
    }

    public final void setPassword(final String newPassword) {
	this.password = newPassword;
    }

}
