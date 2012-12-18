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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Logical data model container for the CANADA CanadaStation (ca_station)
 * compound primary key.
 * <p/>
 * @author jesse
 */
@Embeddable
@XmlAccessorType(XmlAccessType.FIELD)
public class CanadaStationPK implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  /**
   * The Canadian Banner code.
   */
  @Basic(optional = false)
  @Column(name = "banner", nullable = false, length = 2)
  @XmlAttribute
  @Enumerated(EnumType.STRING)
  private Enum_CanadaBanner banner;
  /**
   * The station call sign.
   */
  @Basic(optional = false)
  @Column(name = "call_sign", nullable = false, length = 12)
  @XmlAttribute
  private String callSign;

  public CanadaStationPK() {
  }

  public CanadaStationPK(Enum_CanadaBanner banner, String callSign) {
    this.banner = banner;
    this.callSign = callSign;
  }

  /**
   * Constructor taking the serialized (toString) output from another
   * CanadaStationPK. This enables the convenient serialization and
   * unmarshalling of CanadaStationPK objects.
   * <p/>
   * @param canadaStationPkString the toString output of a CanadaStationPK
   * @throws Exception if the input string does not match the required regex
   *                   pattern and no parameters can be found
   */
  public CanadaStationPK(String canadaStationPkString) {
    String toString = "banner \\[(\\w+)\\] callSign \\[(\\S+)\\]";
    Pattern p = Pattern.compile(toString);
    Matcher m = p.matcher(canadaStationPkString);
    if (m.find()) {
      this.banner = Enum_CanadaBanner.valueOf(m.group(1));
      this.callSign = m.group(2);
    }
  }

  public Enum_CanadaBanner getBanner() {
    return banner;
  }

  public void setBanner(Enum_CanadaBanner banner) {
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
    hash = 59 * hash + (this.banner != null ? this.banner.hashCode() : 0);
    hash = 59 * hash + Objects.hashCode(this.callSign);
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
    final CanadaStationPK other = (CanadaStationPK) obj;
    if (this.banner != other.banner) {
      return false;
    }
    if (!Objects.equals(this.callSign, other.callSign)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "CanadaStationPK banner [" + banner + "] callSign [" + callSign + "]";
  }
}
