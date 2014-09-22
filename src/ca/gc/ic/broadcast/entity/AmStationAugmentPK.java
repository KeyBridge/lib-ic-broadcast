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
public class AmStationAugmentPK implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  @Basic(optional = false)
  @Column(name = "calls_banr", nullable = false, length = 32)
  @XmlAttribute
  private String callsBanr;
  @Basic(optional = false)
  @Column(name = "dnc_code", nullable = false, length = 1)
  @XmlAttribute
  private String dncCode;
  @Basic(optional = false)
  @Column(name = "number", nullable = false)
  @XmlAttribute
  private double number;

  public AmStationAugmentPK() {
  }

  public AmStationAugmentPK(String callsBanr, String dncCode, double number) {
    this.callsBanr = callsBanr;
    this.dncCode = dncCode;
    this.number = number;
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

  public double getNumber() {
    return number;
  }

  public void setNumber(double number) {
    this.number = number;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (callsBanr != null ? callsBanr.hashCode() : 0);
    hash += (dncCode != null ? dncCode.hashCode() : 0);
    hash += (int) number;
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    if (!(object instanceof AmStationAugmentPK)) {
      return false;
    }
    AmStationAugmentPK other = (AmStationAugmentPK) object;
    if ((this.callsBanr == null && other.callsBanr != null) || (this.callsBanr != null && !this.callsBanr.equals(other.callsBanr))) {
      return false;
    }
    if ((this.dncCode == null && other.dncCode != null) || (this.dncCode != null && !this.dncCode.equals(other.dncCode))) {
      return false;
    }
    if (this.number != other.number) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.AmStationAugmentPK[ callsBanr=" + callsBanr + ", dncCode=" + dncCode + ", number=" + number + " ]";
  }
}
