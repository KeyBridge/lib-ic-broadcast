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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jesse
 */
@Entity
@Table(name = "extend")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "AmStationExtendedHours.findAll", query = "SELECT a FROM AmStationExtendedHours a"),
  @NamedQuery(name = "AmStationExtendedHours.findByCallsBanr", query = "SELECT a FROM AmStationExtendedHours a WHERE a.callsBanr = :callsBanr"),
  @NamedQuery(name = "AmStationExtendedHours.findByNumber", query = "SELECT a FROM AmStationExtendedHours a WHERE a.number = :number"),
  @NamedQuery(name = "AmStationExtendedHours.findByAntSystem", query = "SELECT a FROM AmStationExtendedHours a WHERE a.antSystem = :antSystem"),
  @NamedQuery(name = "AmStationExtendedHours.findByStart1", query = "SELECT a FROM AmStationExtendedHours a WHERE a.start1 = :start1"),
  @NamedQuery(name = "AmStationExtendedHours.findByEnd1", query = "SELECT a FROM AmStationExtendedHours a WHERE a.end1 = :end1"),
  @NamedQuery(name = "AmStationExtendedHours.findByStart2", query = "SELECT a FROM AmStationExtendedHours a WHERE a.start2 = :start2"),
  @NamedQuery(name = "AmStationExtendedHours.findByEnd2", query = "SELECT a FROM AmStationExtendedHours a WHERE a.end2 = :end2"),
  @NamedQuery(name = "AmStationExtendedHours.findByPower", query = "SELECT a FROM AmStationExtendedHours a WHERE a.power = :power"),
  @NamedQuery(name = "AmStationExtendedHours.findByRms", query = "SELECT a FROM AmStationExtendedHours a WHERE a.rms = :rms"),
  @NamedQuery(name = "AmStationExtendedHours.findByCallSign", query = "SELECT a FROM AmStationExtendedHours a WHERE a.amStationExtendedHoursPK.callSign = :callSign"),
  @NamedQuery(name = "AmStationExtendedHours.findByBanner", query = "SELECT a FROM AmStationExtendedHours a WHERE a.amStationExtendedHoursPK.banner = :banner")})
public class AmStationExtendedHours implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected AmStationExtendedHoursPK amStationExtendedHoursPK;
  @Column(name = "calls_banr", length = 32)
  private String callsBanr;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "number", precision = 12)
  private float number;
  @Column(name = "ant_system", length = 1)
  private String antSystem;
  @Column(name = "start1", length = 4)
  private String start1;
  @Column(name = "end1", length = 4)
  private String end1;
  @Column(name = "start2", precision = 12)
  private float start2;
  @Column(name = "end2", precision = 12)
  private float end2;
  @Column(name = "power", precision = 12)
  private float power;
  @Column(name = "rms")
  private int rms;
  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "banner", referencedColumnName = "banner", nullable = false, insertable = false, updatable = false)})
  @OneToOne(optional = false)
  private CanadaStation canadaStation;

  public AmStationExtendedHours() {
  }

  public AmStationExtendedHours(AmStationExtendedHoursPK amStationExtendedHoursPK) {
    this.amStationExtendedHoursPK = amStationExtendedHoursPK;
  }

  public AmStationExtendedHours(String callSign, String banner) {
    this.amStationExtendedHoursPK = new AmStationExtendedHoursPK(callSign, banner);
  }

  public AmStationExtendedHoursPK getAmStationExtendedHoursPK() {
    return amStationExtendedHoursPK;
  }

  public void setAmStationExtendedHoursPK(AmStationExtendedHoursPK amStationExtendedHoursPK) {
    this.amStationExtendedHoursPK = amStationExtendedHoursPK;
  }

  public String getCallsBanr() {
    return callsBanr;
  }

  public void setCallsBanr(String callsBanr) {
    this.callsBanr = callsBanr;
  }

  public float getNumber() {
    return number;
  }

  public void setNumber(float number) {
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

  public float getStart2() {
    return start2;
  }

  public void setStart2(float start2) {
    this.start2 = start2;
  }

  public float getEnd2() {
    return end2;
  }

  public void setEnd2(float end2) {
    this.end2 = end2;
  }

  public float getPower() {
    return power;
  }

  public void setPower(float power) {
    this.power = power;
  }

  public int getRms() {
    return rms;
  }

  public void setRms(int rms) {
    this.rms = rms;
  }

  public CanadaStation getCanadaStation() {
    return canadaStation;
  }

  public void setCanadaStation(CanadaStation canadaStation) {
    this.canadaStation = canadaStation;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (amStationExtendedHoursPK != null ? amStationExtendedHoursPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof AmStationExtendedHours)) {
      return false;
    }
    AmStationExtendedHours other = (AmStationExtendedHours) object;
    if ((this.amStationExtendedHoursPK == null && other.amStationExtendedHoursPK != null) || (this.amStationExtendedHoursPK != null && !this.amStationExtendedHoursPK.equals(other.amStationExtendedHoursPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.AmStationExtendedHours[ amStationExtendedHoursPK=" + amStationExtendedHoursPK + " ]";
  }
}
