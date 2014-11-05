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
  private Double erpvpk;
  @Column(name = "ant_mode")
  @XmlAttribute(required = true)
  private Character antMode;
  @Column(name = "auto_prog", length = 1)
  @XmlAttribute
  private String autoProg;
  @Column(name = "beam_tilt", precision = 12)
  @XmlAttribute
  private Double beamTilt;
  @Basic(optional = false)
  @Column(name = "ehaat", nullable = false)
  @XmlAttribute
  private Double ehaat;
  @Column(name = "erphav", precision = 12)
  @XmlAttribute
  private Double erphav;
  @Column(name = "erphpk", precision = 12)
  @XmlAttribute
  private Double erphpk;
  @Column(name = "erpvav", precision = 12)
  @XmlAttribute
  private Double erpvav;
  @Column(name = "ground_lev", precision = 12)
  @XmlAttribute
  private Double groundLev;
  @Column(name = "overall_h", precision = 12)
  @XmlAttribute
  private Double overallH;
  @Column(name = "rad_center", precision = 12)
  @XmlAttribute
  private Double radCenter;
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
  public Double getErpvpk() {
    return erpvpk;
  }

  public void setErpvpk(Double erpvpk) {
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

  public Double getBeamTilt() {
    return beamTilt;
  }

  public void setBeamTilt(Double beamTilt) {
    this.beamTilt = beamTilt;
  }

  public Double getEhaat() {
    return ehaat;
  }

  public void setEhaat(Double ehaat) {
    this.ehaat = ehaat;
  }

  public Double getErphav() {
    return erphav;
  }

  public void setErphav(Double erphav) {
    this.erphav = erphav;
  }

  public Double getErphpk() {
    return erphpk;
  }

  public void setErphpk(Double erphpk) {
    this.erphpk = erphpk;
  }

  public Double getErpvav() {
    return erpvav;
  }

  public void setErpvav(Double erpvav) {
    this.erpvav = erpvav;
  }

  public Double getGroundLev() {
    return groundLev;
  }

  public void setGroundLev(Double groundLev) {
    this.groundLev = groundLev;
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
