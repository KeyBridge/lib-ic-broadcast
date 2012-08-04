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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jesse
 */
@Entity
@Table(name = "augment")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "AmStationAugment.findAll", query = "SELECT a FROM AmStationAugment a"),
  @NamedQuery(name = "AmStationAugment.findByCallsBanr", query = "SELECT a FROM AmStationAugment a WHERE a.amStationAugmentPK.callsBanr = :callsBanr"),
  @NamedQuery(name = "AmStationAugment.findByDncCode", query = "SELECT a FROM AmStationAugment a WHERE a.amStationAugmentPK.dncCode = :dncCode"),
  @NamedQuery(name = "AmStationAugment.findByNumber", query = "SELECT a FROM AmStationAugment a WHERE a.amStationAugmentPK.number = :number"),
  @NamedQuery(name = "AmStationAugment.findByRadiation", query = "SELECT a FROM AmStationAugment a WHERE a.radiation = :radiation"),
  @NamedQuery(name = "AmStationAugment.findByCenterAz", query = "SELECT a FROM AmStationAugment a WHERE a.centerAz = :centerAz"),
  @NamedQuery(name = "AmStationAugment.findBySpan", query = "SELECT a FROM AmStationAugment a WHERE a.span = :span")})
public class AmStationAugment implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected AmStationAugmentPK amStationAugmentPK;
  @Column(name = "radiation")
  private Integer radiation;
  @Column(name = "center_az")
  private Integer centerAz;
  @Column(name = "span")
  private Integer span;
  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign"),
    @JoinColumn(name = "banner", referencedColumnName = "banner")})
  @ManyToOne
  private CanadaStation canadaStation;

  public AmStationAugment() {
  }

  public AmStationAugment(AmStationAugmentPK amStationAugmentPK) {
    this.amStationAugmentPK = amStationAugmentPK;
  }

  public AmStationAugment(String callsBanr, String dncCode, float number) {
    this.amStationAugmentPK = new AmStationAugmentPK(callsBanr, dncCode, number);
  }

  public AmStationAugmentPK getAmStationAugmentPK() {
    return amStationAugmentPK;
  }

  public void setAmStationAugmentPK(AmStationAugmentPK amStationAugmentPK) {
    this.amStationAugmentPK = amStationAugmentPK;
  }

  public Integer getRadiation() {
    return radiation;
  }

  public void setRadiation(Integer radiation) {
    this.radiation = radiation;
  }

  public Integer getCenterAz() {
    return centerAz;
  }

  public void setCenterAz(Integer centerAz) {
    this.centerAz = centerAz;
  }

  public Integer getSpan() {
    return span;
  }

  public void setSpan(Integer span) {
    this.span = span;
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
    hash += (amStationAugmentPK != null ? amStationAugmentPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof AmStationAugment)) {
      return false;
    }
    AmStationAugment other = (AmStationAugment) object;
    if ((this.amStationAugmentPK == null && other.amStationAugmentPK != null) || (this.amStationAugmentPK != null && !this.amStationAugmentPK.equals(other.amStationAugmentPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.AmStationAugment[ amStationAugmentPK=" + amStationAugmentPK + " ]";
  }

}
