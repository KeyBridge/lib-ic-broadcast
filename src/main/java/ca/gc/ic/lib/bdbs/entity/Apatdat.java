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
import java.util.Objects;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Logical data model container for the CANADA RadiationPattern (apatdat) table.
 * <p>
 * Contains the 'gains' versus 'angle' data points defining the patterns. The
 * record format permits to store one data point per record, therefore the
 * storage of one pattern requires as many records as there are data points.
 *
 * @author Key Bridge
 * @since v3.0.0 rebuild 09/30/18 to mirror the physical data model.
 */
@Entity
@Table(name = "apatdat")
@XmlAccessorType(XmlAccessType.FIELD)
public class Apatdat implements Serializable {

  private static final long serialVersionUID = 1L;
  /**
   * The RadiationPattern compound primary key.
   * <p>
   * This contains the useful field values.
   */
  @EmbeddedId
  protected ApatdatPK apatdatPK;
  /**
   * Reverse pointer to the Antenna object containing this RadiationPattern
   * record.
   */
  @JoinColumn(name = "patt_key", referencedColumnName = "patt_key", insertable = false, updatable = false)
  @ManyToOne(optional = false)
  @XmlTransient
  private Apatdesc apatdesc;

  public Apatdat() {
  }

  public ApatdatPK getApatdatPK() {
    if (apatdatPK == null) {
      apatdatPK = new ApatdatPK();
    }
    return apatdatPK;
  }

  public void setApatdatPK(ApatdatPK apatdatPK) {
    this.apatdatPK = apatdatPK;
  }

  public Apatdesc getApatdesc() {
    return apatdesc;
  }

  public void setApatdesc(Apatdesc apatdesc) {
    this.apatdesc = apatdesc;
  }

  /**
   * Shortcut method to get the radiationPatternPK angle value.
   *
   * @return Pattern data point azimuth from true north (degrees).
   */
  public Double getAngle() {
    return getApatdatPK().getAngle();
  }

  /**
   * Shortcut method to get the radiationPatternPK gain value.
   *
   * @return Pattern data point gain at the given angle (dB).
   */
  public Double getGain() {
    return getApatdatPK().getGain();
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.apatdatPK);
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
    final Apatdat other = (Apatdat) obj;
    return Objects.equals(this.apatdatPK, other.apatdatPK);
  }

}
