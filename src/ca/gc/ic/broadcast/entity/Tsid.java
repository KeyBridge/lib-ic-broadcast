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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "tsid")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "Tsid.findAll", query = "SELECT t FROM Tsid t"),
  @NamedQuery(name = "Tsid.findByProvince", query = "SELECT t FROM Tsid t WHERE t.province = :province"),
  @NamedQuery(name = "Tsid.findByCity", query = "SELECT t FROM Tsid t WHERE t.city = :city"),
  @NamedQuery(name = "Tsid.findByCallSign", query = "SELECT t FROM Tsid t WHERE t.tsidPK.callSign = :callSign"),
  @NamedQuery(name = "Tsid.findByBanner", query = "SELECT t FROM Tsid t WHERE t.tsidPK.banner = :banner"),
  @NamedQuery(name = "Tsid.findByChannel", query = "SELECT t FROM Tsid t WHERE t.channel = :channel"),
  @NamedQuery(name = "Tsid.findByTsid", query = "SELECT t FROM Tsid t WHERE t.tsid = :tsid")})
public class Tsid implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected TsidPK tsidPK;
  @Column(name = "province", length = 2)
  @XmlAttribute
  private String province;
  @Column(name = "city", length = 32)
  @XmlAttribute
  private String city;
  @Column(name = "channel")
  @XmlAttribute
  private int channel;
  @Column(name = "tsid", length = 4)
  @XmlAttribute
  private String tsid;
  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "banner", referencedColumnName = "banner", nullable = false, insertable = false, updatable = false)})
  @OneToOne(optional = false)
  @XmlAttribute
  private CanadaStation canadaStation;

  public Tsid() {
  }

  public Tsid(TsidPK tsidPK) {
    this.tsidPK = tsidPK;
  }

  public Tsid(String callSign, String banner) {
    this.tsidPK = new TsidPK(callSign, banner);
  }

  public TsidPK getTsidPK() {
    return tsidPK;
  }

  public void setTsidPK(TsidPK tsidPK) {
    this.tsidPK = tsidPK;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public int getChannel() {
    return channel;
  }

  public void setChannel(int channel) {
    this.channel = channel;
  }

  public String getTsid() {
    return tsid;
  }

  public void setTsid(String tsid) {
    this.tsid = tsid;
  }

  public CanadaStation getCanadaStation() {
    return canadaStation;
  }

  public void setCanadaStation(CanadaStation canadaStation) {
    this.canadaStation = canadaStation;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (tsidPK != null ? tsidPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Tsid)) {
      return false;
    }
    Tsid other = (Tsid) object;
    if ((this.tsidPK == null && other.tsidPK != null) || (this.tsidPK != null && !this.tsidPK.equals(other.tsidPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.Tsid[ tsidPK=" + tsidPK + " ]";
  }
}
