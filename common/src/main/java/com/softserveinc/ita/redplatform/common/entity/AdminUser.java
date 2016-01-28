package com.softserveinc.ita.redplatform.common.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
/*
 * Class represents system administrators.  
 * Information about admins in system is not obligatory.
 */
@Entity
@Table(name = "AdminUsers")
public class AdminUser extends User {

}
