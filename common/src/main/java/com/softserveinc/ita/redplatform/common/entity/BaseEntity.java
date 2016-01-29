package com.softserveinc.ita.redplatform.common.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

/**
 * Class that represents Base Entity.
 *
 * @author Roman Ivaniv
 */
@MappedSuperclass
public abstract class BaseEntity {

    /**
     * Column for id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    /**
     * 
     */
    @OneToOne
    @JoinColumn(name = "createdById")
    private User createdBy;

    /**
     * Column for create Date information.
     */
    @Column(name = "createDate")
    private Date createdDate;

    /**
     * 
     */
    @OneToOne
    @JoinColumn(name = "UpdatedById")
    private User updatedBy;

    /**
     * Column for update Date information.
     */
    @Column(name = "updatedDate")
    private Date updatedDate;
    
    /**
     * Get value of column createdBy.
     *
     * @return createdBy
     */
    public User getCreatedBy() {
	return createdBy;
    }
    
    /**
     * Changes createdBy value to newCreatedBy.
     *
     * @param newCreatedBy
     *            
     */
    public void setCreatedBy(User newCreatedBy) {
	this.createdBy = newCreatedBy;
    }
    
    /**
     * Get value of column createDate.
     *
     * @return createDate
     */
    public Date getCreatedDate() {
	return createdDate;
    }
    
    /**
     * Changes createdDate value to newCreatedDate.
     *
     * @param newCreatedDate
     *            
     */
    public void setCreatedDate(Date newCreatedDate) {
	this.createdDate = newCreatedDate;
    }
    
    /**
     * Get value of column updatedBy.
     *
     * @return the updatedBy
     */
    public User getUpdatedBy() {
	return updatedBy;
    }
    
    /**
     * Changes updatedBy value to newUpdatedBy.
     *
     * @param newUpdatedBy
     *            
     */
    public void setUpdatedBy(User newUpdatedBy) {
	this.updatedBy = newUpdatedBy;
    }
    
    /**
     * Get value of column updatedDate.
     *
     * @return the updatedDate
     */
    public Date getUpdatedDate() {
	return updatedDate;
    }
    
    /**
     * Changes updatedDate value to newUpdatedDate.
     *
     * @param newUpdatedDate
     *            
     */
    public void setUpdatedDate(Date newUpdatedDate) {
	this.updatedDate = newUpdatedDate;
    }
   
    /**
     * Get value of column Id.
     *
     * @return the Id
     */
	public long getId() {
		return id;
	}
	
	/**
     * Changes Id value to newId.
     *
     * @param newId
     *            
     */
	public void setId(long newId) {
		this.id = newId;
	}

}
