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
 *
 * @author Key Bridge
 */
@Entity
@Table(name = "apatstat")
@XmlAccessorType(XmlAccessType.FIELD)
public class Apatstat implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ApatstatPK apatstatPK;
  @JoinColumn(name = "patt_key", referencedColumnName = "patt_key", insertable = false, updatable = false)
  @ManyToOne(optional = false)
  private Apatdesc apatdesc;
  /**
   * Reverse pointer to the Facility using this Antenna.
   */
  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign")
    , @JoinColumn(name = "banner", referencedColumnName = "banner")})
  @ManyToOne
  @XmlTransient
  private Facility facility;

  public Apatstat() {
  }

  public Apatstat(ApatstatPK apatstatPK) {
    this.apatstatPK = apatstatPK;
  }

  public Apatstat(String callsBanr, int pattKey) {
    this.apatstatPK = new ApatstatPK(callsBanr, pattKey);
  }

  public ApatstatPK getApatstatPK() {
    return apatstatPK;
  }

  public void setApatstatPK(ApatstatPK apatstatPK) {
    this.apatstatPK = apatstatPK;
  }

  public Apatdesc getApatdesc() {
    if (apatdesc == null) {
      apatdesc = new Apatdesc();
    }
    return apatdesc;
  }

  public void setApatdesc(Apatdesc apatdesc) {
    this.apatdesc = apatdesc;
  }

  public Facility getFacility() {
    return facility;
  }

  public void setFacility(Facility facility) {
    this.facility = facility;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 97 * hash + Objects.hashCode(this.apatstatPK);
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
    final Apatstat other = (Apatstat) obj;
    return Objects.equals(this.apatstatPK, other.apatstatPK);
  }

}
