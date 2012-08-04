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
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jesse
 */
@Entity
@Table(name = "province")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "CA_Province.findAll", query = "SELECT c FROM CA_Province c"),
  @NamedQuery(name = "CA_Province.findByProvince", query = "SELECT c FROM CA_Province c WHERE c.cA_ProvincePK.province = :province"),
  @NamedQuery(name = "CA_Province.findByCountry", query = "SELECT c FROM CA_Province c WHERE c.cA_ProvincePK.country = :country"),
  @NamedQuery(name = "CA_Province.findByLowLat", query = "SELECT c FROM CA_Province c WHERE c.lowLat = :lowLat"),
  @NamedQuery(name = "CA_Province.findByHighLat", query = "SELECT c FROM CA_Province c WHERE c.highLat = :highLat"),
  @NamedQuery(name = "CA_Province.findByLowLong", query = "SELECT c FROM CA_Province c WHERE c.lowLong = :lowLong"),
  @NamedQuery(name = "CA_Province.findByHighLong", query = "SELECT c FROM CA_Province c WHERE c.highLong = :highLong"),
  @NamedQuery(name = "CA_Province.findByCreatDt", query = "SELECT c FROM CA_Province c WHERE c.creatDt = :creatDt"),
  @NamedQuery(name = "CA_Province.findByModDt", query = "SELECT c FROM CA_Province c WHERE c.modDt = :modDt"),
  @NamedQuery(name = "CA_Province.findByEngdesc", query = "SELECT c FROM CA_Province c WHERE c.engdesc = :engdesc"),
  @NamedQuery(name = "CA_Province.findByFrndesc", query = "SELECT c FROM CA_Province c WHERE c.frndesc = :frndesc")})
public class CA_Province implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected CA_ProvincePK cA_ProvincePK;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "low_lat", precision = 12)
  @XmlAttribute
  private Float lowLat;
  @Column(name = "high_lat", precision = 12)
  @XmlAttribute
  private Float highLat;
  @Column(name = "low_long", precision = 12)
  @XmlAttribute
  private Float lowLong;
  @Column(name = "high_long", precision = 12)
  @XmlAttribute
  private Float highLong;
  @Column(name = "creat_dt", precision = 12)
  @XmlAttribute
  private Float creatDt;
  @Column(name = "mod_dt", precision = 12)
  @XmlAttribute
  private Float modDt;
  @Column(length = 25)
  @XmlAttribute
  private String engdesc;
  @Column(length = 25)
  @XmlAttribute
  private String frndesc;
  @OneToMany(mappedBy = "province")
  private List<SDars> sDarsList;
  @OneToMany(mappedBy = "province")
  private List<TvStation> tvStationList;
  @OneToMany(mappedBy = "province")
  private List<FmStation> fmStationList;
  @OneToMany(mappedBy = "province")
  private List<AmStation> amStationList;

  public CA_Province() {
  }

  public CA_Province(CA_ProvincePK cA_ProvincePK) {
    this.cA_ProvincePK = cA_ProvincePK;
  }

  public CA_Province(String province, String country) {
    this.cA_ProvincePK = new CA_ProvincePK(province, country);
  }

  public CA_ProvincePK getCA_ProvincePK() {
    return cA_ProvincePK;
  }

  public void setCA_ProvincePK(CA_ProvincePK cA_ProvincePK) {
    this.cA_ProvincePK = cA_ProvincePK;
  }

  public Float getLowLat() {
    return lowLat;
  }

  public void setLowLat(Float lowLat) {
    this.lowLat = lowLat;
  }

  public Float getHighLat() {
    return highLat;
  }

  public void setHighLat(Float highLat) {
    this.highLat = highLat;
  }

  public Float getLowLong() {
    return lowLong;
  }

  public void setLowLong(Float lowLong) {
    this.lowLong = lowLong;
  }

  public Float getHighLong() {
    return highLong;
  }

  public void setHighLong(Float highLong) {
    this.highLong = highLong;
  }

  public Float getCreatDt() {
    return creatDt;
  }

  public void setCreatDt(Float creatDt) {
    this.creatDt = creatDt;
  }

  public Float getModDt() {
    return modDt;
  }

  public void setModDt(Float modDt) {
    this.modDt = modDt;
  }

  public String getEngdesc() {
    return engdesc;
  }

  public void setEngdesc(String engdesc) {
    this.engdesc = engdesc;
  }

  public String getFrndesc() {
    return frndesc;
  }

  public void setFrndesc(String frndesc) {
    this.frndesc = frndesc;
  }


  public List<SDars> getSDarsList() {
    return sDarsList;
  }

  public void setSDarsList(List<SDars> sDarsList) {
    this.sDarsList = sDarsList;
  }


  public List<TvStation> getTvStationList() {
    return tvStationList;
  }

  public void setTvStationList(List<TvStation> tvStationList) {
    this.tvStationList = tvStationList;
  }


  public List<FmStation> getFmStationList() {
    return fmStationList;
  }

  public void setFmStationList(List<FmStation> fmStationList) {
    this.fmStationList = fmStationList;
  }


  public List<AmStation> getAmStationList() {
    return amStationList;
  }

  public void setAmStationList(List<AmStation> amStationList) {
    this.amStationList = amStationList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (cA_ProvincePK != null ? cA_ProvincePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CA_Province)) {
      return false;
    }
    CA_Province other = (CA_Province) object;
    if ((this.cA_ProvincePK == null && other.cA_ProvincePK != null) || (this.cA_ProvincePK != null && !this.cA_ProvincePK.equals(other.cA_ProvincePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.CA_Province[ cA_ProvincePK=" + cA_ProvincePK + " ]";
  }
}
