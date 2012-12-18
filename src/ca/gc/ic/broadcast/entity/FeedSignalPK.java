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

import ca.gc.ic.broadcast.entity.enumerated.Enum_CanadaBanner;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Logical data model container for the CANADA FeedSignal (feeds) table compound
 * primary key.
 * <p/>
 * @author jesse
 */
@Embeddable
@XmlAccessorType(XmlAccessType.FIELD)
public class FeedSignalPK implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  @Basic(optional = false)
  @Column(name = "call_sign", nullable = false, length = 12)
  @XmlAttribute
  private String callSign;
  @Basic(optional = false)
  @Column(name = "banner", nullable = false, length = 2)
  @XmlAttribute
  @Enumerated(EnumType.STRING)
  private Enum_CanadaBanner banner;

  public FeedSignalPK() {
  }

  public FeedSignalPK(String callSign, Enum_CanadaBanner banner) {
    this.callSign = callSign;
    this.banner = banner;
  }

  public String getCallSign() {
    return callSign;
  }

  public void setCallSign(String callSign) {
    this.callSign = callSign;
  }

  public Enum_CanadaBanner getBanner() {
    return banner;
  }

  public void setBanner(Enum_CanadaBanner banner) {
    this.banner = banner;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 29 * hash + Objects.hashCode(this.callSign);
    hash = 29 * hash + (this.banner != null ? this.banner.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final FeedSignalPK other = (FeedSignalPK) obj;
    if (!Objects.equals(this.callSign, other.callSign)) {
      return false;
    }
    if (this.banner != other.banner) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.FeedSignalPK[ callSign=" + callSign + ", banner=" + banner + " ]";
  }
}
