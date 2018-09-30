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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Logical data model container for the CANADA RadiationPattern (apatdat) table
 * compound primary key.
 *
 * @author Key Bridge
 * @since v3.0.0 rebuild 09/30/18 to mirror the physical data model.
 */
@Embeddable
public class ApatdatPK implements Serializable {

  /**
   * The Radiation Pattern key. This is a reference to the Antenna Radiation
   * Pattern key (pattKey) field.
   */
  @Basic(optional = false)
  @Column(name = "patt_key")
  private int pattKey;
  /**
   * Pattern data point azimuth from true north (degrees).
   */
  @Basic(optional = false)
  @Column(name = "angle")
  private double angle;
  /**
   * Pattern data point gain at the given angle (dB).
   */
  @Basic(optional = false)
  @Column(name = "gain")
  private double gain;

  public ApatdatPK() {
  }

  public ApatdatPK(int pattKey, double angle, double gain) {
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

  public double getAngle() {
    return angle;
  }

  public void setAngle(double angle) {
    this.angle = angle;
  }

  public double getGain() {
    return gain;
  }

  public void setGain(double gain) {
    this.gain = gain;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 13 * hash + this.pattKey;
    hash = 13 * hash + (int) (Double.doubleToLongBits(this.angle) ^ (Double.doubleToLongBits(this.angle) >>> 32));
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
    final ApatdatPK other = (ApatdatPK) obj;
    if (this.pattKey != other.pattKey) {
      return false;
    }
    return Double.doubleToLongBits(this.angle) == Double.doubleToLongBits(other.angle);
  }

}
