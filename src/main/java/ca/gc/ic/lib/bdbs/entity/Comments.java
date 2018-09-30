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
import java.util.Objects;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Logical data model container for the CANADA Comment (comment) table.
 * <p>
 * This table contains user contact information for the service.
 *
 * @author Key Bridge
 */
@Entity
@Table(name = "comments")
@XmlAccessorType(XmlAccessType.FIELD)
public class Comments implements Serializable {

  private static final long serialVersionUID = 1L;
  /**
   * @deprecated Not used in the logical data model.
   */
  @Id
  @Basic(optional = false)
  @Column(name = "calls_banr")
  private String callsBanr;
  /**
   * The entity (company) name.
   */
  @Column(name = "name")
  private String name;
  /**
   * The street address.
   */
  @Column(name = "addr1")
  private String addr1;
  /**
   * The street address, continued. If present this typically contains a suite
   * number, etc.
   */
  @Column(name = "addr2")
  private String addr2;
  /**
   * The city.
   */
  @Column(name = "addr3")
  private String addr3;
  /**
   * The Province (Canada) or State (USA)
   */
  @Column(name = "addr4")
  private String addr4;
  /**
   * General Headquarters comment code.
   *
   * @deprecated Present in the database but not used in logical data model.
   */
  @Column(name = "hqcomm")
  private Integer hqcomm;
  /**
   * General Regional comment code.
   *
   * @deprecated Present in the database but not used in logical data model.
   */
  @Column(name = "rgcomm")
  private Integer rgcomm;
  /**
   * Details on Limitations; English.
   *
   * @deprecated Present in the database but not used in logical data model.
   */
  @Column(name = "edetails")
  private Integer edetails;
  /**
   * Details on Limitations; French.
   *
   * @deprecated Present in the database but not used in logical data model.
   */
  @Column(name = "fdetails")
  private Integer fdetails;
  /**
   * Reverse reference to the CanadaStation record containing this comment.
   */
  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign")
    , @JoinColumn(name = "banner", referencedColumnName = "banner")})
  @ManyToOne
  @XmlTransient
  private Facility facility;

  public Comments() {
  }

  //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
  public String getCallsBanr() {
    return callsBanr;
  }

  public void setCallsBanr(String callsBanr) {
    this.callsBanr = callsBanr;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddr1() {
    return addr1;
  }

  public void setAddr1(String addr1) {
    this.addr1 = addr1;
  }

  public String getAddr2() {
    return addr2;
  }

  public void setAddr2(String addr2) {
    this.addr2 = addr2;
  }

  public String getAddr3() {
    return addr3;
  }

  public void setAddr3(String addr3) {
    this.addr3 = addr3;
  }

  public String getAddr4() {
    return addr4;
  }

  public void setAddr4(String addr4) {
    this.addr4 = addr4;
  }

  public Integer getHqcomm() {
    return hqcomm;
  }

  public void setHqcomm(Integer hqcomm) {
    this.hqcomm = hqcomm;
  }

  public Integer getRgcomm() {
    return rgcomm;
  }

  public void setRgcomm(Integer rgcomm) {
    this.rgcomm = rgcomm;
  }

  public Integer getEdetails() {
    return edetails;
  }

  public void setEdetails(Integer edetails) {
    this.edetails = edetails;
  }

  public Integer getFdetails() {
    return fdetails;
  }

  public void setFdetails(Integer fdetails) {
    this.fdetails = fdetails;
  }

  public Facility getFacility() {
    return facility;
  }

  public void setFacility(Facility facility) {
    this.facility = facility;
  }//</editor-fold>

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 43 * hash + Objects.hashCode(this.callsBanr);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Comments other = (Comments) obj;
    return Objects.equals(this.callsBanr, other.callsBanr);
  }

}
