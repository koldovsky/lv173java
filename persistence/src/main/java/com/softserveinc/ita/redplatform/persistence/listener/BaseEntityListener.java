package com.softserveinc.ita.redplatform.persistence.listener;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.apache.log4j.Logger;

import com.softserveinc.ita.redplatform.common.entity.BaseEntity;

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
 	    			Logger.getLogger(SecurityContext.class);
    
    /**
     * method that insert to database createdBy and CreatedDate.
     * @param entity entity
     */
    @PrePersist
    public final void prePersist(final BaseEntity entity) {
	LOGGER.info("In pre persist");
	entity.setCreatedBy(SecurityContext.get());
	entity.setCreatedDate(new Date());
    }

    /**
     * method that insert to database updatedBy and updatedDate.
     * @param entity entity
     */
    @PreUpdate
    public final void preUpdate(final BaseEntity entity) {
	LOGGER.info("In pre update");
	entity.setUpdatedBy(SecurityContext.get());
	entity.setUpdatedDate(new Date());
    }
}
