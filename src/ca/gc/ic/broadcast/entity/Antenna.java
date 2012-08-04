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
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jesse
 */
@Entity
@Table(name = "apatdesc")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Antenna.findAll", query = "SELECT a FROM Antenna a"),
  @NamedQuery(name = "Antenna.findByPattKey", query = "SELECT a FROM Antenna a WHERE a.pattKey = :pattKey"),
  @NamedQuery(name = "Antenna.findByHorVer", query = "SELECT a FROM Antenna a WHERE a.horVer = :horVer"),
  @NamedQuery(name = "Antenna.findByPattNumb", query = "SELECT a FROM Antenna a WHERE a.pattNumb = :pattNumb"),
  @NamedQuery(name = "Antenna.findByPattType", query = "SELECT a FROM Antenna a WHERE a.pattType = :pattType"),
  @NamedQuery(name = "Antenna.findByPunits", query = "SELECT a FROM Antenna a WHERE a.punits = :punits"),
  @NamedQuery(name = "Antenna.findByNumpoints", query = "SELECT a FROM Antenna a WHERE a.numpoints = :numpoints"),
  @NamedQuery(name = "Antenna.findByPattDate", query = "SELECT a FROM Antenna a WHERE a.pattDate = :pattDate")})
public class Antenna implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "patt_key", nullable = false)
  private Integer pattKey;
  @Column(name = "hor_ver", length = 1)
  private String horVer;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "patt_numb", precision = 12)
  private float pattNumb;
  @Column(name = "patt_type", length = 12)
  private String pattType;
  @Column(name = "punits", precision = 12)
  private float punits;
  @Column(name = "numpoints", precision = 12)
  private float numpoints;
  @Column(name = "patt_date", precision = 12)
  private float pattDate;
  @JoinTable(name = "apatstat", joinColumns = {
    @JoinColumn(name = "patt_key", referencedColumnName = "patt_key")}, inverseJoinColumns = {
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign"),
    @JoinColumn(name = "banner", referencedColumnName = "banner")})
  @ManyToMany
  private List<CanadaStation> canadaStationList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "antenna")
  private List<RadiationPattern> radiationPatternList;

  public Antenna() {
  }

  public Antenna(int pattKey) {
    this.pattKey = pattKey;
  }

  public Integer getPattKey() {
    return pattKey;
  }

  public void setPattKey(Integer pattKey) {
    this.pattKey = pattKey;
  }

  public String getHorVer() {
    return horVer;
  }

  public void setHorVer(String horVer) {
    this.horVer = horVer;
  }

  public float getPattNumb() {
    return pattNumb;
  }

  public void setPattNumb(float pattNumb) {
    this.pattNumb = pattNumb;
  }

  public String getPattType() {
    return pattType;
  }

  public void setPattType(String pattType) {
    this.pattType = pattType;
  }

  public float getPunits() {
    return punits;
  }

  public void setPunits(float punits) {
    this.punits = punits;
  }

  public float getNumpoints() {
    return numpoints;
  }

  public void setNumpoints(float numpoints) {
    this.numpoints = numpoints;
  }

  public float getPattDate() {
    return pattDate;
  }

  public void setPattDate(float pattDate) {
    this.pattDate = pattDate;
  }

  @XmlTransient
  public List<CanadaStation> getCanadaStationList() {
    return canadaStationList;
  }

  public void setCanadaStationList(List<CanadaStation> canadaStationList) {
    this.canadaStationList = canadaStationList;
  }

  @XmlTransient
  public List<RadiationPattern> getRadiationPatternList() {
    return radiationPatternList;
  }

  public void setRadiationPatternList(List<RadiationPattern> radiationPatternList) {
    this.radiationPatternList = radiationPatternList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (pattKey != null ? pattKey.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Antenna)) {
      return false;
    }
    Antenna other = (Antenna) object;
    if ((this.pattKey == null && other.pattKey != null) || (this.pattKey != null && !this.pattKey.equals(other.pattKey))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.Antenna[ pattKey=" + pattKey + " ]";
  }
}
