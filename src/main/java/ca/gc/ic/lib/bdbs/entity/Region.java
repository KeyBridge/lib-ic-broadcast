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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Key Bridge
 */
@Entity
@Table(name = "region")
@XmlAccessorType(XmlAccessType.FIELD)
public class Region implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "calls_banr")
  private String callsBanr;
  @Column(name = "region")
  private String region;
  @Column(name = "district")
  private String district;
  @Column(name = "inspec_rep")
  private String inspecRep;
  @Column(name = "painting")
  private String painting;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "spr_dat")
  private Double sprDat;
  @Column(name = "rsp_dat")
  private Double rspDat;
  @Column(name = "stdett")
  private Double stdett;
  @Column(name = "air_clear")
  private Double airClear;
  @Column(name = "inspec_dat")
  private Double inspecDat;
  @Column(name = "rcf_dat")
  private Double rcfDat;
  @Column(name = "stat_type")
  private String statType;
  @Column(name = "docfex")
  private String docfex;
  @Column(name = "province")
  private String province;
  @Column(name = "country")
  private String country;
  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign")
    , @JoinColumn(name = "banner", referencedColumnName = "banner")})
  @ManyToOne
  @XmlTransient
  private Facility facility;

  public Region() {
  }

  public Region(String callsBanr) {
    this.callsBanr = callsBanr;
  }

  public String getCallsBanr() {
    return callsBanr;
  }

  public void setCallsBanr(String callsBanr) {
    this.callsBanr = callsBanr;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public String getInspecRep() {
    return inspecRep;
  }

  public void setInspecRep(String inspecRep) {
    this.inspecRep = inspecRep;
  }

  public String getPainting() {
    return painting;
  }

  public void setPainting(String painting) {
    this.painting = painting;
  }

  public Double getSprDat() {
    return sprDat;
  }

  public void setSprDat(Double sprDat) {
    this.sprDat = sprDat;
  }

  public Double getRspDat() {
    return rspDat;
  }

  public void setRspDat(Double rspDat) {
    this.rspDat = rspDat;
  }

  public Double getStdett() {
    return stdett;
  }

  public void setStdett(Double stdett) {
    this.stdett = stdett;
  }

  public Double getAirClear() {
    return airClear;
  }

  public void setAirClear(Double airClear) {
    this.airClear = airClear;
  }

  public Double getInspecDat() {
    return inspecDat;
  }

  public void setInspecDat(Double inspecDat) {
    this.inspecDat = inspecDat;
  }

  public Double getRcfDat() {
    return rcfDat;
  }

  public void setRcfDat(Double rcfDat) {
    this.rcfDat = rcfDat;
  }

  public String getStatType() {
    return statType;
  }

  public void setStatType(String statType) {
    this.statType = statType;
  }

  public String getDocfex() {
    return docfex;
  }

  public void setDocfex(String docfex) {
    this.docfex = docfex;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
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
    if (!(object instanceof Region)) {
      return false;
    }
    Region other = (Region) object;
    if ((this.callsBanr == null && other.callsBanr != null) || (this.callsBanr != null && !this.callsBanr.equals(other.callsBanr))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.lib.bdbs.entity.Region[ callsBanr=" + callsBanr + " ]";
  }

}
