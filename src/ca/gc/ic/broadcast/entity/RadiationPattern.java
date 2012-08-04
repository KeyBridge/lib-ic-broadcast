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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "apatdat")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "RadiationPattern.findAll", query = "SELECT r FROM RadiationPattern r"),
  @NamedQuery(name = "RadiationPattern.findByPattKey", query = "SELECT r FROM RadiationPattern r WHERE r.radiationPatternPK.pattKey = :pattKey"),
  @NamedQuery(name = "RadiationPattern.findByAngle", query = "SELECT r FROM RadiationPattern r WHERE r.radiationPatternPK.angle = :angle"),
  @NamedQuery(name = "RadiationPattern.findByGain", query = "SELECT r FROM RadiationPattern r WHERE r.radiationPatternPK.gain = :gain")})
public class RadiationPattern implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected RadiationPatternPK radiationPatternPK;
  @JoinColumn(name = "patt_key", referencedColumnName = "patt_key", nullable = false, insertable = false, updatable = false)
  @ManyToOne(optional = false)
  @XmlAttribute
  private Antenna antenna;

  public RadiationPattern() {
  }

  public RadiationPattern(RadiationPatternPK radiationPatternPK) {
    this.radiationPatternPK = radiationPatternPK;
  }

  public RadiationPattern(int pattKey, float angle, float gain) {
    this.radiationPatternPK = new RadiationPatternPK(pattKey, angle, gain);
  }

  public RadiationPatternPK getRadiationPatternPK() {
    return radiationPatternPK;
  }

  public void setRadiationPatternPK(RadiationPatternPK radiationPatternPK) {
    this.radiationPatternPK = radiationPatternPK;
  }

  public Antenna getAntenna() {
    return antenna;
  }

  public void setAntenna(Antenna antenna) {
    this.antenna = antenna;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (radiationPatternPK != null ? radiationPatternPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof RadiationPattern)) {
      return false;
    }
    RadiationPattern other = (RadiationPattern) object;
    if ((this.radiationPatternPK == null && other.radiationPatternPK != null) || (this.radiationPatternPK != null && !this.radiationPatternPK.equals(other.radiationPatternPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.RadiationPattern[ radiationPatternPK=" + radiationPatternPK + " ]";
  }
}
