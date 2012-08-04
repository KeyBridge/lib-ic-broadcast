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
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author jesse
 */
@Embeddable
public class LookupDbCodePK implements Serializable {

  @Basic(optional = false)
  @Column(name = "fieldname", nullable = false, length = 32)
  @XmlAttribute
  private String fieldname;
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
    int hash = 0;
    hash += (fieldname != null ? fieldname.hashCode() : 0);
    hash += (code != null ? code.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof LookupDbCodePK)) {
      return false;
    }
    LookupDbCodePK other = (LookupDbCodePK) object;
    if ((this.fieldname == null && other.fieldname != null) || (this.fieldname != null && !this.fieldname.equals(other.fieldname))) {
      return false;
    }
    if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.LookupDbCodePK[ fieldname=" + fieldname + ", code=" + code + " ]";
  }
}
