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
public class CA_ProvincePK implements Serializable {

  @Basic(optional = false)
  @Column(nullable = false, length = 2)
  @XmlAttribute
  private String province;
  @Basic(optional = false)
  @Column(nullable = false, length = 2)
  @XmlAttribute
  private String country;

  public CA_ProvincePK() {
  }

  public CA_ProvincePK(String province, String country) {
    this.province = province;
    this.country = country;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (province != null ? province.hashCode() : 0);
    hash += (country != null ? country.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CA_ProvincePK)) {
      return false;
    }
    CA_ProvincePK other = (CA_ProvincePK) object;
    if ((this.province == null && other.province != null) || (this.province != null && !this.province.equals(other.province))) {
      return false;
    }
    if ((this.country == null && other.country != null) || (this.country != null && !this.country.equals(other.country))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.CA_ProvincePK[ province=" + province + ", country=" + country + " ]";
  }
}
