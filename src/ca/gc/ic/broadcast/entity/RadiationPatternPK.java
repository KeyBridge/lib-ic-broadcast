/*
 *   Copyright (C) 2012 Caulfield IP Holdings (Caulfield)
 *   and/or its affiliates.
 *   All rights reserved. Use is subject to license terms.
 *
 *   Software Code is protected by Caulfield Copyrights. Caulfield hereby
 *   reserves all rights in and to Caulfield Copyrights and no license is
 *   granted under Caulfield Copyrights in this Software License Agreement.
 *   Caulfield generally licenses Caulfield Copyrights for commercialization
 *   pursuant to the terms of either Caulfield's Standard Software Source Code
 *   License Agreement or Caulfield's Standard Product License Agreement.
 *
 *   A copy of Caulfield's either License Agreement can be obtained on request
 *   by email from: info@caufield.org.
 */
package ca.gc.ic.broadcast.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Logical data model container for the CANADA RadiationPattern (apatdat) table
 * compound primary key.
 * <p/>
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
  @XmlAttribute(required = true)
  private Integer pattKey;
  /**
   * Pattern data point azimuth from true north (degrees).
   */
  @Basic(optional = false)
  @Column(name = "angle", nullable = false)
  @XmlAttribute(required = true)
  private Double angle;
  /**
   * Pattern data point gain at the given angle (dB).
   */
  @Basic(optional = false)
  @Column(name = "gain", nullable = false)
  @XmlAttribute(required = true)
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
