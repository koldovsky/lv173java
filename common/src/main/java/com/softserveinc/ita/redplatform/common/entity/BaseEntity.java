package com.softserveinc.ita.redplatform.common.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;


/**
 * Class that represents Base Entity.
 *
 * @author Roman Ivaniv
 */
@MappedSuperclass
public abstract class BaseEntity {

  /**
  * Column for id.
  */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * Many to one mapping.
   */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "createdById", updatable = false)
  private User createdBy;

  /**
  * Column for create Date information.
  */
  @Column(name = "createdDate", updatable = false)
  private Date createdDate;

  /**
  * Many to one mapping.
  */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "updatedById")
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
  public final User getCreatedBy() {
    return createdBy;
  }

  /**
   * Changes createdBy value to newCreatedBy.
   *
   * @param newCreatedBy to be set
   */
  public final void setCreatedBy(final User newCreatedBy) {
    this.createdBy = newCreatedBy;
  }

  /**
  * Get value of column createDate.
  *
  * @return createDate
  */
  public final Date getCreatedDate() {
    return createdDate;
  }

  /**
  * Changes createdDate value to newCreatedDate.
  *
  * @param newCreatedDate to be set
  */
  public final void setCreatedDate(final Date newCreatedDate) {
    this.createdDate = newCreatedDate;
  }

  /**
  * Get value of column updatedBy.
  *
  * @return the updatedBy
  */
  public final User getUpdatedBy() {
    return updatedBy;
  }

  /**
  * Changes updatedBy value to newUpdatedBy.
  *
  * @param newUpdatedBy to be set
  */
  public final void setUpdatedBy(final User newUpdatedBy) {
    this.updatedBy = newUpdatedBy;
  }

  /**
  * Get value of column updatedDate.
  *
  * @return the updatedDate
  */
  public final Date getUpdatedDate() {
    return updatedDate;
  }

  /**
  * Changes updatedDate value to newUpdatedDate.
  *
  * @param newUpdatedDate to be set
  */
  public final void setUpdatedDate(final Date newUpdatedDate) {
    this.updatedDate = newUpdatedDate;
  }

  /**
  * Get value of column Id.
  *
  * @return the Id
  */
  public final Long getId() {
    return id;
  }

  /**
  * Changes Id value to newId.
  *
  * @param newId to be set
  */
  public final void setId(final Long newId) {
    this.id = newId;
  }

}
