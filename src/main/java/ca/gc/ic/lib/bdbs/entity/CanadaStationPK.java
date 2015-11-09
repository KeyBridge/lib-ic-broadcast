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

import ca.gc.ic.lib.bdbs.entity.enumerated.ECanadaBanner;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Logical data model container for the CANADA CanadaStation (ca_station)
 * compound primary key.
 *
 * @author jesse
 */
@Embeddable
@XmlAccessorType(XmlAccessType.FIELD)
public class CanadaStationPK implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  /**
   * The Industry Canada station banner code.
   * <p>
   * The Banner's <code>transmitting</code> field can be interrogated to
   * determine whether the station is on or off air. TRUE means the station is
   * transmitting and should be protected.
   * <p>
   * Depending upon the type of service the following Banner codes are
   * transmitting: <code>[AP, AU, O, OP, TO]</code>.
   */
  @Enumerated(EnumType.STRING)
  @Basic(optional = false)
  @Column(name = "banner", nullable = false, length = 2)
  @XmlElement(required = true)
  private ECanadaBanner banner;
  /**
   * The station call sign. All Canadian station call signs begin with the
   * letter 'C'.
   */
  @Basic(optional = false)
  @Column(name = "call_sign", nullable = false, length = 12)
  @XmlElement(required = true)
  private String callSign;

  public CanadaStationPK() {
  }

  public CanadaStationPK(ECanadaBanner banner, String callSign) {
    this.banner = banner;
    this.callSign = callSign;
  }

  /**
   * Constructor taking the serialized (toString) output from another
   * CanadaStationPK. This enables the convenient serialization and
   * unmarshalling of CanadaStationPK objects.
   *
   * @param canadaStationPkString the toString output of a CanadaStationPK. e.g.
   *                              a colon-delimited string 'CALLSIGN:BANNER'
   * @throws Exception if the input string does not match the required regex
   *                   pattern and no parameters can be found
   */
  public CanadaStationPK(String canadaStationPkString) {
    this.callSign = canadaStationPkString.split(":")[0];
    this.banner = ECanadaBanner.valueOf(canadaStationPkString.split(":")[1]);
  }

  public ECanadaBanner getBanner() {
    return banner;
  }

  public void setBanner(ECanadaBanner banner) {
    this.banner = banner;
  }

  public String getCallSign() {
    return callSign;
  }

  public void setCallSign(String callSign) {
    this.callSign = callSign;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 23 * hash + Objects.hashCode(this.banner);
    hash = 23 * hash + Objects.hashCode(this.callSign);
    return Math.abs(hash);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final CanadaStationPK other = (CanadaStationPK) obj;
    if (this.banner != other.getBanner()) {
      return false;
    }
    return Objects.equals(this.callSign, other.getCallSign());
  }

  /**
   * Return a class-friendly output.
   * <p>
   * @return the call sign and banner encoded as
   *         <code>callSign + ":" + banner</code>
   */
  @Override
  public String toString() {
    return callSign + ":" + banner;
  }
}
