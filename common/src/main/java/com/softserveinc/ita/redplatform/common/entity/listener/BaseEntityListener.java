package com.softserveinc.ita.redplatform.common.entity.listener;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.softserveinc.ita.redplatform.common.entity.BaseEntity;

/**
 * Event listener to insert date and user.
 * @author oleh
 *
 */
public class BaseEntityListener {

    /**
     * method that insert to database createdBy and CreatedDate.
     * @param entity entity
     */
    @PrePersist
    public final void prePersist(final BaseEntity entity) {
	entity.setCreatedBy(SecurityContext.CURRENT_USER.get());
	entity.setCreatedDate(new Date());
    }

    /**
     * method that insert to database updatedBy and updatedDate.
     * @param entity entity
     */
    @PreUpdate
    public final void preUpdate(final BaseEntity entity) {
	entity.setUpdatedBy(SecurityContext.CURRENT_USER.get());
	entity.setUpdatedDate(new Date());
    }
}
