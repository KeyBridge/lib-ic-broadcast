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
public class AmStationAugmentPK implements Serializable {

  @Basic(optional = false)
  @Column(name = "calls_banr", nullable = false, length = 32)
  private String callsBanr;
  @Basic(optional = false)
  @Column(name = "dnc_code", nullable = false, length = 1)
  private String dncCode;
  @Basic(optional = false)
  @Column(name = "number", nullable = false)
  private float number;

  public AmStationAugmentPK() {
  }

  public AmStationAugmentPK(String callsBanr, String dncCode, float number) {
    this.callsBanr = callsBanr;
    this.dncCode = dncCode;
    this.number = number;
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

  public float getNumber() {
    return number;
  }

  public void setNumber(float number) {
    this.number = number;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (callsBanr != null ? callsBanr.hashCode() : 0);
    hash += (dncCode != null ? dncCode.hashCode() : 0);
    hash += (int) number;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof AmStationAugmentPK)) {
      return false;
    }
    AmStationAugmentPK other = (AmStationAugmentPK) object;
    if ((this.callsBanr == null && other.callsBanr != null) || (this.callsBanr != null && !this.callsBanr.equals(other.callsBanr))) {
      return false;
    }
    if ((this.dncCode == null && other.dncCode != null) || (this.dncCode != null && !this.dncCode.equals(other.dncCode))) {
      return false;
    }
    if (this.number != other.number) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.AmStationAugmentPK[ callsBanr=" + callsBanr + ", dncCode=" + dncCode + ", number=" + number + " ]";
  }
}
