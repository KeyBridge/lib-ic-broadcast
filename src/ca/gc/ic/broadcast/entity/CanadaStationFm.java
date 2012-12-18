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
@DiscriminatorValue("FM")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
public class CanadaStationFm extends CanadaStation {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  @Basic(optional = false)
  @Column(name = "erpvpk", nullable = false)
  @XmlAttribute(required = true)
  private double erpvpk;
  @Column(name = "ant_mode")
  @XmlAttribute(required = true)
  private Character antMode;
  @Column(name = "auto_prog", length = 1)
  @XmlAttribute
  private String autoProg;
  @Column(name = "beam_tilt", precision = 12)
  @XmlAttribute
  private double beamTilt;
  @Basic(optional = false)
  @Column(name = "ehaat", nullable = false)
  @XmlAttribute
  private double ehaat;
  @Column(name = "erphav", precision = 12)
  @XmlAttribute
  private double erphav;
  @Column(name = "erphpk", precision = 12)
  @XmlAttribute
  private double erphpk;
  @Column(name = "erpvav", precision = 12)
  @XmlAttribute
  private double erpvav;
  @Column(name = "ground_lev", precision = 12)
  @XmlAttribute
  private double groundLev;
  @Column(name = "overall_h", precision = 12)
  @XmlAttribute
  private double overallH;
  @Column(name = "rad_center", precision = 12)
  @XmlAttribute
  private double radCenter;
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
  public double getErpvpk() {
    return erpvpk;
  }

  public void setErpvpk(double erpvpk) {
    this.erpvpk = erpvpk;
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

  public double getBeamTilt() {
    return beamTilt;
  }

  public void setBeamTilt(double beamTilt) {
    this.beamTilt = beamTilt;
  }

  public double getEhaat() {
    return ehaat;
  }

  public void setEhaat(double ehaat) {
    this.ehaat = ehaat;
  }

  public double getErphav() {
    return erphav;
  }

  public void setErphav(double erphav) {
    this.erphav = erphav;
  }

  public double getErphpk() {
    return erphpk;
  }

  public void setErphpk(double erphpk) {
    this.erphpk = erphpk;
  }

  public double getErpvav() {
    return erpvav;
  }

  public void setErpvav(double erpvav) {
    this.erpvav = erpvav;
  }

  public double getGroundLev() {
    return groundLev;
  }

  public void setGroundLev(double groundLev) {
    this.groundLev = groundLev;
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
