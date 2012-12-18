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

import ca.gc.ic.broadcast.entity.enumerated.Enum_Banner;
import ca.gc.ic.broadcast.entity.enumerated.Enum_StationClass;
import ca.gc.ic.broadcast.entity.enumerated.Enum_StationType;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author jesse
 */
@Entity
@Table(name = "ca_station_staging", uniqueConstraints = {
  @UniqueConstraint(columnNames = {"call_sign", "banner"})
})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "CanadaStationStaging.findAll", query = "SELECT c FROM CanadaStationStaging c"),
  @NamedQuery(name = "CanadaStationStaging.findByStationType", query = "SELECT c FROM CanadaStationStaging c WHERE c.stationType = :stationType"),
  @NamedQuery(name = "CanadaStationStaging.countByStationType", query = "SELECT COUNT(c) FROM CanadaStationStaging c WHERE c.stationType = :stationType")})
public class CanadaStationStaging implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected CanadaStationPK canadaStationPK;
  @Basic(optional = false)
  @Column(name = "station_type", nullable = false, length = 4)
  @XmlAttribute(required = true)
  private String stationType;
  @Basic(optional = false)
  @Column(name = "channel", nullable = false)
  @XmlAttribute
  private int channel;
  @Basic(optional = false)
  @Column(name = "latitude", nullable = false)
  @XmlAttribute
  private double latitude;
  @Basic(optional = false)
  @Column(name = "longitude", nullable = false)
  @XmlAttribute
  private double longitude;
  @Column(name = "bc_mode")
  @XmlAttribute
  private Character bcMode;
  @Column(name = "border", precision = 12)
  @XmlAttribute
  private double border;
  @Column(name = "brdr_lat", length = 6)
  @XmlAttribute
  private String brdrLat;
  @Column(name = "brdr_long", length = 7)
  @XmlAttribute
  private String brdrLong;
  @Column(name = "can_land", precision = 12)
  @XmlAttribute
  private double canLand;
  @Column(name = "cert_numb", length = 6)
  @XmlAttribute
  private String certNumb;
  @Column(name = "city", length = 25)
  @XmlAttribute
  private String city;
  @Column(name = "clazz", length = 2)
  @XmlAttribute
  @Enumerated(EnumType.STRING)
  private Enum_StationClass stationClass;
  @Column(name = "dec_number")
  @XmlAttribute
  private int decNumber;
  @Column(name = "doc_file")
  @XmlAttribute
  private int docFile;
  @Column(name = "fre_land", precision = 12)
  @XmlAttribute
  private double freLand;
  @Column(name = "frequency", precision = 12)
  @XmlAttribute
  private double frequency;
  @Column(name = "network", length = 4)
  @XmlAttribute
  private String network;
  @Column(name = "ok_dump", length = 8)
  @Temporal(javax.persistence.TemporalType.DATE)
  @XmlAttribute
  private Date okDump;
  @Column(name = "province", length = 2)
  @XmlAttribute
  private String province;
  @Column(name = "ss_code", length = 5)
  @XmlAttribute
  private String ssCode;
  @Column(name = "st_creat", length = 8)
  @Temporal(javax.persistence.TemporalType.DATE)
  @XmlAttribute
  private Date stCreat;
  @Column(name = "st_mod", length = 8)
  @Temporal(javax.persistence.TemporalType.DATE)
  @XmlAttribute
  private Date stMod;
  @Column(name = "unattended")
  @XmlAttribute
  private Character unattended;
  @Column(name = "usa_land", precision = 12)
  @XmlAttribute
  private double usaLand;

  public CanadaStationStaging() {
  }

  public CanadaStationStaging(CanadaStationPK canadaStationPK) {
    this.canadaStationPK = canadaStationPK;
  }

  public CanadaStationStaging(Enum_Banner banner, String callSign) {
    this.canadaStationPK = new CanadaStationPK(banner, callSign);
  }

  //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
  public CanadaStationPK getCanadaStationPK() {
    if (canadaStationPK == null) {
      canadaStationPK = new CanadaStationPK();
    }
    return canadaStationPK;
  }

  public void setCanadaStationPK(CanadaStationPK canadaStationPK) {
    this.canadaStationPK = canadaStationPK;
  }

  public Enum_StationType getStationType() {
    return Enum_StationType.valueOf(stationType);
  }

  public void setStationType(String stationType) {
    this.stationType = stationType;
  }

  public int getChannel() {
    return channel;
  }

  public void setChannel(int channel) {
    this.channel = channel;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public Character getBcMode() {
    return bcMode;
  }

  public void setBcMode(Character bcMode) {
    this.bcMode = bcMode;
  }

  public double getBorder() {
    return border;
  }

  public void setBorder(double border) {
    this.border = border;
  }

  public String getBrdrLat() {
    return brdrLat;
  }

  public void setBrdrLat(String brdrLat) {
    this.brdrLat = brdrLat;
  }

  public String getBrdrLong() {
    return brdrLong;
  }

  public void setBrdrLong(String brdrLong) {
    this.brdrLong = brdrLong;
  }

  public double getCanLand() {
    return canLand;
  }

  public void setCanLand(double canLand) {
    this.canLand = canLand;
  }

  public String getCertNumb() {
    return certNumb;
  }

  public void setCertNumb(String certNumb) {
    this.certNumb = certNumb;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Enum_StationClass getStationClass() {
    return stationClass;
  }

  public void setStationClass(Enum_StationClass stationClass) {
    this.stationClass = stationClass;
  }

  public int getDecNumber() {
    return decNumber;
  }

  public void setDecNumber(int decNumber) {
    this.decNumber = decNumber;
  }

  public int getDocFile() {
    return docFile;
  }

  public void setDocFile(int docFile) {
    this.docFile = docFile;
  }

  public double getFreLand() {
    return freLand;
  }

  public void setFreLand(double freLand) {
    this.freLand = freLand;
  }

  public double getFrequency() {
    return frequency;
  }

  public void setFrequency(double frequency) {
    this.frequency = frequency;
  }

  public String getNetwork() {
    return network;
  }

  public void setNetwork(String network) {
    this.network = network;
  }

  public Date getOkDump() {
    return okDump;
  }

  public void setOkDump(Date okDump) {
    this.okDump = okDump;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getSsCode() {
    return ssCode;
  }

  public void setSsCode(String ssCode) {
    this.ssCode = ssCode;
  }

  public Date getStCreat() {
    return stCreat;
  }

  public void setStCreat(Date stCreat) {
    this.stCreat = stCreat;
  }

  public Date getStMod() {
    return stMod;
  }

  public void setStMod(Date stMod) {
    this.stMod = stMod;
  }

  public Character getUnattended() {
    return unattended;
  }

  public void setUnattended(Character unattended) {
    this.unattended = unattended;
  }

  public double getUsaLand() {
    return usaLand;
  }

  public void setUsaLand(double usaLand) {
    this.usaLand = usaLand;
  }//</editor-fold>

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (canadaStationPK != null ? canadaStationPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    if (!(object instanceof CanadaStationStaging)) {
      return false;
    }
    CanadaStationStaging other = (CanadaStationStaging) object;
    if ((this.canadaStationPK == null && other.canadaStationPK != null) || (this.canadaStationPK != null && !this.canadaStationPK.equals(other.canadaStationPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "CanadaStationStaging"
      + " canadaStationPK [" + canadaStationPK
      + "]\n stationType [" + stationType
      + "] channel [" + channel
      + "] latitude [" + latitude
      + "] longitude [" + longitude
      + "] bcMode [" + bcMode
      + "] border [" + border
      + "] brdrLat [" + brdrLat
      + "] brdrLong [" + brdrLong
      + "] canLand [" + canLand
      + "] certNumb [" + certNumb
      + "] city [" + city
      + "] stationClass [" + stationClass
      + "] decNumber [" + decNumber
      + "] docFile [" + docFile
      + "] freLand [" + freLand
      + "] frequency [" + frequency
      + "] network [" + network
      + "] okDump [" + okDump
      + "] province [" + province
      + "] ssCode [" + ssCode
      + "] stCreat [" + stCreat
      + "] stMod [" + stMod
      + "] unattended [" + unattended
      + "] usaLand [" + usaLand
      + ']';
  }
}
