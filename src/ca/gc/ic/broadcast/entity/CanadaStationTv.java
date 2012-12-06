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

import ca.gc.ic.broadcast.entity.enumerated.Enum_Banner;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.*;

/**
 *
 * @author jesse
 */
@Entity
@DiscriminatorValue("tv_station")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
public class CanadaStationTv extends CanadaStation {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  @Basic(optional = false)
  @Column(name = "erpvpk", nullable = false)
  @XmlAttribute(required = true)
  private Double erpvpk;
  @Column(name = "alloc_zone")
  @XmlAttribute
  private int allocZone;
  @Column(name = "ant_mode")
  @XmlAttribute(required = true)
  private Character antMode;
  @Column(name = "beam_tilt", precision = 12)
  @XmlAttribute
  private Double beamTilt;
  @Column(name = "close_cap")
  @XmlAttribute
  private Character closeCap;
  @Basic(optional = false)
  @Column(name = "ehaat", nullable = false)
  @XmlAttribute
  private Double ehaat;
  @Column(name = "erpaav", precision = 12)
  @XmlAttribute
  private Double erpaav;
  @Column(name = "erpapk", precision = 12)
  @XmlAttribute
  private Double erpapk;
  @Column(name = "erpata")
  @XmlAttribute
  private int erpata;
  @Column(name = "erpvav", precision = 12)
  @XmlAttribute
  private Double erpvav;
  @Column(name = "erpvta", precision = 12)
  @XmlAttribute
  private Double erpvta;
  @Column(name = "ground_lev", precision = 12)
  @XmlAttribute
  private Double groundLev;
  @Column(name = "limit_code", length = 8)
  @XmlAttribute
  private String limitCode;
  @Column(name = "off_prec")
  @XmlAttribute
  private Character offPrec;
  @Column(name = "offset")
  @XmlAttribute
  private Character offset;
  @Column(name = "overall_h", precision = 12)
  @XmlAttribute
  private Double overallH;
  @Column(name = "rad_center", precision = 12)
  @XmlAttribute
  private Double radCenter;

  public CanadaStationTv() {
  }

  public CanadaStationTv(CanadaStationPK canadaStationPK) {
    this.canadaStationPK = canadaStationPK;
  }

  public CanadaStationTv(Enum_Banner banner, String callSign) {
    this.canadaStationPK = new CanadaStationPK(banner, callSign);
  }

  //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
  public Double getErpvpk() {
    return erpvpk;
  }

  public void setErpvpk(Double erpvpk) {
    this.erpvpk = erpvpk;
  }

  public int getAllocZone() {
    return allocZone;
  }

  public void setAllocZone(int allocZone) {
    this.allocZone = allocZone;
  }

  public Character getAntMode() {
    return antMode;
  }

  public void setAntMode(Character antMode) {
    this.antMode = antMode;
  }

  public Double getBeamTilt() {
    return beamTilt;
  }

  public void setBeamTilt(Double beamTilt) {
    this.beamTilt = beamTilt;
  }

  public Character getCloseCap() {
    return closeCap;
  }

  public void setCloseCap(Character closeCap) {
    this.closeCap = closeCap;
  }

  public Double getEhaat() {
    return ehaat;
  }

  public void setEhaat(Double ehaat) {
    this.ehaat = ehaat;
  }

  public Double getErpaav() {
    return erpaav;
  }

  public void setErpaav(Double erpaav) {
    this.erpaav = erpaav;
  }

  public Double getErpapk() {
    return erpapk;
  }

  public void setErpapk(Double erpapk) {
    this.erpapk = erpapk;
  }

  public int getErpata() {
    return erpata;
  }

  public void setErpata(int erpata) {
    this.erpata = erpata;
  }

  public Double getErpvav() {
    return erpvav;
  }

  public void setErpvav(Double erpvav) {
    this.erpvav = erpvav;
  }

  public Double getErpvta() {
    return erpvta;
  }

  public void setErpvta(Double erpvta) {
    this.erpvta = erpvta;
  }

  public Double getGroundLev() {
    return groundLev;
  }

  public void setGroundLev(Double groundLev) {
    this.groundLev = groundLev;
  }

  public String getLimitCode() {
    return limitCode;
  }

  public void setLimitCode(String limitCode) {
    this.limitCode = limitCode;
  }

  public Character getOffPrec() {
    return offPrec;
  }

  public void setOffPrec(Character offPrec) {
    this.offPrec = offPrec;
  }

  public Character getOffset() {
    return offset;
  }

  public void setOffset(Character offset) {
    this.offset = offset;
  }

  public Double getOverallH() {
    return overallH;
  }

  public void setOverallH(Double overallH) {
    this.overallH = overallH;
  }

  public Double getRadCenter() {
    return radCenter;
  }

  public void setRadCenter(Double radCenter) {
    this.radCenter = radCenter;
  }//</editor-fold>

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (canadaStationPK != null ? canadaStationPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof CanadaStationTv)) {
      return false;
    }
    CanadaStationTv other = (CanadaStationTv) object;
    if ((this.canadaStationPK == null && other.canadaStationPK != null) || (this.canadaStationPK != null && !this.canadaStationPK.equals(other.canadaStationPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "CanadaStationTv"
      + super.toString()
      + "\n] erpvpk [" + erpvpk
      + "] allocZone [" + allocZone
      + "] antMode [" + antMode
      + "] beamTilt [" + beamTilt
      + "] closeCap [" + closeCap
      + "] erpaav [" + erpaav
      + "] erpapk [" + erpapk
      + "] erpata [" + erpata
      + "] erpvav [" + erpvav
      + "] erpvta [" + erpvta
      + "] groundLev [" + groundLev
      + "] limitCode [" + limitCode
      + "] offPrec [" + offPrec
      + "] offset [" + offset
      + "] overallH [" + overallH
      + "] radCenter [" + radCenter
      + ']';
  }
}
