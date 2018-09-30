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
@Table(name = "contours")
@XmlAccessorType(XmlAccessType.FIELD)
public class Contours implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ContoursPK contoursPK;
  @Column(name = "name")
  private String name;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "lat_end")
  private Double latEnd;
  @Column(name = "long_end")
  private Double longEnd;
  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign")
    , @JoinColumn(name = "banner", referencedColumnName = "banner")})
  @ManyToOne
  @XmlTransient
  private Facility facility;

  public Contours() {
  }

  public Contours(ContoursPK contoursPK) {
    this.contoursPK = contoursPK;
  }

  public Contours(String callsBanr, double azimuth, double valuDist) {
    this.contoursPK = new ContoursPK(callsBanr, azimuth, valuDist);
  }

  public ContoursPK getContoursPK() {
    return contoursPK;
  }

  public void setContoursPK(ContoursPK contoursPK) {
    this.contoursPK = contoursPK;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getLatEnd() {
    return latEnd;
  }

  public void setLatEnd(Double latEnd) {
    this.latEnd = latEnd;
  }

  public Double getLongEnd() {
    return longEnd;
  }

  public void setLongEnd(Double longEnd) {
    this.longEnd = longEnd;
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
    hash += (contoursPK != null ? contoursPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Contours)) {
      return false;
    }
    Contours other = (Contours) object;
    if ((this.contoursPK == null && other.contoursPK != null) || (this.contoursPK != null && !this.contoursPK.equals(other.contoursPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.lib.bdbs.entity.Contours[ contoursPK=" + contoursPK + " ]";
  }

}
