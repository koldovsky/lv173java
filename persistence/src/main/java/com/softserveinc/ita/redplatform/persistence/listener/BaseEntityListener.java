package com.softserveinc.ita.redplatform.persistence.listener;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.apache.log4j.Logger;

import com.softserveinc.ita.redplatform.common.entity.BaseEntity;
import com.softserveinc.ita.redplatform.common.entity.User;
import com.softserveinc.ita.redplatform.persistence.context.SecurityContext;

/**
 * Event listener to insert date and user.
 * @author oleh
 *
 */
public class BaseEntityListener {
    
    /**
     * LOGGER.
     */
     private static final Logger LOGGER = 
 	    			Logger.getLogger(BaseEntityListener.class);
    
    /**
     * method that insert to database createdBy and CreatedDate.
     * @param entity entity
     */
    @PrePersist
    public final void prePersist(final BaseEntity entity) {
	LOGGER.debug("In pre persist");
	entity.setCreatedBy(getUser());
	entity.setCreatedDate(new Date());
    }

    /**
     * method that insert to database updatedBy and updatedDate.
     * @param entity entity
     */
    @PreUpdate
    public final void preUpdate(final BaseEntity entity) {
	LOGGER.debug("In pre update");
	entity.setUpdatedBy(getUser());
	entity.setUpdatedDate(new Date());
    }
    
    private User getUser() {
	return SecurityContext.USER_DAO.get().findUserByEmail(
			SecurityContext.CURRENT_USER.get().getUsername()
		);
    }
}
