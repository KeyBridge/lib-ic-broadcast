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

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jesse
 */
@Embeddable
@XmlAccessorType(XmlAccessType.FIELD)
public class AmStationParameterPK implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;

  @Basic(optional = false)
  @Column(name = "calls_banr", nullable = false, length = 32)
  @XmlTransient
  private String callsBanr;
  @Basic(optional = false)
  @Column(name = "dnc_code", nullable = false, length = 1)
  @XmlAttribute
  private String dncCode;
  @Basic(optional = false)
  @Column(name = "tower_numb", nullable = false)
  @XmlAttribute
  private int towerNumb;

  public AmStationParameterPK() {
  }

  public AmStationParameterPK(String callsBanr, String dncCode, int towerNumb) {
    this.callsBanr = callsBanr;
    this.dncCode = dncCode;
    this.towerNumb = towerNumb;
  }

  public String getCallsBanr() {
    return callsBanr;
  }

  public void setCallsBanr(String callsBanr) {
    this.callsBanr = callsBanr;
  }

  public String getDncCode() {
    return dncCode;
  }

  public void setDncCode(String dncCode) {
    this.dncCode = dncCode;
  }

  public int getTowerNumb() {
    return towerNumb;
  }

  public void setTowerNumb(int towerNumb) {
    this.towerNumb = towerNumb;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (callsBanr != null ? callsBanr.hashCode() : 0);
    hash += (dncCode != null ? dncCode.hashCode() : 0);
    hash += (int) towerNumb;
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    if (!(object instanceof AmStationParameterPK)) {
      return false;
    }
    AmStationParameterPK other = (AmStationParameterPK) object;
    if ((this.callsBanr == null && other.callsBanr != null) || (this.callsBanr != null && !this.callsBanr.equals(other.callsBanr))) {
      return false;
    }
    if ((this.dncCode == null && other.dncCode != null) || (this.dncCode != null && !this.dncCode.equals(other.dncCode))) {
      return false;
    }
    if (this.towerNumb != other.towerNumb) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.AmStationParameterPK[ callsBanr=" + callsBanr + ", dncCode=" + dncCode + ", towerNumb=" + towerNumb + " ]";
  }
}
