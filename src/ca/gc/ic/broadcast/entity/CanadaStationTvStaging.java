/*
 *   Copyright (C) 2013 Caulfield IP Holdings (Caulfield)
 *   and/or its affiliates. All rights reserved. Use is subject to license terms.
 *
 *   Software Code is protected by Caulfield Copyrights. Caulfield hereby
 *   reserves all rights in and to Caulfield Copyrights and no license is
 *   granted under Caulfield Copyrights in this Software License Agreement.
 *   Caulfield generally licenses Caulfield Copyrights for commercialization
 *   pursuant to the terms of either Caulfield's Standard Software Source Code
 *   License Agreement or Caulfield's Standard Product License Agreement.
 *
 *   A copy of either License Agreement can be obtained on request by email
 *   from: info@caufield.org.
 */
package ca.gc.ic.broadcast.entity;

import ca.gc.ic.broadcast.entity.enumerated.Enum_CanadaBanner;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author jesse
 */
@Entity
@Table(name = "tvstatio_staging")
@NamedQueries({
  @NamedQuery(name = "CanadaStationTvStaging.findAll", query = "SELECT c FROM CanadaStationTvStaging c"),
  @NamedQuery(name = "CanadaStationTvStaging.findByCallSign", query = "SELECT c FROM CanadaStationTvStaging c WHERE c.callSign = :callSign"),
  @NamedQuery(name = "CanadaStationTvStaging.findByBanner", query = "SELECT c FROM CanadaStationTvStaging c WHERE c.banner = :banner"),
  @NamedQuery(name = "CanadaStationTvStaging.findByClazz", query = "SELECT c FROM CanadaStationTvStaging c WHERE c.clazz = :clazz"),
  @NamedQuery(name = "CanadaStationTvStaging.countByClazz", query = "SELECT COUNT(c) FROM CanadaStationTvStaging c WHERE c.clazz = :clazz"),
  @NamedQuery(name = "CanadaStationTvStaging.findByNetwork", query = "SELECT c FROM CanadaStationTvStaging c WHERE c.network = :network")})
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
public class CanadaStationTvStaging implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "call_banr_key")
  @XmlAttribute
  private String callBanrKey;
  @Column(name = "province")
  @XmlAttribute
  private String province;
  @Column(name = "city")
  @XmlAttribute
  private String city;
  @Column(name = "call_sign")
  @XmlAttribute
  private String callSign;
  @Column(name = "frequency")
  @XmlAttribute
  private Float frequency;
  @Column(name = "clazz")
  @XmlAttribute
  private String clazz;
  @Column(name = "latitude")
  @XmlAttribute
  private String latitude;
  @Column(name = "longitude")
  @XmlAttribute
  private String longitude;
  @Column(name = "banner")
  @XmlAttribute
  private String banner;
  @Column(name = "limit_code")
  @XmlAttribute
  private String limitCode;
  @Column(name = "network")
  @XmlAttribute
  private String network;
  @Column(name = "ant_mode")
  @XmlAttribute
  private String antMode;
  @Column(name = "bc_mode")
  @XmlAttribute
  private String bcMode;
  @Column(name = "offset")
  @XmlAttribute
  private String offset;
  @Column(name = "off_prec")
  @XmlAttribute
  private String offPrec;
  @Column(name = "brdr_lat")
  @XmlAttribute
  private String brdrLat;
  @Column(name = "brdr_long")
  @XmlAttribute
  private String brdrLong;
  @Column(name = "border")
  @XmlAttribute
  private Float border;
  @Column(name = "can_land")
  @XmlAttribute
  private Float canLand;
  @Column(name = "usa_land")
  @XmlAttribute
  private Float usaLand;
  @Column(name = "fre_land")
  @XmlAttribute
  private Float freLand;
  @Column(name = "st_creat")
  @XmlAttribute
  private String stCreat;
  @Column(name = "st_mod")
  @XmlAttribute
  private String stMod;
  @Column(name = "ok_dump")
  @XmlAttribute
  private String okDump;
  @Column(name = "doc_file")
  @XmlAttribute
  private Integer docFile;
  @Column(name = "dec_number")
  @XmlAttribute
  private Integer decNumber;
  @Column(name = "unattended")
  @XmlAttribute
  private String unattended;
  @Column(name = "cert_numb")
  @XmlAttribute
  private String certNumb;
  @Column(name = "close_cap")
  @XmlAttribute
  private String closeCap;
  @Column(name = "alloc_zone")
  @XmlAttribute
  private Float allocZone;
  @Column(name = "beam_tilt")
  @XmlAttribute
  private Float beamTilt;
  @Column(name = "ehaatt")
  @XmlAttribute
  private Float ehaatt;
  @Column(name = "erpvav")
  @XmlAttribute
  private Float erpvav;
  @Column(name = "erpvpk")
  @XmlAttribute
  private Float erpvpk;
  @Column(name = "erpaav")
  @XmlAttribute
  private Float erpaav;
  @Column(name = "erpapk")
  @XmlAttribute
  private Float erpapk;
  @Column(name = "erpvta")
  @XmlAttribute
  private Float erpvta;
  @Column(name = "erpata")
  @XmlAttribute
  private Float erpata;
  @Column(name = "ground_lev")
  @XmlAttribute
  private Float groundLev;
  @Column(name = "overall_h")
  @XmlAttribute
  private Float overallH;
  @Column(name = "rad_center")
  @XmlAttribute
  private Float radCenter;
  @Column(name = "channel")
  @XmlAttribute
  private Integer channel;

  public CanadaStationTvStaging() {
  }

  public CanadaStationTvStaging(String callBanrKey) {
    this.callBanrKey = callBanrKey;
  }

  //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
  public String getCallBanrKey() {
    return callBanrKey;
  }

  public void setCallBanrKey(String callBanrKey) {
    this.callBanrKey = callBanrKey;
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

  public String getCallSign() {
    return callSign;
  }

  public void setCallSign(String callSign) {
    this.callSign = callSign;
  }

  public Float getFrequency() {
    return frequency;
  }

  public void setFrequency(Float frequency) {
    this.frequency = frequency;
  }

  public String getClazz() {
    return clazz;
  }

  public void setClazz(String clazz) {
    this.clazz = clazz;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public Enum_CanadaBanner getBanner() {
    try {
      return Enum_CanadaBanner.valueOf(banner);
    } catch (Exception e) {
      return null;
    }
  }

  public void setBanner(String banner) {
    this.banner = banner;
  }

  public String getLimitCode() {
    return limitCode;
  }

  public void setLimitCode(String limitCode) {
    this.limitCode = limitCode;
  }

  public String getNetwork() {
    return network;
  }

  public void setNetwork(String network) {
    this.network = network;
  }

  public String getAntMode() {
    return antMode;
  }

  public void setAntMode(String antMode) {
    this.antMode = antMode;
  }

  public String getBcMode() {
    return bcMode;
  }

  public void setBcMode(String bcMode) {
    this.bcMode = bcMode;
  }

  public String getOffset() {
    return offset;
  }

  public void setOffset(String offset) {
    this.offset = offset;
  }

  public String getOffPrec() {
    return offPrec;
  }

  public void setOffPrec(String offPrec) {
    this.offPrec = offPrec;
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

  public Float getBorder() {
    return border;
  }

  public void setBorder(Float border) {
    this.border = border;
  }

  public Float getCanLand() {
    return canLand;
  }

  public void setCanLand(Float canLand) {
    this.canLand = canLand;
  }

  public Float getUsaLand() {
    return usaLand;
  }

  public void setUsaLand(Float usaLand) {
    this.usaLand = usaLand;
  }

  public Float getFreLand() {
    return freLand;
  }

  public void setFreLand(Float freLand) {
    this.freLand = freLand;
  }

  public String getStCreat() {
    return stCreat;
  }

  public void setStCreat(String stCreat) {
    this.stCreat = stCreat;
  }

  public String getStMod() {
    return stMod;
  }

  public void setStMod(String stMod) {
    this.stMod = stMod;
  }

  public String getOkDump() {
    return okDump;
  }

  public void setOkDump(String okDump) {
    this.okDump = okDump;
  }

  public Integer getDocFile() {
    return docFile;
  }

  public void setDocFile(Integer docFile) {
    this.docFile = docFile;
  }

  public Integer getDecNumber() {
    return decNumber;
  }

  public void setDecNumber(Integer decNumber) {
    this.decNumber = decNumber;
  }

  public String getUnattended() {
    return unattended;
  }

  public void setUnattended(String unattended) {
    this.unattended = unattended;
  }

  public String getCertNumb() {
    return certNumb;
  }

  public void setCertNumb(String certNumb) {
    this.certNumb = certNumb;
  }

  public String getCloseCap() {
    return closeCap;
  }

  public void setCloseCap(String closeCap) {
    this.closeCap = closeCap;
  }

  public Float getAllocZone() {
    return allocZone;
  }

  public void setAllocZone(Float allocZone) {
    this.allocZone = allocZone;
  }

  public Float getBeamTilt() {
    return beamTilt;
  }

  public void setBeamTilt(Float beamTilt) {
    this.beamTilt = beamTilt;
  }

  public Float getEhaatt() {
    return ehaatt;
  }

  public void setEhaatt(Float ehaatt) {
    this.ehaatt = ehaatt;
  }

  public Float getErpvav() {
    return erpvav;
  }

  public void setErpvav(Float erpvav) {
    this.erpvav = erpvav;
  }

  public Float getErpvpk() {
    return erpvpk;
  }

  public void setErpvpk(Float erpvpk) {
    this.erpvpk = erpvpk;
  }

  public Float getErpaav() {
    return erpaav;
  }

  public void setErpaav(Float erpaav) {
    this.erpaav = erpaav;
  }

  public Float getErpapk() {
    return erpapk;
  }

  public void setErpapk(Float erpapk) {
    this.erpapk = erpapk;
  }

  public Float getErpvta() {
    return erpvta;
  }

  public void setErpvta(Float erpvta) {
    this.erpvta = erpvta;
  }

  public Float getErpata() {
    return erpata;
  }

  public void setErpata(Float erpata) {
    this.erpata = erpata;
  }

  public Float getGroundLev() {
    return groundLev;
  }

  public void setGroundLev(Float groundLev) {
    this.groundLev = groundLev;
  }

  public Float getOverallH() {
    return overallH;
  }

  public void setOverallH(Float overallH) {
    this.overallH = overallH;
  }

  public Float getRadCenter() {
    return radCenter;
  }

  public void setRadCenter(Float radCenter) {
    this.radCenter = radCenter;
  }

  public Integer getChannel() {
    return channel;
  }

  public void setChannel(Integer channel) {
    this.channel = channel;
  }//</editor-fold>

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 43 * hash + Objects.hashCode(this.callSign);
    hash = 43 * hash + Objects.hashCode(this.banner);
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
    final CanadaStationTvStaging other = (CanadaStationTvStaging) obj;
    if (!Objects.equals(this.callSign, other.callSign)) {
      return false;
    }
    if (!Objects.equals(this.banner, other.banner)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.CanadaStationTvStaging[ callBanrKey=" + callBanrKey + " ]";
  }
}
