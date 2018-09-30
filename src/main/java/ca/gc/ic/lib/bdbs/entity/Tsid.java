/*
 * Copyright 2018 Key Bridge. All rights reserved. Use is subject to license
 * terms.
 *
 * This software code is protected by Copyrights and remains the property of
 * Key Bridge and its suppliers, if any. Key Bridge reserves all rights in and to
 * Copyrights and no license is granted under Copyrights in this Software
 * License Agreement.
 *
 * Key Bridge generally licenses Copyrights for commercialization pursuant to
 * the terms of either a Standard Software Source Code License Agreement or a
 * Standard Product License Agreement. A copy of either Agreement can be
 * obtained upon request by sending an email to info@keybridgewireless.com.
 *
 * All information contained herein is the property of Key Bridge and its
 * suppliers, if any. The intellectual and technical concepts contained herein
 * are proprietary.
 */
package ca.gc.ic.lib.bdbs.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Logical data model container for the CANADA Tsid (tsid) table.
 * <p>
 * Contains Station TSID information.
 * <p>
 * TSID (which stands for Transmission Signal Identifier) is a 16-bit packet
 * contained within the Extended Data Services (XDS) of EIA-608B. Each station
 * is given a unique TSID identifier that has been assigned by the FCC to insert
 * into their Station signal. The recent FCC mandate states the TSID packet must
 * be present in the broadcasters NTSC signal if the broadcaster chooses to have
 * PSIP guide information.
 * <p>
 * “The FCC emphasized that when the NTSC channel is announced in PSIP,
 * transmission of the NTSC TSID in line 21, field 2 of the NTSC broadcast is
 * now mandatory (as required by A/65B)”.
 * <p>
 * In short, to ensure proper operation of digital receivers, the TSID data
 * within the NTSC signal must be present. DTV receivers will compare the TSID
 * information received in the PSIP with the TSID information in the
 * corresponding NTSC broadcast, verifying that the NTSC signal referenced in
 * the PSIP is actually the desired signal.
 *
 * @author Key Bridge
 */
@Entity
@Table(name = "tsid")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tsid implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected TsidPK tsidPK;
  @Column(name = "province")
  private String province;
  @Column(name = "city")
  private String city;
  @Column(name = "channel")
  private Integer channel;
  /**
   * The Transmission Signal Identifier. A 16-bit packet contained within the
   * MPEG-2 Extended Data Services (XDS) of EIA-608B.
   */
  @Column(name = "tsid")
  private String tsid;
  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign", insertable = false, updatable = false)
    , @JoinColumn(name = "banner", referencedColumnName = "banner", insertable = false, updatable = false)})
  @OneToOne(optional = false)
  @XmlTransient
  private Facility facility;

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

  public Integer getChannel() {
    return channel;
  }

  public void setChannel(Integer channel) {
    this.channel = channel;
  }

  public String getTsid() {
    return tsid;
  }

  public void setTsid(String tsid) {
    this.tsid = tsid;
  }

  public Facility getFacility() {
    return facility;
  }

  public void setFacility(Facility facility) {
    this.facility = facility;
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
    return "ca.gc.ic.lib.bdbs.entity.Tsid[ tsidPK=" + tsidPK + " ]";
  }

}
