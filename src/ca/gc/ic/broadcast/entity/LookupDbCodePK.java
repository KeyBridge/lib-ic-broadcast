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
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Logical data model container for the CANADA LookupDbCode (lookup) table
 * compound primary key.
 * <p/>
 * @author jesse
 */
@Embeddable
@XmlAccessorType(XmlAccessType.FIELD)
public class LookupDbCodePK implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  /**
   * The reference field name.
   */
  @Basic(optional = false)
  @Column(name = "fieldname", nullable = false, length = 32)
  @XmlAttribute
  private String fieldname;
  /**
   * The field code.
   */
  @Basic(optional = false)
  @Column(name = "code", nullable = false, length = 8)
  @XmlAttribute
  private String code;

  public LookupDbCodePK() {
  }

  public LookupDbCodePK(String fieldname, String code) {
    this.fieldname = fieldname;
    this.code = code;
  }

  public String getFieldname() {
    return fieldname;
  }

  public void setFieldname(String fieldname) {
    this.fieldname = fieldname;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 71 * hash + Objects.hashCode(this.fieldname);
    hash = 71 * hash + Objects.hashCode(this.code);
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
    final LookupDbCodePK other = (LookupDbCodePK) obj;
    if (!Objects.equals(this.fieldname, other.fieldname)) {
      return false;
    }
    if (!Objects.equals(this.code, other.code)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.LookupDbCodePK[ fieldname=" + fieldname + ", code=" + code + " ]";
  }
}
