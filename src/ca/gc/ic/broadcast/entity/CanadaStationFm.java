/* 
 * Copyright (C) 2014 Key Bridge Global LLC 
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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

  public CanadaStationFm(ECanadaBanner banner, String callSign) {
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
  public String toStringFull() {
    return "CanadaStationFm"
      + super.toString()
      + " autoProg [" + autoProg
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
