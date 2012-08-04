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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author jesse
 */
@Entity
@Table(name = "region")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "CA_Region.findAll", query = "SELECT c FROM CA_Region c"),
  @NamedQuery(name = "CA_Region.findByCallsBanr", query = "SELECT c FROM CA_Region c WHERE c.callsBanr = :callsBanr"),
  @NamedQuery(name = "CA_Region.findByRegion", query = "SELECT c FROM CA_Region c WHERE c.region = :region"),
  @NamedQuery(name = "CA_Region.findByDistrict", query = "SELECT c FROM CA_Region c WHERE c.district = :district"),
  @NamedQuery(name = "CA_Region.findByInspecRep", query = "SELECT c FROM CA_Region c WHERE c.inspecRep = :inspecRep"),
  @NamedQuery(name = "CA_Region.findByPainting", query = "SELECT c FROM CA_Region c WHERE c.painting = :painting"),
  @NamedQuery(name = "CA_Region.findBySprDat", query = "SELECT c FROM CA_Region c WHERE c.sprDat = :sprDat"),
  @NamedQuery(name = "CA_Region.findByRspDat", query = "SELECT c FROM CA_Region c WHERE c.rspDat = :rspDat"),
  @NamedQuery(name = "CA_Region.findByStdett", query = "SELECT c FROM CA_Region c WHERE c.stdett = :stdett"),
  @NamedQuery(name = "CA_Region.findByAirClear", query = "SELECT c FROM CA_Region c WHERE c.airClear = :airClear"),
  @NamedQuery(name = "CA_Region.findByInspecDat", query = "SELECT c FROM CA_Region c WHERE c.inspecDat = :inspecDat"),
  @NamedQuery(name = "CA_Region.findByRcfDat", query = "SELECT c FROM CA_Region c WHERE c.rcfDat = :rcfDat"),
  @NamedQuery(name = "CA_Region.findByStatType", query = "SELECT c FROM CA_Region c WHERE c.statType = :statType"),
  @NamedQuery(name = "CA_Region.findByDocfex", query = "SELECT c FROM CA_Region c WHERE c.docfex = :docfex"),
  @NamedQuery(name = "CA_Region.findByProvince", query = "SELECT c FROM CA_Region c WHERE c.province = :province"),
  @NamedQuery(name = "CA_Region.findByCountry", query = "SELECT c FROM CA_Region c WHERE c.country = :country")})
public class CA_Region implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "calls_banr", nullable = false, length = 32)
  @XmlTransient
  private String callsBanr;
  @Column(length = 1)
  @XmlAttribute
  private String region;
  @Column(length = 2)
  @XmlAttribute
  private String district;
  @Column(name = "inspec_rep", length = 1)
  @XmlAttribute
  private String inspecRep;
  @Column(length = 4)
  @XmlAttribute
  private String painting;
  @Column(name = "spr_dat", precision = 12)
  @XmlAttribute
  private Float sprDat;
  @Column(name = "rsp_dat", precision = 12)
  @XmlAttribute
  private Float rspDat;
  @Column(precision = 12)
  @XmlAttribute
  private Float stdett;
  @Column(name = "air_clear", precision = 12)
  @XmlAttribute
  private Float airClear;
  @Column(name = "inspec_dat", precision = 12)
  @XmlAttribute
  private Float inspecDat;
  @Column(name = "rcf_dat", precision = 12)
  @XmlAttribute
  private Float rcfDat;
  @Column(name = "stat_type", length = 2)
  @XmlAttribute
  private String statType;
  @Column(length = 4)
  @XmlAttribute
  private String docfex;
  @Column(length = 2)
  @XmlAttribute
  private String province;
  @Column(length = 2)
  @XmlAttribute
  private String country;
//  @OneToOne(mappedBy = "caRegion")  @XmlTransient  private AmStation amStation;

  public CA_Region() {
  }

  public CA_Region(String callsBanr) {
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

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (callsBanr != null ? callsBanr.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CA_Region)) {
      return false;
    }
    CA_Region other = (CA_Region) object;
    if ((this.callsBanr == null && other.callsBanr != null) || (this.callsBanr != null && !this.callsBanr.equals(other.callsBanr))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.CA_Region[ callsBanr=" + callsBanr + " ]";
  }
}
