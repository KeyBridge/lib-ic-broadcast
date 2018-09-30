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

import ca.gc.ic.lib.bdbs.entity.type.BannerType;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Logical data model container for the CANADA facility compound primary key.
 *
 * @author Key Bridge
 */
@Embeddable
@XmlAccessorType(XmlAccessType.FIELD)
public class FacilityPK implements Serializable {

  /**
   * The Industry Canada station banner code.
   * <p>
   * The Banner's <code>transmitting</code> field can be interrogated to
   * determine whether the station is on or off air. TRUE means the station is
   * transmitting and should be protected.
   * <p>
   * Depending upon the type of service the following Banner codes are
   * transmitting: <code>[AP, AU, O, OP, TO]</code>.
   */
  @Enumerated(EnumType.STRING)
  @Basic(optional = false)
  @Column(name = "banner")
  private BannerType banner;
  /**
   * The station call sign. All Canadian station call signs begin with the
   * letter 'C'.
   */
  @Basic(optional = false)
  @Column(name = "call_sign")
  private String callSign;

  public FacilityPK() {
  }

  public BannerType getBanner() {
    return banner;
  }

  public void setBanner(BannerType banner) {
    this.banner = banner;
  }

  public String getCallSign() {
    return callSign;
  }

  public void setCallSign(String callSign) {
    this.callSign = callSign;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 23 * hash + Objects.hashCode(this.banner);
    hash = 23 * hash + Objects.hashCode(this.callSign);
    return Math.abs(hash);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final FacilityPK other = (FacilityPK) obj;
    if (this.banner != other.getBanner()) {
      return false;
    }
    return Objects.equals(this.callSign, other.getCallSign());
  }

  /**
   * Return a class-friendly output.
   * <p>
   * @return the call sign and banner encoded as
   *         <code>callSign + ":" + banner</code>
   */
  @Override
  public String toString() {
    return callSign + ":" + banner;
  }

}
