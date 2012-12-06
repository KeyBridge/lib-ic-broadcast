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
 *
 * @author jesse
 */
@Embeddable
@XmlAccessorType(XmlAccessType.FIELD)
public class RadiationPatternPK implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  @Basic(optional = false)
  @Column(name = "patt_key", nullable = false)
  @XmlAttribute
  private Integer pattKey;
  @Basic(optional = false)
  @Column(name = "angle", nullable = false)
  @XmlAttribute
  private Double angle;
  @Basic(optional = false)
  @Column(name = "gain", nullable = false)
  @XmlAttribute
  private Double gain;

  public RadiationPatternPK() {
  }

  public RadiationPatternPK(int pattKey, Double angle, Double gain) {
    this.pattKey = pattKey;
    this.angle = angle;
    this.gain = gain;
  }

  public Integer getPattKey() {
    return pattKey;
  }

  public void setPattKey(Integer pattKey) {
    this.pattKey = pattKey;
  }

  public Double getAngle() {
    return angle;
  }

  public void setAngle(Double angle) {
    this.angle = angle;
  }

  public Double getGain() {
    return gain;
  }

  public void setGain(Double gain) {
    this.gain = gain;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 83 * hash + Objects.hashCode(this.pattKey);
    hash = 83 * hash + Objects.hashCode(this.angle);
    hash = 83 * hash + Objects.hashCode(this.gain);
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    if (!(object instanceof RadiationPatternPK)) {
      return false;
    }
    RadiationPatternPK other = (RadiationPatternPK) object;
    if (this.pattKey.equals(other.pattKey)) {
      return false;
    }
    if (this.angle != other.angle) {
      return false;
    }
    if (this.gain != other.gain) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "RadiationPatternPK pattKey [" + pattKey + "] angle [" + angle + "] gain [" + gain + " ]";
  }
}
