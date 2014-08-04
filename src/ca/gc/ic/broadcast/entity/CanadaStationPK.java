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

import ca.gc.ic.broadcast.entity.enumerated.ECanadaBanner;
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
  @Column(name = "banner", nullable = false, length = 2)
  @XmlAttribute(required = true)
  private ECanadaBanner banner;
  /**
   * The station call sign. All Canadian station call signs begin with the
   * letter 'C'.
   */
  @Basic(optional = false)
  @Column(name = "call_sign", nullable = false, length = 12)
  @XmlAttribute(required = true)
  private String callSign;

  public CanadaStationPK() {
  }

  public CanadaStationPK(ECanadaBanner banner, String callSign) {
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
      this.banner = ECanadaBanner.valueOf(m.group(1));
      this.callSign = m.group(2);
    }
  }

  public ECanadaBanner getBanner() {
    return banner;
  }

  public void setBanner(ECanadaBanner banner) {
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
    final CanadaStationPK other = (CanadaStationPK) obj;
    if (this.banner != other.getBanner()) {
      return false;
    }
    return Objects.equals(this.callSign, other.getCallSign());
  }

  /**
   * Return a class-friendly output. e.g. CanadaStation banner [" + banner + "]
   * callSign [" + callSign + "]"
   * <p>
   * @return the call sign and banner.
   */
  @Override
  public String toString() {
    return "CanadaStation"
      + " " + callSign
      + " banner [" + banner
      + "]";
  }
}
