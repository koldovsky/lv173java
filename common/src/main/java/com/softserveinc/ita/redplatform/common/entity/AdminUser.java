package com.softserveinc.ita.redplatform.common.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Class represents system administrators.  
 * Information about admins in system is not obligatory.
 * 
 * @author Oleksiy Bulhakov
 */
@Entity
@Table(name = "AdminUsers")
public class AdminUser extends User {

    /**
     * serialUID for serializing.
     */
    private static final long serialVersionUID = -2174942832546333722L;

}
