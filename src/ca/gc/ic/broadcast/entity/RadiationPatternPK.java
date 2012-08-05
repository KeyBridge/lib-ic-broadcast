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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author jesse
 */
@Embeddable
@XmlAccessorType(XmlAccessType.FIELD)
public class RadiationPatternPK implements Serializable {

  @Basic(optional = false)
  @Column(name = "patt_key", nullable = false)
  @XmlAttribute
  private Integer pattKey;
  @Basic(optional = false)
  @Column(name = "angle", nullable = false)
  @XmlAttribute
  private float angle;
  @Basic(optional = false)
  @Column(name = "gain", nullable = false)
  @XmlAttribute
  private float gain;

  public RadiationPatternPK() {
  }

  public RadiationPatternPK(int pattKey, float angle, float gain) {
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

  public float getAngle() {
    return angle;
  }

  public void setAngle(float angle) {
    this.angle = angle;
  }

  public float getGain() {
    return gain;
  }

  public void setGain(float gain) {
    this.gain = gain;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) pattKey;
    hash += (int) angle;
    hash += (int) gain;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof RadiationPatternPK)) {
      return false;
    }
    RadiationPatternPK other = (RadiationPatternPK) object;
    if (this.pattKey != other.pattKey) {
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
