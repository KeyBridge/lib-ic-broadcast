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
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Compound primary key for the Canada TSID table.
 * <p/>
 * @author jesse
 */
@Embeddable
@XmlAccessorType(XmlAccessType.FIELD)
public class TsidPK implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  @Basic(optional = false)
  @Column(name = "call_sign", nullable = false, length = 12)
  @XmlAttribute(required = true)
  private String callSign;
  @Basic(optional = false)
  @Column(name = "banner", nullable = false, length = 2)
  @XmlAttribute(required = true)
  @Enumerated(EnumType.STRING)
  private ECanadaBanner banner;

  public TsidPK() {
  }

  public TsidPK(String callSign, ECanadaBanner banner) {
    this.callSign = callSign;
    this.banner = banner;
  }

  public String getCallSign() {
    return callSign;
  }

  public void setCallSign(String callSign) {
    this.callSign = callSign;
  }

  public ECanadaBanner getBanner() {
    return banner;
  }

  public void setBanner(ECanadaBanner banner) {
    this.banner = banner;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 29 * hash + Objects.hashCode(this.callSign);
    hash = 29 * hash + (this.banner != null ? this.banner.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final TsidPK other = (TsidPK) obj;
    if (!Objects.equals(this.callSign, other.callSign)) {
      return false;
    }
    if (this.banner != other.banner) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.TsidPK[ callSign=" + callSign + ", banner=" + banner + " ]";
  }
}
