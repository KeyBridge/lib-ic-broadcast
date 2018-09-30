/*
 * Copyright 2018 Key Bridge. All rights reserved. Use is subject to license
 * terms.
 *
 * This software code is protected by Copyrights and remains the property of
 * Key Bridge and its suppliers, if any. Key Bridge reserves all rights in and to
 * Copyrights and no license is granted under Copyrights in this Software
 * License Agreement.
 *
 * Key Bridge generally licenses Copyrights for commercialization pursuant to
 * the terms of either a Standard Software Source Code License Agreement or a
 * Standard Product License Agreement. A copy of either Agreement can be
 * obtained upon request by sending an email to info@keybridgewireless.com.
 *
 * All information contained herein is the property of Key Bridge and its
 * suppliers, if any. The intellectual and technical concepts contained herein
 * are proprietary.
 */
package ca.gc.ic.lib.bdbs.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Logical data model container for the CANADA Antenna (apatdesc) table.
 * <p>
 * The APATDESC file contains a single "header" type record describing the
 * attributes of the antenna patterns. All the parameters describing the
 * patterns are found in this file with the exception of the data points
 * describing the actual patterns.
 *
 * @author Key Bridge
 * @since v3.0.0 rebuild 09/30/18 to mirror the physical data model.
 */
@Entity
@Table(name = "apatdesc")
@XmlAccessorType(XmlAccessType.FIELD)
public class Apatdesc implements Serializable {

  private static final long serialVersionUID = 1L;
  /**
   * The Antenna Radiation Pattern Key. This is used to attach RadiationPattern
   * records to this Antenna.
   */
  @Id
  @Basic(optional = false)
  @Column(name = "patt_key")
  private Integer pattKey;
  /**
   * Orientation. "H" for horizontal and "V" for vertical.
   */
  @Column(name = "hor_ver")
  private String horVer;
  /**
   * @deprecated Future use.
   */
  @Column(name = "patt_numb")
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
  @Column(name = "patt_type")
  private String pattType;
  /**
   * @deprecated Future use.
   */
  @Column(name = "punits")
  private Double punits;
  /**
   * Number of points in the pattern.
   */
  @Column(name = "numpoints")
  private Double numpoints;
  /**
   * Date pattern added to system.
   * <p>
   */
  @Column(name = "patt_date")
  private String pattDate;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "apatdesc")
  @XmlTransient
  private Collection<Apatstat> apatstatCollection;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "apatdesc")
  private Collection<Apatdat> apatdatCollection;

  public Apatdesc() {
  }

  public Apatdesc(Integer pattKey) {
    this.pattKey = pattKey;
  }

  public Integer getPattKey() {
    return pattKey;
  }

  public void setPattKey(Integer pattKey) {
    this.pattKey = pattKey;
  }

  public String getHorVer() {
    return horVer;
  }

  public void setHorVer(String horVer) {
    this.horVer = horVer;
  }

  public Double getPattNumb() {
    return pattNumb;
  }

  public void setPattNumb(Double pattNumb) {
    this.pattNumb = pattNumb;
  }

  public String getPattType() {
    return pattType;
  }

  public void setPattType(String pattType) {
    this.pattType = pattType;
  }

  public Double getPunits() {
    return punits;
  }

  public void setPunits(Double punits) {
    this.punits = punits;
  }

  public Double getNumpoints() {
    return numpoints;
  }

  public void setNumpoints(Double numpoints) {
    this.numpoints = numpoints;
  }

  public String getPattDate() {
    return pattDate;
  }

  public void setPattDate(String pattDate) {
    this.pattDate = pattDate;
  }

  @XmlTransient
  public Collection<Apatstat> getApatstatCollection() {
    return apatstatCollection;
  }

  public void setApatstatCollection(Collection<Apatstat> apatstatCollection) {
    this.apatstatCollection = apatstatCollection;
  }

  @XmlTransient
  public Collection<Apatdat> getApatdatCollection() {
    return apatdatCollection;
  }

  public void setApatdatCollection(Collection<Apatdat> apatdatCollection) {
    this.apatdatCollection = apatdatCollection;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 71 * hash + Objects.hashCode(this.pattKey);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Apatdesc other = (Apatdesc) obj;
    return Objects.equals(this.pattKey, other.pattKey);
  }

}
