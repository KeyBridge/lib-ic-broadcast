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
@Table(name = "contours")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "Contour.findAll", query = "SELECT c FROM Contour c"),
  @NamedQuery(name = "Contour.findByCallsBanr", query = "SELECT c FROM Contour c WHERE c.contourPK.callsBanr = :callsBanr"),
  @NamedQuery(name = "Contour.findByAzimuth", query = "SELECT c FROM Contour c WHERE c.contourPK.azimuth = :azimuth"),
  @NamedQuery(name = "Contour.findByValuDist", query = "SELECT c FROM Contour c WHERE c.contourPK.valuDist = :valuDist"),
  @NamedQuery(name = "Contour.findByName", query = "SELECT c FROM Contour c WHERE c.name = :name"),
  @NamedQuery(name = "Contour.findByLatEnd", query = "SELECT c FROM Contour c WHERE c.latEnd = :latEnd"),
  @NamedQuery(name = "Contour.findByLongEnd", query = "SELECT c FROM Contour c WHERE c.longEnd = :longEnd")})
public class Contour implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ContourPK contourPK;
  @Column(name = "name", length = 4)
  @XmlAttribute
  private String name;
  @Column(name = "lat_end", precision = 12)
  @XmlAttribute
  private double latEnd;
  @Column(name = "long_end", precision = 12)
  @XmlAttribute
  private double longEnd;
  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign"),
    @JoinColumn(name = "banner", referencedColumnName = "banner")})
  @ManyToOne
  @XmlTransient
  private CanadaStation canadaStation;

  public Contour() {
  }

  public Contour(ContourPK contourPK) {
    this.contourPK = contourPK;
  }

  public Contour(String callsBanr, double azimuth, double valuDist) {
    this.contourPK = new ContourPK(callsBanr, azimuth, valuDist);
  }

  public ContourPK getContourPK() {
    return contourPK;
  }

  public void setContourPK(ContourPK contourPK) {
    this.contourPK = contourPK;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getLatEnd() {
    return latEnd;
  }

  public void setLatEnd(double latEnd) {
    this.latEnd = latEnd;
  }

  public double getLongEnd() {
    return longEnd;
  }

  public void setLongEnd(double longEnd) {
    this.longEnd = longEnd;
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
    hash += (contourPK != null ? contourPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    if (!(object instanceof Contour)) {
      return false;
    }
    Contour other = (Contour) object;
    if ((this.contourPK == null && other.contourPK != null) || (this.contourPK != null && !this.contourPK.equals(other.contourPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.Contour[ contourPK=" + contourPK + " ]";
  }
}
