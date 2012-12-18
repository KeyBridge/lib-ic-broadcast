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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jesse
 */
@Embeddable
@XmlAccessorType(XmlAccessType.FIELD)
public class ContourPK implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  @Basic(optional = false)
  @Column(name = "calls_banr", nullable = false, length = 32)
  @XmlAttribute
  private String callsBanr;
  @Basic(optional = false)
  @Column(name = "azimuth", nullable = false)
  @XmlAttribute
  private double azimuth;
  @Basic(optional = false)
  @Column(name = "valu_dist", nullable = false)
  @XmlAttribute
  private double valuDist;

  public ContourPK() {
  }

  public ContourPK(String callsBanr, double azimuth, double valuDist) {
    this.callsBanr = callsBanr;
    this.azimuth = azimuth;
    this.valuDist = valuDist;
  }

  public String getCallsBanr() {
    return callsBanr;
  }

  public void setCallsBanr(String callsBanr) {
    this.callsBanr = callsBanr;
  }

  public double getAzimuth() {
    return azimuth;
  }

  public void setAzimuth(double azimuth) {
    this.azimuth = azimuth;
  }

  public double getValuDist() {
    return valuDist;
  }

  public void setValuDist(double valuDist) {
    this.valuDist = valuDist;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (callsBanr != null ? callsBanr.hashCode() : 0);
    hash += (int) azimuth;
    hash += (int) valuDist;
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    if (!(object instanceof ContourPK)) {
      return false;
    }
    ContourPK other = (ContourPK) object;
    if ((this.callsBanr == null && other.callsBanr != null) || (this.callsBanr != null && !this.callsBanr.equals(other.callsBanr))) {
      return false;
    }
    if (this.azimuth != other.azimuth) {
      return false;
    }
    if (this.valuDist != other.valuDist) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.ContourPK[ callsBanr=" + callsBanr + ", azimuth=" + azimuth + ", valuDist=" + valuDist + " ]";
  }
}
