/*
 * Copyright 2018 Key Bridge. All rights reserved. Use is subject to license
 * terms.
 *
 * This software code is protected by Copyrights and remains the property of
 * Key Bridge and its suppliers, if any. Key Bridge reserves all rights in and to
 * Copyrights and no license is granted under Copyrights in this Software
 * License Agreement.
 *
 * Key Bridge generally licenses Copyrights for commercialization pursuant to
 * the terms of either a Standard Software Source Code License Agreement or a
 * Standard Product License Agreement. A copy of either Agreement can be
 * obtained upon request by sending an email to info@keybridgewireless.com.
 *
 * All information contained herein is the property of Key Bridge and its
 * suppliers, if any. The intellectual and technical concepts contained herein
 * are proprietary.
 */
package ca.gc.ic.lib.bdbs.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Key Bridge
 */
@Entity
@Table(name = "extend")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Extend.findAll", query = "SELECT e FROM Extend e")})
public class Extend implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "calls_banr")
  private String callsBanr;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "number")
  private Double number;
  @Column(name = "ant_system")
  private String antSystem;
  @Column(name = "start1")
  private String start1;
  @Column(name = "end1")
  private String end1;
  @Column(name = "start2")
  private Double start2;
  @Column(name = "end2")
  private Double end2;
  @Column(name = "power")
  private Double power;
  @Column(name = "rms")
  private Integer rms;
  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign")
    , @JoinColumn(name = "banner", referencedColumnName = "banner")})
  @ManyToOne
  private Facility facility;

  public Extend() {
  }

  public Extend(String callsBanr) {
    this.callsBanr = callsBanr;
  }

  public String getCallsBanr() {
    return callsBanr;
  }

  public void setCallsBanr(String callsBanr) {
    this.callsBanr = callsBanr;
  }

  public Double getNumber() {
    return number;
  }

  public void setNumber(Double number) {
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

  public Double getStart2() {
    return start2;
  }

  public void setStart2(Double start2) {
    this.start2 = start2;
  }

  public Double getEnd2() {
    return end2;
  }

  public void setEnd2(Double end2) {
    this.end2 = end2;
  }

  public Double getPower() {
    return power;
  }

  public void setPower(Double power) {
    this.power = power;
  }

  public Integer getRms() {
    return rms;
  }

  public void setRms(Integer rms) {
    this.rms = rms;
  }

  public Facility getFacility() {
    return facility;
  }

  public void setFacility(Facility facility) {
    this.facility = facility;
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
    if (!(object instanceof Extend)) {
      return false;
    }
    Extend other = (Extend) object;
    if ((this.callsBanr == null && other.callsBanr != null) || (this.callsBanr != null && !this.callsBanr.equals(other.callsBanr))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.lib.bdbs.entity.Extend[ callsBanr=" + callsBanr + " ]";
  }

}
