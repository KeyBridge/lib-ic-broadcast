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
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Key Bridge
 */
@Entity
@Table(name = "augment")
@XmlAccessorType(XmlAccessType.FIELD)
public class Augment implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected AugmentPK augmentPK;
  @Column(name = "radiation")
  private Integer radiation;
  @Column(name = "center_az")
  private Integer centerAz;
  @Column(name = "span")
  private Integer span;
  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign")
    , @JoinColumn(name = "banner", referencedColumnName = "banner")})
  @ManyToOne
  @XmlTransient
  private Facility facility;

  public Augment() {
  }

  public Augment(AugmentPK augmentPK) {
    this.augmentPK = augmentPK;
  }

  public Augment(String callsBanr, String dncCode, double number) {
    this.augmentPK = new AugmentPK(callsBanr, dncCode, number);
  }

  public AugmentPK getAugmentPK() {
    return augmentPK;
  }

  public void setAugmentPK(AugmentPK augmentPK) {
    this.augmentPK = augmentPK;
  }

  public Integer getRadiation() {
    return radiation;
  }

  public void setRadiation(Integer radiation) {
    this.radiation = radiation;
  }

  public Integer getCenterAz() {
    return centerAz;
  }

  public void setCenterAz(Integer centerAz) {
    this.centerAz = centerAz;
  }

  public Integer getSpan() {
    return span;
  }

  public void setSpan(Integer span) {
    this.span = span;
  }

  public Facility getFacility() {
    return facility;
  }

  public void setFacility(Facility facility) {
    this.facility = facility;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (augmentPK != null ? augmentPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Augment)) {
      return false;
    }
    Augment other = (Augment) object;
    if ((this.augmentPK == null && other.augmentPK != null) || (this.augmentPK != null && !this.augmentPK.equals(other.augmentPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.lib.bdbs.entity.Augment[ augmentPK=" + augmentPK + " ]";
  }

}
