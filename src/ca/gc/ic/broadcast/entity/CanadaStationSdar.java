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

import ca.gc.ic.broadcast.entity.enumerated.ECanadaBanner;
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
@DiscriminatorValue("SDAR")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
public class CanadaStationSdar extends CanadaStation {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  @Basic(optional = false)
  @Column(name = "erpvpk", nullable = false)
  @XmlAttribute(required = true)
  private double erpvpk;
  @Column(name = "alloc_zone")
  @XmlAttribute
  private int allocZone;
  @Column(name = "ant_mode")
  @XmlAttribute(required = true)
  private Character antMode;
  @Column(name = "beam_tilt", precision = 12)
  @XmlAttribute
  private double beamTilt;
  @Column(name = "close_cap")
  @XmlAttribute
  private Character closeCap;
  @Basic(optional = false)
  @Column(name = "ehaat", nullable = false)
  @XmlAttribute
  private double ehaat;
  @Column(name = "erpaav", precision = 12)
  @XmlAttribute
  private double erpaav;
  @Column(name = "erpapk", precision = 12)
  @XmlAttribute
  private double erpapk;
  @Column(name = "erpata")
  @XmlAttribute
  private int erpata;
  @Column(name = "erpvav", precision = 12)
  @XmlAttribute
  private double erpvav;
  @Column(name = "erpvta", precision = 12)
  @XmlAttribute
  private double erpvta;
  @Column(name = "ground_lev", precision = 12)
  @XmlAttribute
  private double groundLev;
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
  private double overallH;
  @Column(name = "rad_center", precision = 12)
  @XmlAttribute
  private double radCenter;

  public CanadaStationSdar() {
  }

  public CanadaStationSdar(CanadaStationPK canadaStationPK) {
    this.canadaStationPK = canadaStationPK;
  }

  public CanadaStationSdar(ECanadaBanner banner, String callSign) {
    this.canadaStationPK = new CanadaStationPK(banner, callSign);
  }

  //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
  public double getErpvpk() {
    return erpvpk;
  }

  public void setErpvpk(double erpvpk) {
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

  public double getBeamTilt() {
    return beamTilt;
  }

  public void setBeamTilt(double beamTilt) {
    this.beamTilt = beamTilt;
  }

  public Character getCloseCap() {
    return closeCap;
  }

  public void setCloseCap(Character closeCap) {
    this.closeCap = closeCap;
  }

  public double getEhaat() {
    return ehaat;
  }

  public void setEhaat(double ehaat) {
    this.ehaat = ehaat;
  }

  public double getErpaav() {
    return erpaav;
  }

  public void setErpaav(double erpaav) {
    this.erpaav = erpaav;
  }

  public double getErpapk() {
    return erpapk;
  }

  public void setErpapk(double erpapk) {
    this.erpapk = erpapk;
  }

  public int getErpata() {
    return erpata;
  }

  public void setErpata(int erpata) {
    this.erpata = erpata;
  }

  public double getErpvav() {
    return erpvav;
  }

  public void setErpvav(double erpvav) {
    this.erpvav = erpvav;
  }

  public double getErpvta() {
    return erpvta;
  }

  public void setErpvta(double erpvta) {
    this.erpvta = erpvta;
  }

  public double getGroundLev() {
    return groundLev;
  }

  public void setGroundLev(double groundLev) {
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

  public double getOverallH() {
    return overallH;
  }

  public void setOverallH(double overallH) {
    this.overallH = overallH;
  }

  public double getRadCenter() {
    return radCenter;
  }

  public void setRadCenter(double radCenter) {
    this.radCenter = radCenter;
  }//</editor-fold>

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
