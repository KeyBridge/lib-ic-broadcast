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
package ca.gc.ic.bdbs.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 * Logical data model container for the CANADA LookupDbCode (lookup) table.
 * <p/>
 * @author jesse
 */
@Entity
@Table(name = "lookup")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "LookupDbCode.findAll", query = "SELECT l FROM LookupDbCode l"),
  @NamedQuery(name = "LookupDbCode.findByFieldnameAndcode", query = "SELECT l FROM LookupDbCode l WHERE l.lookupDbCodePK.fieldname = :fieldname AND l.lookupDbCodePK.code = :code"),
  @NamedQuery(name = "LookupDbCode.findByFieldname", query = "SELECT l FROM LookupDbCode l WHERE l.lookupDbCodePK.fieldname = :fieldname"),
  @NamedQuery(name = "LookupDbCode.findByCode", query = "SELECT l FROM LookupDbCode l WHERE l.lookupDbCodePK.code = :code")})
public class LookupDbCode implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  /**
   * The compound primary key.
   */
  @EmbeddedId
  protected LookupDbCodePK lookupDbCodePK;
  /**
   * Description of the field code (in lookupDbCodePK); English.
   */
  @Column(name = "description_english", length = 128)
  @XmlAttribute
  private String descriptionEnglish;
  /**
   * Description of the field code (in lookupDbCodePK); French.
   */
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

  /**
   * @return The compound primary key.
   */
  public LookupDbCodePK getLookupDbCodePK() {
    return lookupDbCodePK;
  }

  public void setLookupDbCodePK(LookupDbCodePK lookupDbCodePK) {
    this.lookupDbCodePK = lookupDbCodePK;
  }

  /**
   * @return Description of the field code (in lookupDbCodePK); English.
   */
  public String getDescriptionEnglish() {
    return descriptionEnglish;
  }

  public void setDescriptionEnglish(String descriptionEnglish) {
    this.descriptionEnglish = descriptionEnglish;
  }

  /**
   * @return Description of the field code (in lookupDbCodePK); French.
   */
  public String getDescriptionFrench() {
    return descriptionFrench;
  }

  public void setDescriptionFrench(String descriptionFrench) {
    this.descriptionFrench = descriptionFrench;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 59 * hash + Objects.hashCode(this.lookupDbCodePK);
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
    final LookupDbCode other = (LookupDbCode) obj;
    if (!Objects.equals(this.lookupDbCodePK, other.lookupDbCodePK)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.LookupDbCode[ lookupDbCodePK=" + lookupDbCodePK + " ]";
  }
}
