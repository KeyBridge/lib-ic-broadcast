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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author jesse
 */
@Entity
@Table(name = "comments")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c"),
  @NamedQuery(name = "Comment.findByCallsBanr", query = "SELECT c FROM Comment c WHERE c.callsBanr = :callsBanr"),
  @NamedQuery(name = "Comment.findByName", query = "SELECT c FROM Comment c WHERE c.name = :name"),
  @NamedQuery(name = "Comment.findByAddr1", query = "SELECT c FROM Comment c WHERE c.addr1 = :addr1"),
  @NamedQuery(name = "Comment.findByAddr2", query = "SELECT c FROM Comment c WHERE c.addr2 = :addr2"),
  @NamedQuery(name = "Comment.findByAddr3", query = "SELECT c FROM Comment c WHERE c.addr3 = :addr3"),
  @NamedQuery(name = "Comment.findByAddr4", query = "SELECT c FROM Comment c WHERE c.addr4 = :addr4"),
  @NamedQuery(name = "Comment.findByHqcomm", query = "SELECT c FROM Comment c WHERE c.hqcomm = :hqcomm"),
  @NamedQuery(name = "Comment.findByRgcomm", query = "SELECT c FROM Comment c WHERE c.rgcomm = :rgcomm"),
  @NamedQuery(name = "Comment.findByEdetails", query = "SELECT c FROM Comment c WHERE c.edetails = :edetails"),
  @NamedQuery(name = "Comment.findByFdetails", query = "SELECT c FROM Comment c WHERE c.fdetails = :fdetails")})
public class Comment implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "calls_banr", nullable = false, length = 32)
  @XmlAttribute
  private String callsBanr;
  @Column(length = 40)
  @XmlAttribute
  private String name;
  @Column(length = 40)
  @XmlAttribute
  private String addr1;
  @Column(length = 40)
  @XmlAttribute
  private String addr2;
  @Column(length = 40)
  @XmlAttribute
  private String addr3;
  @Column(length = 40)
  @XmlAttribute
  private String addr4;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(precision = 12)
  @XmlAttribute
  private Float hqcomm;
  @Column(precision = 12)
  @XmlAttribute
  private Float rgcomm;
  @Column(precision = 12)
  @XmlAttribute
  private Float edetails;
  @Column(precision = 12)
  @XmlAttribute
  private Float fdetails;
//  @JoinColumns({    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign",nullable = false),    @JoinColumn(name = "banner", referencedColumnName = "banner",nullable = false)})  @ManyToOne  private AmStation amStation;
//  @JoinColumns({    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign",nullable = false),    @JoinColumn(name = "banner", referencedColumnName = "banner",nullable = false)})  @ManyToOne  private AmStation fmStation;
//  @JoinColumns({    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign",nullable = false),    @JoinColumn(name = "banner", referencedColumnName = "banner",nullable = false)})  @ManyToOne  private AmStation tvStation;

  public Comment() {
  }

  public Comment(String callsBanr) {
    this.callsBanr = callsBanr;
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

  public Float getHqcomm() {
    return hqcomm;
  }

  public void setHqcomm(Float hqcomm) {
    this.hqcomm = hqcomm;
  }

  public Float getRgcomm() {
    return rgcomm;
  }

  public void setRgcomm(Float rgcomm) {
    this.rgcomm = rgcomm;
  }

  public Float getEdetails() {
    return edetails;
  }

  public void setEdetails(Float edetails) {
    this.edetails = edetails;
  }

  public Float getFdetails() {
    return fdetails;
  }

  public void setFdetails(Float fdetails) {
    this.fdetails = fdetails;
  }

  //</editor-fold>
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (callsBanr != null ? callsBanr.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Comment)) {
      return false;
    }
    Comment other = (Comment) object;
    if ((this.callsBanr == null && other.callsBanr != null) || (this.callsBanr != null && !this.callsBanr.equals(other.callsBanr))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.Comment[ callsBanr=" + callsBanr + " ]";
  }
}
