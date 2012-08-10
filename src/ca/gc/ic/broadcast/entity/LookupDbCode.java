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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jesse
 */
@Entity
@Table(name = "lookup")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "LookupDbCode.findAll", query = "SELECT l FROM LookupDbCode l"),
  @NamedQuery(name = "LookupDbCode.findByFieldname", query = "SELECT l FROM LookupDbCode l WHERE l.lookupDbCodePK.fieldname = :fieldname"),
  @NamedQuery(name = "LookupDbCode.findByCode", query = "SELECT l FROM LookupDbCode l WHERE l.lookupDbCodePK.code = :code"),
  @NamedQuery(name = "LookupDbCode.findByDescriptionEnglish", query = "SELECT l FROM LookupDbCode l WHERE l.descriptionEnglish = :descriptionEnglish"),
  @NamedQuery(name = "LookupDbCode.findByDescriptionFrench", query = "SELECT l FROM LookupDbCode l WHERE l.descriptionFrench = :descriptionFrench")})
public class LookupDbCode implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected LookupDbCodePK lookupDbCodePK;
  @Column(name = "description_english", length = 128)
  @XmlAttribute
  private String descriptionEnglish;
  @Column(name = "description_french", length = 128)
  @XmlAttribute
  private String descriptionFrench;

  public LookupDbCode() {
  }

  public LookupDbCode(LookupDbCodePK lookupDbCodePK) {
    this.lookupDbCodePK = lookupDbCodePK;
  }

  public LookupDbCode(String fieldname, String code) {
    this.lookupDbCodePK = new LookupDbCodePK(fieldname, code);
  }

  public LookupDbCodePK getLookupDbCodePK() {
    return lookupDbCodePK;
  }

  public void setLookupDbCodePK(LookupDbCodePK lookupDbCodePK) {
    this.lookupDbCodePK = lookupDbCodePK;
  }

  public String getDescriptionEnglish() {
    return descriptionEnglish;
  }

  public void setDescriptionEnglish(String descriptionEnglish) {
    this.descriptionEnglish = descriptionEnglish;
  }

  public String getDescriptionFrench() {
    return descriptionFrench;
  }

  public void setDescriptionFrench(String descriptionFrench) {
    this.descriptionFrench = descriptionFrench;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (lookupDbCodePK != null ? lookupDbCodePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    if (!(object instanceof LookupDbCode)) {
      return false;
    }
    LookupDbCode other = (LookupDbCode) object;
    if ((this.lookupDbCodePK == null && other.lookupDbCodePK != null) || (this.lookupDbCodePK != null && !this.lookupDbCodePK.equals(other.lookupDbCodePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.LookupDbCode[ lookupDbCodePK=" + lookupDbCodePK + " ]";
  }
}
