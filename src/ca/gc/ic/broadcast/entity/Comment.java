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
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 * Logical data model container for the CANADA Comment (comment) table.
 * <p/>
 * This table contains user contact information for the service.
 * <p/>
 * @author jesse
 */
@Entity
@Table(name = "comments")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c"),
  @NamedQuery(name = "Comment.findByName", query = "SELECT c FROM Comment c WHERE c.name = :name"),
  @NamedQuery(name = "Comment.findByCallSign", query = "SELECT c FROM Comment c WHERE c.commentPK.callSign = :callSign")})
public class Comment implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  /**
   * The table compound primary key. This is used to bind the comment record
   * with a CanadaStation record.
   */
  @EmbeddedId
  protected CommentPK commentPK;
  /**
   * @deprecated Not used in the logical data model.
   */
  @Column(name = "calls_banr", length = 32)
  @XmlAttribute
  private String callsBanr;
  /**
   * The entity (company) name.
   */
  @Column(name = "name", length = 40)
  @XmlAttribute
  private String name;
  /**
   * The street address.
   */
  @Column(name = "addr1", length = 40)
  @XmlAttribute
  private String address;
  /**
   * The street address, continued. If present this typically contains a suite
   * number, etc.
   */
  @Column(name = "addr2", length = 40)
  @XmlAttribute
  private String address2;
  /**
   * The city.
   */
  @Column(name = "addr3", length = 40)
  @XmlAttribute
  private String city;
  /**
   * The Province (Canada) or State (USA)
   */
  @Column(name = "addr4", length = 40)
  @XmlAttribute
  private String province;
  /**
   * General Headquarters comment code.
   * <p/>
   * @deprecated Present in the database but not used in logical data model.
   */
  @Column(name = "hqcomm", precision = 12)
  @XmlAttribute
  private int hqcomm;
  /**
   * General Regional comment code.
   * <p/>
   * @deprecated Present in the database but not used in logical data model.
   */
  @Column(name = "rgcomm", precision = 12)
  @XmlTransient
  private int rgcomm;
  /**
   * Details on Limitations; English.
   * <p/>
   * @deprecated Present in the database but not used in logical data model.
   */
  @Column(name = "edetails", precision = 12)
  @XmlTransient
  private int edetails;
  /**
   * Details on Limitations; French.
   * <p/>
   * @deprecated Present in the database but not used in logical data model.
   */
  @Column(name = "fdetails", precision = 12)
  @XmlTransient
  private int fdetails;
  /**
   * Reverse reference to the CanadaStation record containing this comment.
   */
  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "banner", referencedColumnName = "banner", nullable = false, insertable = false, updatable = false)})
  @OneToOne(optional = false)
  @XmlTransient
  private CanadaStation canadaStation;

  public Comment() {
  }

  public Comment(CommentPK commentPK) {
    this.commentPK = commentPK;
  }

  public Comment(String callSign, ECanadaBanner banner) {
    this.commentPK = new CommentPK(callSign, banner);
  }

  /**
   * @return The table compound primary key.
   */
  public CommentPK getCommentPK() {
    return commentPK;
  }

  public void setCommentPK(CommentPK commentPK) {
    this.commentPK = commentPK;
  }

  /**
   * @deprecated Not used in the logical data model.
   */
  public String getCallsBanr() {
    return callsBanr;
  }

  public void setCallsBanr(String callsBanr) {
    this.callsBanr = callsBanr;
  }

  /**
   * @return The entity name.
   */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getAddress2() {
    return address2;
  }

  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  /**
   * @deprecated Present in the database but not used in logical data model.
   */
  public int getHqcomm() {
    return hqcomm;
  }

  public void setHqcomm(int hqcomm) {
    this.hqcomm = hqcomm;
  }

  /**
   * @deprecated Present in the database but not used in logical data model.
   */
  public int getRgcomm() {
    return rgcomm;
  }

  public void setRgcomm(int rgcomm) {
    this.rgcomm = rgcomm;
  }

  /**
   * @deprecated Present in the database but not used in logical data model.
   */
  public int getEdetails() {
    return edetails;
  }

  public void setEdetails(int edetails) {
    this.edetails = edetails;
  }

  /**
   * @deprecated Present in the database but not used in logical data model.
   */
  public int getFdetails() {
    return fdetails;
  }

  public void setFdetails(int fdetails) {
    this.fdetails = fdetails;
  }

  /**
   * @return Reverse reference to the CanadaStation record containing this
   *         comment.
   */
  public CanadaStation getCanadaStation() {
    return canadaStation;
  }

  public void setCanadaStation(CanadaStation canadaStation) {
    this.canadaStation = canadaStation;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 79 * hash + Objects.hashCode(this.commentPK);
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
    final Comment other = (Comment) obj;
    if (!Objects.equals(this.commentPK, other.commentPK)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Comment"
      + " name [" + name
      + "] address [" + address
      + "] address2 [" + address2
      + "] city [" + city
      + "] province [" + province
      + ']';
  }
}
