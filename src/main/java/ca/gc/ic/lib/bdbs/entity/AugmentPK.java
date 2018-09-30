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
 *
 * @author Key Bridge
 */
@Embeddable
public class AugmentPK implements Serializable {

  @Basic(optional = false)
  @Column(name = "calls_banr")
  private String callsBanr;
  @Basic(optional = false)
  @Column(name = "dnc_code")
  private String dncCode;
  @Basic(optional = false)
  @Column(name = "number")
  private double number;

  public AugmentPK() {
  }

  public AugmentPK(String callsBanr, String dncCode, double number) {
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

  public double getNumber() {
    return number;
  }

  public void setNumber(double number) {
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
    if (!(object instanceof AugmentPK)) {
      return false;
    }
    AugmentPK other = (AugmentPK) object;
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
    return "ca.gc.ic.lib.bdbs.entity.AugmentPK[ callsBanr=" + callsBanr + ", dncCode=" + dncCode + ", number=" + number + " ]";
  }

}
