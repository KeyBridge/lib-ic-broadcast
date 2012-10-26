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
public class AmStationParameterPK implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  @Basic(optional = false)
  @Column(name = "calls_banr", nullable = false, length = 32)
  @XmlAttribute
  private String callsBanr;
  @Basic(optional = false)
  @Column(name = "dnc_code", nullable = false, length = 1)
  @XmlAttribute
  private String dncCode;
  @Basic(optional = false)
  @Column(name = "tower_numb", nullable = false)
  @XmlAttribute
  private int towerNumb;

  public AmStationParameterPK() {
  }

  public AmStationParameterPK(String callsBanr, String dncCode, int towerNumb) {
    this.callsBanr = callsBanr;
    this.dncCode = dncCode;
    this.towerNumb = towerNumb;
  }

  public String getCallsBanr() {
    return callsBanr;
  }

  public void setCallsBanr(String callsBanr) {
    this.callsBanr = callsBanr;
  }

  public String getDncCode() {
    return dncCode;
  }

  public void setDncCode(String dncCode) {
    this.dncCode = dncCode;
  }

  public int getTowerNumb() {
    return towerNumb;
  }

  public void setTowerNumb(int towerNumb) {
    this.towerNumb = towerNumb;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (callsBanr != null ? callsBanr.hashCode() : 0);
    hash += (dncCode != null ? dncCode.hashCode() : 0);
    hash += (int) towerNumb;
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    if (!(object instanceof AmStationParameterPK)) {
      return false;
    }
    AmStationParameterPK other = (AmStationParameterPK) object;
    if ((this.callsBanr == null && other.callsBanr != null) || (this.callsBanr != null && !this.callsBanr.equals(other.callsBanr))) {
      return false;
    }
    if ((this.dncCode == null && other.dncCode != null) || (this.dncCode != null && !this.dncCode.equals(other.dncCode))) {
      return false;
    }
    if (this.towerNumb != other.towerNumb) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.AmStationParameterPK[ callsBanr=" + callsBanr + ", dncCode=" + dncCode + ", towerNumb=" + towerNumb + " ]";
  }
}
