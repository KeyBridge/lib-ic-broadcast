/* 
 * Copyright (C) 2014 Jesse Caulfield <jesse@caulfield.org>
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

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author jesse
 */
@Entity
@Table(name = "augment")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "AmStationAugment.findAll", query = "SELECT a FROM AmStationAugment a"),
  @NamedQuery(name = "AmStationAugment.findByCallsBanr", query = "SELECT a FROM AmStationAugment a WHERE a.amStationAugmentPK.callsBanr = :callsBanr"),
  @NamedQuery(name = "AmStationAugment.findByDncCode", query = "SELECT a FROM AmStationAugment a WHERE a.amStationAugmentPK.dncCode = :dncCode"),
  @NamedQuery(name = "AmStationAugment.findByNumber", query = "SELECT a FROM AmStationAugment a WHERE a.amStationAugmentPK.number = :number"),
  @NamedQuery(name = "AmStationAugment.findByRadiation", query = "SELECT a FROM AmStationAugment a WHERE a.radiation = :radiation"),
  @NamedQuery(name = "AmStationAugment.findByCenterAz", query = "SELECT a FROM AmStationAugment a WHERE a.centerAz = :centerAz"),
  @NamedQuery(name = "AmStationAugment.findBySpan", query = "SELECT a FROM AmStationAugment a WHERE a.span = :span")})
public class AmStationAugment implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected AmStationAugmentPK amStationAugmentPK;
  @Column(name = "radiation")
  @XmlAttribute
  private int radiation;
  @Column(name = "center_az")
  @XmlAttribute
  private int centerAz;
  @Column(name = "span")
  @XmlAttribute
  private int span;
  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign"),
    @JoinColumn(name = "banner", referencedColumnName = "banner")})
  @ManyToOne
  @XmlTransient
  private CanadaStation canadaStation;

  public AmStationAugment() {
  }

  public AmStationAugment(AmStationAugmentPK amStationAugmentPK) {
    this.amStationAugmentPK = amStationAugmentPK;
  }

  public AmStationAugment(String callsBanr, String dncCode, double number) {
    this.amStationAugmentPK = new AmStationAugmentPK(callsBanr, dncCode, number);
  }

  public AmStationAugmentPK getAmStationAugmentPK() {
    return amStationAugmentPK;
  }

  public void setAmStationAugmentPK(AmStationAugmentPK amStationAugmentPK) {
    this.amStationAugmentPK = amStationAugmentPK;
  }

  public int getRadiation() {
    return radiation;
  }

  public void setRadiation(int radiation) {
    this.radiation = radiation;
  }

  public int getCenterAz() {
    return centerAz;
  }

  public void setCenterAz(int centerAz) {
    this.centerAz = centerAz;
  }

  public int getSpan() {
    return span;
  }

  public void setSpan(int span) {
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
