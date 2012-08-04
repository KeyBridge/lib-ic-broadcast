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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author jesse
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "SDars.findAll", query = "SELECT s FROM SDars s"),
  @NamedQuery(name = "SDars.findByCity", query = "SELECT s FROM SDars s WHERE s.city = :city"),
  @NamedQuery(name = "SDars.findByCallSign", query = "SELECT s FROM SDars s WHERE s.callSign = :callSign"),
  @NamedQuery(name = "SDars.findByFrequency", query = "SELECT s FROM SDars s WHERE s.frequency = :frequency"),
  @NamedQuery(name = "SDars.findByClazz", query = "SELECT s FROM SDars s WHERE s.clazz = :clazz"),
  @NamedQuery(name = "SDars.findByLatitude", query = "SELECT s FROM SDars s WHERE s.latitude = :latitude"),
  @NamedQuery(name = "SDars.findByLongitude", query = "SELECT s FROM SDars s WHERE s.longitude = :longitude"),
  @NamedQuery(name = "SDars.findByBanner", query = "SELECT s FROM SDars s WHERE s.banner = :banner"),
  @NamedQuery(name = "SDars.findByLimitCode", query = "SELECT s FROM SDars s WHERE s.limitCode = :limitCode"),
  @NamedQuery(name = "SDars.findByNetwork", query = "SELECT s FROM SDars s WHERE s.network = :network"),
  @NamedQuery(name = "SDars.findByAntMode", query = "SELECT s FROM SDars s WHERE s.antMode = :antMode"),
  @NamedQuery(name = "SDars.findByBcMode", query = "SELECT s FROM SDars s WHERE s.bcMode = :bcMode"),
  @NamedQuery(name = "SDars.findByOffset", query = "SELECT s FROM SDars s WHERE s.offset = :offset"),
  @NamedQuery(name = "SDars.findByOffPrec", query = "SELECT s FROM SDars s WHERE s.offPrec = :offPrec"),
  @NamedQuery(name = "SDars.findByBrdrLat", query = "SELECT s FROM SDars s WHERE s.brdrLat = :brdrLat"),
  @NamedQuery(name = "SDars.findByBrdrLong", query = "SELECT s FROM SDars s WHERE s.brdrLong = :brdrLong"),
  @NamedQuery(name = "SDars.findByBorder", query = "SELECT s FROM SDars s WHERE s.border = :border"),
  @NamedQuery(name = "SDars.findByCanLand", query = "SELECT s FROM SDars s WHERE s.canLand = :canLand"),
  @NamedQuery(name = "SDars.findByUsaLand", query = "SELECT s FROM SDars s WHERE s.usaLand = :usaLand"),
  @NamedQuery(name = "SDars.findByFreLand", query = "SELECT s FROM SDars s WHERE s.freLand = :freLand"),
  @NamedQuery(name = "SDars.findByDateStCreat", query = "SELECT s FROM SDars s WHERE s.dateStCreat = :dateStCreat"),
  @NamedQuery(name = "SDars.findByDateStMod", query = "SELECT s FROM SDars s WHERE s.dateStMod = :dateStMod"),
  @NamedQuery(name = "SDars.findByDateOkDump", query = "SELECT s FROM SDars s WHERE s.dateOkDump = :dateOkDump"),
  @NamedQuery(name = "SDars.findByDocFile", query = "SELECT s FROM SDars s WHERE s.docFile = :docFile"),
  @NamedQuery(name = "SDars.findByDecNumber", query = "SELECT s FROM SDars s WHERE s.decNumber = :decNumber"),
  @NamedQuery(name = "SDars.findByUnattended", query = "SELECT s FROM SDars s WHERE s.unattended = :unattended"),
  @NamedQuery(name = "SDars.findByCertNumb", query = "SELECT s FROM SDars s WHERE s.certNumb = :certNumb"),
  @NamedQuery(name = "SDars.findByCloseCap", query = "SELECT s FROM SDars s WHERE s.closeCap = :closeCap"),
  @NamedQuery(name = "SDars.findByAllocZone", query = "SELECT s FROM SDars s WHERE s.allocZone = :allocZone"),
  @NamedQuery(name = "SDars.findByBeamTilt", query = "SELECT s FROM SDars s WHERE s.beamTilt = :beamTilt"),
  @NamedQuery(name = "SDars.findByEhaatt", query = "SELECT s FROM SDars s WHERE s.ehaatt = :ehaatt"),
  @NamedQuery(name = "SDars.findByErpvav", query = "SELECT s FROM SDars s WHERE s.erpvav = :erpvav"),
  @NamedQuery(name = "SDars.findByErpvpk", query = "SELECT s FROM SDars s WHERE s.erpvpk = :erpvpk"),
  @NamedQuery(name = "SDars.findByErpaav", query = "SELECT s FROM SDars s WHERE s.erpaav = :erpaav"),
  @NamedQuery(name = "SDars.findByErpapk", query = "SELECT s FROM SDars s WHERE s.erpapk = :erpapk"),
  @NamedQuery(name = "SDars.findByErpvta", query = "SELECT s FROM SDars s WHERE s.erpvta = :erpvta"),
  @NamedQuery(name = "SDars.findByErpata", query = "SELECT s FROM SDars s WHERE s.erpata = :erpata"),
  @NamedQuery(name = "SDars.findByGroundLev", query = "SELECT s FROM SDars s WHERE s.groundLev = :groundLev"),
  @NamedQuery(name = "SDars.findByOverallH", query = "SELECT s FROM SDars s WHERE s.overallH = :overallH"),
  @NamedQuery(name = "SDars.findByRadCenter", query = "SELECT s FROM SDars s WHERE s.radCenter = :radCenter"),
  @NamedQuery(name = "SDars.findByChannel", query = "SELECT s FROM SDars s WHERE s.channel = :channel")})
public class SDars implements Serializable {

  private static final long serialVersionUID = 1L;
  @Column(length = 128)
  @XmlAttribute
  private String city;
  @Id
  @Basic(optional = false)
  @Column(name = "call_sign", nullable = false, length = 16)
  @XmlAttribute
  private String callSign;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(precision = 12)
  @XmlAttribute
  private Float frequency;
  @Column(length = 8)
  @XmlAttribute
  private String clazz;
  @Column(length = 6)
  @XmlAttribute
  private String latitude;
  @Column(length = 7)
  @XmlAttribute
  private String longitude;
  @Column(length = 2)
  @XmlAttribute
  private String banner;
  @Column(name = "limit_code", length = 8)
  @XmlAttribute
  private String limitCode;
  @Column(length = 64)
  @XmlAttribute
  private String network;
  @Column(name = "ant_mode")
  private Character antMode;
  @Column(name = "bc_mode")
  private Character bcMode;
  @XmlAttribute
  private Integer offset;
  @Column(name = "off_prec")
  private Character offPrec;
  @Column(name = "brdr_lat", length = 6)
  @XmlAttribute
  private String brdrLat;
  @Column(name = "brdr_long", length = 7)
  @XmlAttribute
  private String brdrLong;
  @Column(precision = 12)
  @XmlAttribute
  private Float border;
  @Column(name = "can_land", precision = 12)
  @XmlAttribute
  private Float canLand;
  @Column(name = "usa_land", precision = 12)
  @XmlAttribute
  private Float usaLand;
  @Column(name = "fre_land", precision = 12)
  @XmlAttribute
  private Float freLand;
  @Column(name = "date_st_creat", length = 8)
  @XmlAttribute
  private String dateStCreat;
  @Column(name = "date_st_mod", length = 8)
  @XmlAttribute
  private String dateStMod;
  @Column(name = "date_ok_dump", length = 8)
  @XmlAttribute
  private String dateOkDump;
  @Column(name = "doc_file")
  @XmlAttribute
  private Integer docFile;
  @Column(name = "dec_number")
  @XmlAttribute
  private Integer decNumber;
  private Character unattended;
  @Column(name = "cert_numb")
  @XmlAttribute
  private Integer certNumb;
  @Column(name = "close_cap")
  private Character closeCap;
  @Column(name = "alloc_zone")
  @XmlAttribute
  private Integer allocZone;
  @Column(name = "beam_tilt", precision = 12)
  @XmlAttribute
  private Float beamTilt;
  @Column(precision = 12)
  @XmlAttribute
  private Float ehaatt;
  @Column(precision = 12)
  @XmlAttribute
  private Float erpvav;
  @Column(precision = 12)
  @XmlAttribute
  private Float erpvpk;
  @Column(precision = 12)
  @XmlAttribute
  private Float erpaav;
  @Column(precision = 12)
  @XmlAttribute
  private Float erpapk;
  @Column(precision = 12)
  @XmlAttribute
  private Float erpvta;
  @Column(precision = 12)
  @XmlAttribute
  private Float erpata;
  @Column(name = "ground_lev", precision = 12)
  @XmlAttribute
  private Float groundLev;
  @Column(name = "overall_h", precision = 12)
  @XmlAttribute
  private Float overallH;
  @Column(name = "rad_center", precision = 12)
  @XmlAttribute
  private Float radCenter;
  @XmlAttribute
  private Integer channel;
  @JoinColumn(name = "province", referencedColumnName = "province")
  @ManyToOne
  private CA_Province province;

  public SDars() {
  }

  public SDars(String callSign) {
    this.callSign = callSign;
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

  public String getBanner() {
    return banner;
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

  public Character getAntMode() {
    return antMode;
  }

  public void setAntMode(Character antMode) {
    this.antMode = antMode;
  }

  public Character getBcMode() {
    return bcMode;
  }

  public void setBcMode(Character bcMode) {
    this.bcMode = bcMode;
  }

  public Integer getOffset() {
    return offset;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  public Character getOffPrec() {
    return offPrec;
  }

  public void setOffPrec(Character offPrec) {
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

  public String getDateStCreat() {
    return dateStCreat;
  }

  public void setDateStCreat(String dateStCreat) {
    this.dateStCreat = dateStCreat;
  }

  public String getDateStMod() {
    return dateStMod;
  }

  public void setDateStMod(String dateStMod) {
    this.dateStMod = dateStMod;
  }

  public String getDateOkDump() {
    return dateOkDump;
  }

  public void setDateOkDump(String dateOkDump) {
    this.dateOkDump = dateOkDump;
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

  public Character getUnattended() {
    return unattended;
  }

  public void setUnattended(Character unattended) {
    this.unattended = unattended;
  }

  public Integer getCertNumb() {
    return certNumb;
  }

  public void setCertNumb(Integer certNumb) {
    this.certNumb = certNumb;
  }

  public Character getCloseCap() {
    return closeCap;
  }

  public void setCloseCap(Character closeCap) {
    this.closeCap = closeCap;
  }

  public Integer getAllocZone() {
    return allocZone;
  }

  public void setAllocZone(Integer allocZone) {
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
  }

  public CA_Province getProvince() {
    return province;
  }

  public void setProvince(CA_Province province) {
    this.province = province;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (callSign != null ? callSign.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof SDars)) {
      return false;
    }
    SDars other = (SDars) object;
    if ((this.callSign == null && other.callSign != null) || (this.callSign != null && !this.callSign.equals(other.callSign))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.SDars[ callSign=" + callSign + " ]";
  }
}
