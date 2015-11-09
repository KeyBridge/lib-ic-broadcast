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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 * Logical data model container for the CANADA Antenna (apatdesc) table.
 * <p>
 * The APATDESC file contains a single "header" type record describing the
 * attributes of the antenna patterns. All the parameters describing the
 * patterns are found in this file with the exception of the data points
 * describing the actual patterns.
 *
 * @author jesse
 */
@Entity
@Table(name = "apatdesc")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "Antenna.findAll", query = "SELECT a FROM Antenna a")})
public class Antenna implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  /**
   * The Antenna Radiation Pattern Key. This is used to attach RadiationPattern
   * records to this Antenna.
   */
  @Id
  @Basic(optional = false)
  @Column(name = "patt_key", nullable = false)
  @XmlElement(required = true)
  private Integer pattKey;
  /**
   * Orientation. "H" for horizontal and "V" for vertical.
   */
  @Column(name = "hor_ver", length = 1)
  @XmlElement(required = true)
  private String polarization;
  /**
   * @deprecated Future use.
   */
  @Column(name = "patt_numb", precision = 12)
  @XmlElement
  private Double pattNumb;
  /**
   * Type of pattern: 'PRECISE', 'BRIEF', 'THEORETICAL'.
   * <p>
   * As part of the analysis of broadcast undertakings, antenna pattern data is
   * lifted from tables in the brief or digitized from diagrams of the
   * horizontal and vertical pattern.
   * <p>
   * When no vertical antenna pattern data appears in the brief, a theoretical
   * pattern for an antenna with the same number of bays is selected. In this
   * case PATT_TYPE is set to "THEORETICAL".
   * <p>
   * Omnidirectional Patterns: In the case of an Omnidirectional antenna, the
   * Effective Radiated Power value from the main database is assumed to be the
   * same for all azimuths. For this reason, no Horizontal pattern data is
   * stored for Omnidirectional stations.
   * <p>
   * Vertical Patterns: As described in the record layouts, the HOR_VER field is
   * used to indicate a (H)orizontal or (V)ertical pattern. It is possible that
   * a station with an Omnidirectional antenna may still have a Vertical antenna
   * pattern, and this is supported.
   * <p>
   * "THEORETICAL" Patterns: Very often measured patterns are not available at
   * the time of the brief's analysis. In such cases, the department uses
   * theoretical vertical patterns based on the Cosine Law. They have names from
   * BAY-2 to BAY-12, corresponding to the theoretical vertical patterns of a
   * two bay antenna, up to that of a twelve bay antenna.
   * <p>
   * "BRIEF"/"PRECISE" Patterns: When pattern values area taken from a table in
   * a technical brief, PATT_TYPE is set to "BRIEF". If the values are digitized
   * from antenna diagrams, PATT_TYPE is set to "PRECISE".
   */
  @Column(name = "patt_type", length = 12)
  @XmlElement(required = true)
  private String pattType;
  /**
   * @deprecated Future use.
   */
  @Column(name = "punits", precision = 12)
  @XmlElement
  private Double punits;
  /**
   * Number of points in the pattern.
   */
  @Column(name = "numpoints", precision = 12)
  @XmlElement(required = true)
  private Double numpoints;
  /**
   * Date pattern added to system.
   * <p>
   */
  @Column(name = "patt_date", precision = 12)
  @XmlTransient
  private String pattDate;
  /**
   * Reverse pointer to one or more CanadaStations using this Antenna.
   */
  @JoinTable(name = "apatstat", joinColumns = {
    @JoinColumn(name = "patt_key", referencedColumnName = "patt_key", nullable = false)}, inverseJoinColumns = {
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign", nullable = false),
    @JoinColumn(name = "banner", referencedColumnName = "banner", nullable = false)})
  @ManyToMany
  @XmlTransient
  private List<CanadaStation> canadaStationList;
  /**
   * A list of 'gains' versus 'angle' data points defining the antenna pattern.
   */
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "antenna")
  @XmlElement(required = true)
  private List<RadiationPattern> radiationPatternList;

  public Antenna() {
  }

  public Antenna(int pattKey) {
    this.pattKey = pattKey;
  }

  //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
  /**
   * The Antenna Radiation Pattern Key.
   *
   * @return the Antenna Radiation Pattern Key
   */
  public Integer getPattKey() {
    return pattKey;
  }

  public void setPattKey(Integer pattKey) {
    this.pattKey = pattKey;
  }

  /**
   * @return Orientation. "H" for horizontal and "V" for vertical.
   */
  public String getPolarization() {
    return polarization;
  }

  public void setPolarization(String polarization) {
    this.polarization = polarization;
  }

  /**
   * @deprecated Future use.
   */
  public Double getPattNumb() {
    return pattNumb;
  }

  public void setPattNumb(Double pattNumb) {
    this.pattNumb = pattNumb;
  }

  /**
   * @return Type of pattern: 'PRECISE', 'BRIEF', 'THEORETICAL'.
   */
  public String getPattType() {
    return pattType;
  }

  public void setPattType(String pattType) {
    this.pattType = pattType;
  }

  /**
   * @deprecated Future use.
   */
  public Double getPunits() {
    return punits;
  }

  public void setPunits(Double punits) {
    this.punits = punits;
  }

  /**
   * @return Number of points in the pattern.
   */
  public Double getNumpoints() {
    return numpoints;
  }

  public void setNumpoints(Double numpoints) {
    this.numpoints = numpoints;
  }

  /**
   * @return Date pattern added to system
   */
  public Date getPattDate() {
    try {
      return new SimpleDateFormat("yyyyMMdd").parse(pattDate);
    } catch (ParseException | NullPointerException ex) {
      return null;
    }
  }

  public void setPattDate(Date pattDate) {
    this.pattDate = new SimpleDateFormat("yyyyMMdd").format(pattDate);
  }

  /**
   * @return One or more CanadaStations using this Antenna.
   */
  public List<CanadaStation> getCanadaStationList() {
    return canadaStationList;
  }

  public void setCanadaStationList(List<CanadaStation> canadaStationList) {
    this.canadaStationList = canadaStationList;
  }

  /**
   * Recommend using getRadiationPatternMap for convenience unless you need to
   * address a specific entry.
   *
   * @return A list of 'gains' versus 'angle' data points defining the antenna
   *         pattern.
   */
  public List<RadiationPattern> getRadiationPatternList() {
    if (radiationPatternList == null) {
      radiationPatternList = new ArrayList<RadiationPattern>();
    }
    return radiationPatternList;
  }

  public void setRadiationPatternList(List<RadiationPattern> radiationPatternList) {
    this.radiationPatternList = radiationPatternList;
  }

  /**
   * @return The RadiationPattern list wrapped up nicely in a TreeMap.
   */
  public Map<Double, Double> getRadiationPatternMap() {
    Map<Double, Double> radiationPatternMap = new TreeMap<Double, Double>();
    for (RadiationPattern radiationPattern : getRadiationPatternList()) {
      radiationPatternMap.put(radiationPattern.getAngle(), radiationPattern.getGain());
    }
    return radiationPatternMap;
  }//</editor-fold>

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (pattKey != null ? pattKey.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    if (!(object instanceof Antenna)) {
      return false;
    }
    Antenna other = (Antenna) object;
    if ((this.pattKey == null && other.pattKey != null) || (this.pattKey != null && !this.pattKey.equals(other.pattKey))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Antenna"
           + " pattKey [" + pattKey
           + " polarization [" + polarization
           //      + "] pattNumb [" + pattNumb
           + "] pattType [" + pattType
           //      + "] punits [" + punits
           + "] numpoints [" + numpoints
           //      + "] pattDate [" + pattDate
           //      + "] canadaStationList [" + canadaStationList
           + "]\n radiationPatternMap [" + getRadiationPatternMap()
           + ']';
  }
}
