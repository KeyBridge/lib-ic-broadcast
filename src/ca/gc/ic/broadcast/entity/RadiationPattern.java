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
import java.util.Objects;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 * Logical data model container for the CANADA RadiationPattern (apatdat) table.
 * <p/>
 * Contains the 'gains' versus 'angle' data points defining the patterns. The
 * record format permits to store one data point per record, therefore the
 * storage of one pattern requires as many records as there are data points.
 * <p/>
 *
 * <p/>
 * @author jesse
 */
@Entity
@Table(name = "apatdat")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "RadiationPattern.findAll", query = "SELECT r FROM RadiationPattern r"),
  @NamedQuery(name = "RadiationPattern.findByPattKey", query = "SELECT r FROM RadiationPattern r WHERE r.radiationPatternPK.pattKey = :pattKey"),
  @NamedQuery(name = "RadiationPattern.findByAngle", query = "SELECT r FROM RadiationPattern r WHERE r.radiationPatternPK.angle = :angle"),
  @NamedQuery(name = "RadiationPattern.findByGain", query = "SELECT r FROM RadiationPattern r WHERE r.radiationPatternPK.gain = :gain")})
public class RadiationPattern implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  /**
   * The RadiationPattern compound primary key.
   * <p/>
   * This contains the useful field values.
   */
  @EmbeddedId
  @XmlElement(required = true)
  protected RadiationPatternPK radiationPatternPK;
  /**
   * Reverse pointer to the Antenna object containing this RadiationPattern
   * record.
   */
  @JoinColumn(name = "patt_key", referencedColumnName = "patt_key", nullable = false, insertable = false, updatable = false)
  @ManyToOne(optional = false)
  @XmlTransient
  private Antenna antenna;

  public RadiationPattern() {
  }

  public RadiationPattern(RadiationPatternPK radiationPatternPK) {
    this.radiationPatternPK = radiationPatternPK;
  }

  public RadiationPattern(int pattKey, double angle, double gain) {
    this.radiationPatternPK = new RadiationPatternPK(pattKey, angle, gain);
  }

  /**
   * @return The RadiationPattern compound primary key.
   */
  public RadiationPatternPK getRadiationPatternPK() {
    if (radiationPatternPK == null) {
      radiationPatternPK = new RadiationPatternPK();
    }
    return radiationPatternPK;
  }

  public void setRadiationPatternPK(RadiationPatternPK radiationPatternPK) {
    this.radiationPatternPK = radiationPatternPK;
  }

  /**
   * @return The Antenna containing this RadiationPattern
   */
  public Antenna getAntenna() {
    return antenna;
  }

  public void setAntenna(Antenna antenna) {
    this.antenna = antenna;
  }

  /**
   * Shortcut method to get the radiationPatternPK angle value.
   * <p/>
   * @return Pattern data point azimuth from true north (degrees).
   */
  public Double getAngle() {
    return getRadiationPatternPK().getAngle();
  }

  /**
   * Shortcut method to get the radiationPatternPK gain value.
   * <p/>
   * @return Pattern data point gain at the given angle (dB).
   */
  public Double getGain() {
    return getRadiationPatternPK().getGain();
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 41 * hash + Objects.hashCode(this.radiationPatternPK);
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
    final RadiationPattern other = (RadiationPattern) obj;
    if (!Objects.equals(this.radiationPatternPK, other.radiationPatternPK)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return radiationPatternPK.toString();
  }
}
