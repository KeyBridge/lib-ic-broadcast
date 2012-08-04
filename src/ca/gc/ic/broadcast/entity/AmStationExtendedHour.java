/*
 *   Copyright (C) 2012 Caulfield IP Holdings (Caulfield)
 *   and/or its affiliates.
 *   All rights reserved. Use is subject to license terms.
 *
 *   Software Code is protected by Caulfield Copyrights. Caulfield hereby
 *   reserves all rights in and to Caulfield Copyrights and no license is
 *   granted under Caulfield Copyrights in this Software License Agreement.
 *   Caulfield generally licenses Caulfield Copyrights for commercialization
 *   pursuant to the terms of either Caulfield's Standard Software Source Code
 *   License Agreement or Caulfield's Standard Product License Agreement.
 *
 *   A copy of Caulfield's either License Agreement can be obtained on request
 *   by email from: info@caufield.org.
 */
package ca.gc.ic.broadcast.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author jesse
 */
@Entity
@Table(name = "extend")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "AmStationExtendedHour.findAll", query = "SELECT a FROM AmStationExtendedHour a"),
  @NamedQuery(name = "AmStationExtendedHour.findByCallsBanr", query = "SELECT a FROM AmStationExtendedHour a WHERE a.callsBanr = :callsBanr"),
  @NamedQuery(name = "AmStationExtendedHour.findByNumber", query = "SELECT a FROM AmStationExtendedHour a WHERE a.number = :number"),
  @NamedQuery(name = "AmStationExtendedHour.findByAntSystem", query = "SELECT a FROM AmStationExtendedHour a WHERE a.antSystem = :antSystem"),
  @NamedQuery(name = "AmStationExtendedHour.findByStart1", query = "SELECT a FROM AmStationExtendedHour a WHERE a.start1 = :start1"),
  @NamedQuery(name = "AmStationExtendedHour.findByEnd1", query = "SELECT a FROM AmStationExtendedHour a WHERE a.end1 = :end1"),
  @NamedQuery(name = "AmStationExtendedHour.findByStart2", query = "SELECT a FROM AmStationExtendedHour a WHERE a.start2 = :start2"),
  @NamedQuery(name = "AmStationExtendedHour.findByEnd2", query = "SELECT a FROM AmStationExtendedHour a WHERE a.end2 = :end2"),
  @NamedQuery(name = "AmStationExtendedHour.findByPower", query = "SELECT a FROM AmStationExtendedHour a WHERE a.power = :power"),
  @NamedQuery(name = "AmStationExtendedHour.findByRms", query = "SELECT a FROM AmStationExtendedHour a WHERE a.rms = :rms")})
public class AmStationExtendedHour implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "calls_banr", nullable = false, length = 32)
  @XmlAttribute
  private String callsBanr;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(precision = 12)
  @XmlAttribute
  private Float number;
  @Column(name = "ant_system", length = 1)
  @XmlAttribute
  private String antSystem;
  @Column(length = 4)
  @XmlAttribute
  private String start1;
  @Column(length = 4)
  @XmlAttribute
  private String end1;
  @Column(precision = 12)
  @XmlAttribute
  private Float start2;
  @Column(precision = 12)
  @XmlAttribute
  private Float end2;
  @Column(precision = 12)
  @XmlAttribute
  private Float power;
  @XmlAttribute
  private Integer rms;
  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign"),
    @JoinColumn(name = "banner", referencedColumnName = "banner")})
  @ManyToOne
  private AmStation amStation;

  public AmStationExtendedHour() {
  }

  public AmStationExtendedHour(String callsBanr) {
    this.callsBanr = callsBanr;
  }

  public String getCallsBanr() {
    return callsBanr;
  }

  public void setCallsBanr(String callsBanr) {
    this.callsBanr = callsBanr;
  }

  public Float getNumber() {
    return number;
  }

  public void setNumber(Float number) {
    this.number = number;
  }

  public String getAntSystem() {
    return antSystem;
  }

  public void setAntSystem(String antSystem) {
    this.antSystem = antSystem;
  }

  public String getStart1() {
    return start1;
  }

  public void setStart1(String start1) {
    this.start1 = start1;
  }

  public String getEnd1() {
    return end1;
  }

  public void setEnd1(String end1) {
    this.end1 = end1;
  }

  public Float getStart2() {
    return start2;
  }

  public void setStart2(Float start2) {
    this.start2 = start2;
  }

  public Float getEnd2() {
    return end2;
  }

  public void setEnd2(Float end2) {
    this.end2 = end2;
  }

  public Float getPower() {
    return power;
  }

  public void setPower(Float power) {
    this.power = power;
  }

  public Integer getRms() {
    return rms;
  }

  public void setRms(Integer rms) {
    this.rms = rms;
  }

  public AmStation getAmStation() {
    return amStation;
  }

  public void setAmStation(AmStation amStation) {
    this.amStation = amStation;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (callsBanr != null ? callsBanr.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof AmStationExtendedHour)) {
      return false;
    }
    AmStationExtendedHour other = (AmStationExtendedHour) object;
    if ((this.callsBanr == null && other.callsBanr != null) || (this.callsBanr != null && !this.callsBanr.equals(other.callsBanr))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.AmStationExtendedHour[ callsBanr=" + callsBanr + " ]";
  }
}
