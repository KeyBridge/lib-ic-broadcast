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
public class AmStationPK implements Serializable {

  @Basic(optional = false)
  @Column(name = "call_sign", nullable = false, length = 16)
  private String callSign;
  @Basic(optional = false)
  @Column(nullable = false, length = 2)
  private String banner;

  public AmStationPK() {
  }

  public AmStationPK(String callSign, String banner) {
    this.callSign = callSign;
    this.banner = banner;
  }

  public String getCallSign() {
    return callSign;
  }

  public void setCallSign(String callSign) {
    this.callSign = callSign;
  }

  public String getBanner() {
    return banner;
  }

  public void setBanner(String banner) {
    this.banner = banner;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (callSign != null ? callSign.hashCode() : 0);
    hash += (banner != null ? banner.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof AmStationPK)) {
      return false;
    }
    AmStationPK other = (AmStationPK) object;
    if ((this.callSign == null && other.callSign != null) || (this.callSign != null && !this.callSign.equals(other.callSign))) {
      return false;
    }
    if ((this.banner == null && other.banner != null) || (this.banner != null && !this.banner.equals(other.banner))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.AmStationPK[ callSign=" + callSign + ", banner=" + banner + " ]";
  }
}
