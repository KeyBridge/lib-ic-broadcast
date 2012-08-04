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

/**
 *
 * @author jesse
 */
@Embeddable
public class RadiationPatternPK implements Serializable {

  @Basic(optional = false)
  @Column(name = "patt_key", nullable = false)
  private int pattKey;
  @Basic(optional = false)
  @Column(nullable = false)
  private float angle;
  @Basic(optional = false)
  @Column(nullable = false)
  private float gain;

  public RadiationPatternPK() {
  }

  public RadiationPatternPK(int pattKey, float angle, float gain) {
    this.pattKey = pattKey;
    this.angle = angle;
    this.gain = gain;
  }

  public int getPattKey() {
    return pattKey;
  }

  public void setPattKey(int pattKey) {
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
    return "ca.gc.ic.broadcast.entity.RadiationPatternPK[ pattKey=" + pattKey + ", angle=" + angle + ", gain=" + gain + " ]";
  }
}
