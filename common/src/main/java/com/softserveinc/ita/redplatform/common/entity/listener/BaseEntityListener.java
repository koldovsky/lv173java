package com.softserveinc.ita.redplatform.common.entity.listener;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.softserveinc.ita.redplatform.common.entity.BaseEntity;

/**
 * Event listener.
 * @author oleh
 *
 */
public class BaseEntityListener {

    /**
     * method that insert to database createdBy and CreatedDate.
     * @param entity BaseEntity 
     */
    @PrePersist
    public final void prePersist(final BaseEntity entity) {
	entity.setCreatedBy(SecurityContext.getCurrentUser());
	entity.setCreatedDate(new Date());
    }

    /**
     * method that insert to database updatedBy and updatedDate.
     * @param entity BaseEntity
     */
    @PreUpdate
    public final void preUpdate(final BaseEntity entity) {
	entity.setUpdatedBy(SecurityContext.getCurrentUser());
	entity.setUpdatedDate(new Date());
    }
}
