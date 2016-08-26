package com.eren.assignment.sahibinden.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public abstract class HistoricalEntity extends BaseEntity {

  /** The status. */
  @JsonIgnore
  private String status;

  /** The create date. */
  @JsonIgnore
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false)
  private Date cdate;

  /** The creator user id. */
  @JsonIgnore
  @Column(nullable = true)
  private Long cuserId;

  /** The update date. */
  @JsonIgnore
  @Temporal(TemporalType.TIMESTAMP)
  private Date udate;

  /** The uuser id. */
  @JsonIgnore
  @Column
  private Long uuserId;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Date getCdate() {
    return cdate;
  }

  public void setCdate(Date cdate) {
    this.cdate = cdate;
  }

  public Long getCuserId() {
    return cuserId;
  }

  public void setCuserId(Long cuserId) {
    this.cuserId = cuserId;
  }

  public Date getUdate() {
    return udate;
  }

  public void setUdate(Date udate) {
    this.udate = udate;
  }

  public Long getUuserId() {
    return uuserId;
  }

  public void setUuserId(Long uuserId) {
    this.uuserId = uuserId;
  }

}