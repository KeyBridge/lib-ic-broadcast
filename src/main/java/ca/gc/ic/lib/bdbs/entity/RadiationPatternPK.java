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
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Logical data model container for the CANADA RadiationPattern (apatdat) table
 * compound primary key.
 *
 * @author jesse
 */
@Embeddable
@XmlAccessorType(XmlAccessType.FIELD)
public class RadiationPatternPK implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  /**
   * The Radiation Pattern key. This is a reference to the Antenna Radiation
   * Pattern key (pattKey) field.
   */
  @Basic(optional = false)
  @Column(name = "patt_key", nullable = false)
  @XmlElement(required = true)
  private Integer pattKey;
  /**
   * Pattern data point azimuth from true north (degrees).
   */
  @Basic(optional = false)
  @Column(name = "angle", nullable = false)
  @XmlElement(required = true)
  private Double angle;
  /**
   * Pattern data point gain at the given angle (dB).
   */
  @Basic(optional = false)
  @Column(name = "gain", nullable = false)
  @XmlElement(required = true)
  private Double gain;

  public RadiationPatternPK() {
  }

  public RadiationPatternPK(int pattKey, Double angle, Double gain) {
    this.pattKey = pattKey;
    this.angle = angle;
    this.gain = gain;
  }

  /**
   * @return The Radiation Pattern key.
   */
  public Integer getPattKey() {
    return pattKey;
  }

  public void setPattKey(Integer pattKey) {
    this.pattKey = pattKey;
  }

  /**
   * @return Pattern data point azimuth from true north (degrees).
   */
  public Double getAngle() {
    return angle;
  }

  public void setAngle(Double angle) {
    this.angle = angle;
  }

  /**
   * @return Pattern data point gain at the given angle (dB).
   */
  public Double getGain() {
    return gain;
  }

  public void setGain(Double gain) {
    this.gain = gain;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 23 * hash + Objects.hashCode(this.pattKey);
    hash = 23 * hash + Objects.hashCode(this.angle);
    hash = 23 * hash + Objects.hashCode(this.gain);
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
    final RadiationPatternPK other = (RadiationPatternPK) obj;
    if (!Objects.equals(this.hashCode(), other.hashCode())) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "RadiationPattern "
           + " angle [" + angle
           + "] gain [" + gain
           + "]";
  }
}
