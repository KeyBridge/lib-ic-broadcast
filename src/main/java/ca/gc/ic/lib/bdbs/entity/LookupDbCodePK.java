/*
 * Copyright (C) 2014 Key Bridge Global LLC
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ca.gc.ic.lib.bdbs.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
  @XmlElement
  private String fieldname;
  /**
   * The field code.
   */
  @Basic(optional = false)
  @Column(name = "code", nullable = false, length = 8)
  @XmlElement
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
