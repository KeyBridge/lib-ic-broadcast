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
package ca.gc.ic.lib.bdbs.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jesse
 */
@Embeddable
@XmlAccessorType(XmlAccessType.FIELD)
public class ContourPK implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  @Basic(optional = false)
  @Column(name = "calls_banr", nullable = false, length = 32)
  @XmlElement
  private String callsBanr;
  @Basic(optional = false)
  @Column(name = "azimuth", nullable = false)
  @XmlElement
  private double azimuth;
  @Basic(optional = false)
  @Column(name = "valu_dist", nullable = false)
  @XmlElement
  private double valuDist;

  public ContourPK() {
  }

  public ContourPK(String callsBanr, double azimuth, double valuDist) {
    this.callsBanr = callsBanr;
    this.azimuth = azimuth;
    this.valuDist = valuDist;
  }

  public String getCallsBanr() {
    return callsBanr;
  }

  public void setCallsBanr(String callsBanr) {
    this.callsBanr = callsBanr;
  }

  public double getAzimuth() {
    return azimuth;
  }

  public void setAzimuth(double azimuth) {
    this.azimuth = azimuth;
  }

  public double getValuDist() {
    return valuDist;
  }

  public void setValuDist(double valuDist) {
    this.valuDist = valuDist;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (callsBanr != null ? callsBanr.hashCode() : 0);
    hash += (int) azimuth;
    hash += (int) valuDist;
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    if (!(object instanceof ContourPK)) {
      return false;
    }
    ContourPK other = (ContourPK) object;
    if ((this.callsBanr == null && other.callsBanr != null) || (this.callsBanr != null && !this.callsBanr.equals(other.callsBanr))) {
      return false;
    }
    if (this.azimuth != other.azimuth) {
      return false;
    }
    if (this.valuDist != other.valuDist) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.ContourPK[ callsBanr=" + callsBanr + ", azimuth=" + azimuth + ", valuDist=" + valuDist + " ]";
  }
}
