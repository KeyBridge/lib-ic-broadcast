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
@Table(name = "region")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "RegionalFiling.findAll", query = "SELECT r FROM RegionalFiling r"),
  @NamedQuery(name = "RegionalFiling.findByCallsBanr", query = "SELECT r FROM RegionalFiling r WHERE r.callsBanr = :callsBanr"),
  @NamedQuery(name = "RegionalFiling.findByRegion", query = "SELECT r FROM RegionalFiling r WHERE r.region = :region"),
  @NamedQuery(name = "RegionalFiling.findByDistrict", query = "SELECT r FROM RegionalFiling r WHERE r.district = :district"),
  @NamedQuery(name = "RegionalFiling.findByInspecRep", query = "SELECT r FROM RegionalFiling r WHERE r.inspecRep = :inspecRep"),
  @NamedQuery(name = "RegionalFiling.findByPainting", query = "SELECT r FROM RegionalFiling r WHERE r.painting = :painting"),
  @NamedQuery(name = "RegionalFiling.findBySprDat", query = "SELECT r FROM RegionalFiling r WHERE r.sprDat = :sprDat"),
  @NamedQuery(name = "RegionalFiling.findByRspDat", query = "SELECT r FROM RegionalFiling r WHERE r.rspDat = :rspDat"),
  @NamedQuery(name = "RegionalFiling.findByStdett", query = "SELECT r FROM RegionalFiling r WHERE r.stdett = :stdett"),
  @NamedQuery(name = "RegionalFiling.findByAirClear", query = "SELECT r FROM RegionalFiling r WHERE r.airClear = :airClear"),
  @NamedQuery(name = "RegionalFiling.findByInspecDat", query = "SELECT r FROM RegionalFiling r WHERE r.inspecDat = :inspecDat"),
  @NamedQuery(name = "RegionalFiling.findByRcfDat", query = "SELECT r FROM RegionalFiling r WHERE r.rcfDat = :rcfDat"),
  @NamedQuery(name = "RegionalFiling.findByStatType", query = "SELECT r FROM RegionalFiling r WHERE r.statType = :statType"),
  @NamedQuery(name = "RegionalFiling.findByDocfex", query = "SELECT r FROM RegionalFiling r WHERE r.docfex = :docfex"),
  @NamedQuery(name = "RegionalFiling.findByProvince", query = "SELECT r FROM RegionalFiling r WHERE r.province = :province"),
  @NamedQuery(name = "RegionalFiling.findByCountry", query = "SELECT r FROM RegionalFiling r WHERE r.country = :country"),
  @NamedQuery(name = "RegionalFiling.findByCallSign", query = "SELECT r FROM RegionalFiling r WHERE r.regionalFilingPK.callSign = :callSign"),
  @NamedQuery(name = "RegionalFiling.findByBanner", query = "SELECT r FROM RegionalFiling r WHERE r.regionalFilingPK.banner = :banner")})
public class RegionalFiling implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected RegionalFilingPK regionalFilingPK;
  @Column(name = "calls_banr", length = 32)
  private String callsBanr;
  @Column(name = "region", length = 1)
  private String region;
  @Column(name = "district", length = 2)
  private String district;
  @Column(name = "inspec_rep", length = 1)
  private String inspecRep;
  @Column(name = "painting", length = 4)
  private String painting;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "spr_dat", precision = 12)
  private Float sprDat;
  @Column(name = "rsp_dat", precision = 12)
  private Float rspDat;
  @Column(name = "stdett", precision = 12)
  private Float stdett;
  @Column(name = "air_clear", precision = 12)
  private Float airClear;
  @Column(name = "inspec_dat", precision = 12)
  private Float inspecDat;
  @Column(name = "rcf_dat", precision = 12)
  private Float rcfDat;
  @Column(name = "stat_type", length = 2)
  private String statType;
  @Column(name = "docfex", length = 4)
  private String docfex;
  @Column(name = "province", length = 2)
  private String province;
  @Column(name = "country", length = 2)
  private String country;
  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "banner", referencedColumnName = "banner", nullable = false, insertable = false, updatable = false)})
  @OneToOne(optional = false)
  private CanadaStation canadaStation;

  public RegionalFiling() {
  }

  public RegionalFiling(RegionalFilingPK regionalFilingPK) {
    this.regionalFilingPK = regionalFilingPK;
  }

  public RegionalFiling(String callSign, String banner) {
    this.regionalFilingPK = new RegionalFilingPK(callSign, banner);
  }

  public RegionalFilingPK getRegionalFilingPK() {
    return regionalFilingPK;
  }

  public void setRegionalFilingPK(RegionalFilingPK regionalFilingPK) {
    this.regionalFilingPK = regionalFilingPK;
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

  public Float getSprDat() {
    return sprDat;
  }

  public void setSprDat(Float sprDat) {
    this.sprDat = sprDat;
  }

  public Float getRspDat() {
    return rspDat;
  }

  public void setRspDat(Float rspDat) {
    this.rspDat = rspDat;
  }

  public Float getStdett() {
    return stdett;
  }

  public void setStdett(Float stdett) {
    this.stdett = stdett;
  }

  public Float getAirClear() {
    return airClear;
  }

  public void setAirClear(Float airClear) {
    this.airClear = airClear;
  }

  public Float getInspecDat() {
    return inspecDat;
  }

  public void setInspecDat(Float inspecDat) {
    this.inspecDat = inspecDat;
  }

  public Float getRcfDat() {
    return rcfDat;
  }

  public void setRcfDat(Float rcfDat) {
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

  public CanadaStation getCanadaStation() {
    return canadaStation;
  }

  public void setCanadaStation(CanadaStation canadaStation) {
    this.canadaStation = canadaStation;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (regionalFilingPK != null ? regionalFilingPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof RegionalFiling)) {
      return false;
    }
    RegionalFiling other = (RegionalFiling) object;
    if ((this.regionalFilingPK == null && other.regionalFilingPK != null) || (this.regionalFilingPK != null && !this.regionalFilingPK.equals(other.regionalFilingPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.RegionalFiling[ regionalFilingPK=" + regionalFilingPK + " ]";
  }

}
