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
@DiscriminatorValue("fm_station")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
public class CanadaStationFm extends CanadaStation {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  @Basic(optional = false)
  @Column(name = "erpvpk", nullable = false)
  @XmlAttribute(required = true)
  private float erpvpk;
  @Basic(optional = false)
  @Column(name = "haat", nullable = false)
  @XmlAttribute
  private float haat;


  @Column(name = "ant_mode")
  @XmlAttribute(required = true)
  private Character antMode;
  @Column(name = "auto_prog", length = 1)
  @XmlAttribute
  private String autoProg;

  @Column(name = "beam_tilt", precision = 12)
  @XmlAttribute
  private float beamTilt;


  @Column(name = "erphav", precision = 12)
  @XmlAttribute
  private float erphav;
  @Column(name = "erphpk", precision = 12)
  @XmlAttribute
  private float erphpk;
  @Column(name = "erpvav", precision = 12)
  @XmlAttribute
  private float erpvav;
  @Column(name = "ground_lev", precision = 12)
  @XmlAttribute
  private float groundLev;
  @Column(name = "overall_h", precision = 12)
  @XmlAttribute
  private float overallH;
  @Column(name = "rad_center", precision = 12)
  @XmlAttribute
  private float radCenter;
  @Column(name = "scmo")
  @XmlAttribute
  private Character scmo;

  public CanadaStationFm() {
  }

  public CanadaStationFm(CanadaStationPK canadaStationPK) {
    this.canadaStationPK = canadaStationPK;
  }

  public CanadaStationFm(Enum_Banner banner, String callSign) {
    this.canadaStationPK = new CanadaStationPK(banner, callSign);
  }

  //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
  public float getErpvpk() {
    return erpvpk;
  }

  public void setErpvpk(float erpvpk) {
    this.erpvpk = erpvpk;
  }

  public float getHaat() {
    return haat;
  }

  public void setHaat(float haat) {
    this.haat = haat;
  }

  public Character getAntMode() {
    return antMode;
  }

  public void setAntMode(Character antMode) {
    this.antMode = antMode;
  }

  public String getAutoProg() {
    return autoProg;
  }

  public void setAutoProg(String autoProg) {
    this.autoProg = autoProg;
  }

  public float getBeamTilt() {
    return beamTilt;
  }

  public void setBeamTilt(float beamTilt) {
    this.beamTilt = beamTilt;
  }

  public float getErphav() {
    return erphav;
  }

  public void setErphav(float erphav) {
    this.erphav = erphav;
  }

  public float getErphpk() {
    return erphpk;
  }

  public void setErphpk(float erphpk) {
    this.erphpk = erphpk;
  }

  public float getErpvav() {
    return erpvav;
  }

  public void setErpvav(float erpvav) {
    this.erpvav = erpvav;
  }

  public float getGroundLev() {
    return groundLev;
  }

  public void setGroundLev(float groundLev) {
    this.groundLev = groundLev;
  }

  public float getOverallH() {
    return overallH;
  }

  public void setOverallH(float overallH) {
    this.overallH = overallH;
  }

  public float getRadCenter() {
    return radCenter;
  }

  public void setRadCenter(float radCenter) {
    this.radCenter = radCenter;
  }

  public Character getScmo() {
    return scmo;
  }

  public void setScmo(Character scmo) {
    this.scmo = scmo;
  }//</editor-fold>

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (canadaStationPK != null ? canadaStationPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof CanadaStationFm)) {
      return false;
    }
    CanadaStationFm other = (CanadaStationFm) object;
    if ((this.canadaStationPK == null && other.canadaStationPK != null) || (this.canadaStationPK != null && !this.canadaStationPK.equals(other.canadaStationPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "CanadaStationFm"
            + super.toString()
            + "] autoProg [" + autoProg
            + "] scmo [" + scmo
            + "] erpvpk [" + erpvpk
            + "] haat [" + haat
            + "] antMode [" + antMode
            + "] beamTilt [" + beamTilt
            + "] erphav [" + erphav
            + "] erphpk [" + erphpk
            + "] erpvav [" + erpvav
            + "] groundLev [" + groundLev
            + "] overallH [" + overallH
            + "] radCenter [" + radCenter
            + ']';
  }
}
