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
@Table(name = "contours")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "ServiceContour.findAll", query = "SELECT s FROM ServiceContour s"),
  @NamedQuery(name = "ServiceContour.findByCallsBanr", query = "SELECT s FROM ServiceContour s WHERE s.serviceContourPK.callsBanr = :callsBanr"),
  @NamedQuery(name = "ServiceContour.findByAzimuth", query = "SELECT s FROM ServiceContour s WHERE s.serviceContourPK.azimuth = :azimuth"),
  @NamedQuery(name = "ServiceContour.findByValuDist", query = "SELECT s FROM ServiceContour s WHERE s.serviceContourPK.valuDist = :valuDist"),
  @NamedQuery(name = "ServiceContour.findByName", query = "SELECT s FROM ServiceContour s WHERE s.name = :name"),
  @NamedQuery(name = "ServiceContour.findByLatEnd", query = "SELECT s FROM ServiceContour s WHERE s.latEnd = :latEnd"),
  @NamedQuery(name = "ServiceContour.findByLongEnd", query = "SELECT s FROM ServiceContour s WHERE s.longEnd = :longEnd")})
public class ServiceContour implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ServiceContourPK serviceContourPK;
  @Column(length = 4)
  @XmlAttribute
  private String name;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "lat_end", precision = 12)
  @XmlAttribute
  private Float latEnd;
  @Column(name = "long_end", precision = 12)
  @XmlAttribute
  private Float longEnd;
//  @JoinColumns({    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign", nullable = false),    @JoinColumn(name = "banner", referencedColumnName = "banner", nullable = false)})  @ManyToOne  private AmStation amStation;
//  @JoinColumns({    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign", nullable = false),    @JoinColumn(name = "banner", referencedColumnName = "banner", nullable = false)})  @ManyToOne  private FmStation fmStation;
//  @JoinColumns({    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign", nullable = false),    @JoinColumn(name = "banner", referencedColumnName = "banner", nullable = false)})  @ManyToOne  private TvStation tvStation;

  public ServiceContour() {
  }

  public ServiceContour(ServiceContourPK serviceContourPK) {
    this.serviceContourPK = serviceContourPK;
  }

  public ServiceContour(String callsBanr, float azimuth, float valuDist) {
    this.serviceContourPK = new ServiceContourPK(callsBanr, azimuth, valuDist);
  }

  public ServiceContourPK getServiceContourPK() {
    return serviceContourPK;
  }

  public void setServiceContourPK(ServiceContourPK serviceContourPK) {
    this.serviceContourPK = serviceContourPK;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Float getLatEnd() {
    return latEnd;
  }

  public void setLatEnd(Float latEnd) {
    this.latEnd = latEnd;
  }

  public Float getLongEnd() {
    return longEnd;
  }

  public void setLongEnd(Float longEnd) {
    this.longEnd = longEnd;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (serviceContourPK != null ? serviceContourPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ServiceContour)) {
      return false;
    }
    ServiceContour other = (ServiceContour) object;
    if ((this.serviceContourPK == null && other.serviceContourPK != null) || (this.serviceContourPK != null && !this.serviceContourPK.equals(other.serviceContourPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.ServiceContour[ serviceContourPK=" + serviceContourPK + " ]";
  }
}
