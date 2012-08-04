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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
@Table(name = "fmstatio")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "FmStation.findAll", query = "SELECT f FROM FmStation f"),
  @NamedQuery(name = "FmStation.findByCity", query = "SELECT f FROM FmStation f WHERE f.city = :city"),
  @NamedQuery(name = "FmStation.findByCallSign", query = "SELECT f FROM FmStation f WHERE f.fmStationPK.callSign = :callSign"),
  @NamedQuery(name = "FmStation.findByFrequency", query = "SELECT f FROM FmStation f WHERE f.frequency = :frequency"),
  @NamedQuery(name = "FmStation.findByClazz", query = "SELECT f FROM FmStation f WHERE f.clazz = :clazz"),
  @NamedQuery(name = "FmStation.findByLatitude", query = "SELECT f FROM FmStation f WHERE f.latitude = :latitude"),
  @NamedQuery(name = "FmStation.findByLongitude", query = "SELECT f FROM FmStation f WHERE f.longitude = :longitude"),
  @NamedQuery(name = "FmStation.findByBanner", query = "SELECT f FROM FmStation f WHERE f.fmStationPK.banner = :banner"),
  @NamedQuery(name = "FmStation.findBySsCode", query = "SELECT f FROM FmStation f WHERE f.ssCode = :ssCode"),
  @NamedQuery(name = "FmStation.findByNetwork", query = "SELECT f FROM FmStation f WHERE f.network = :network"),
  @NamedQuery(name = "FmStation.findByAntMode", query = "SELECT f FROM FmStation f WHERE f.antMode = :antMode"),
  @NamedQuery(name = "FmStation.findByBcMode", query = "SELECT f FROM FmStation f WHERE f.bcMode = :bcMode"),
  @NamedQuery(name = "FmStation.findByBrdrLat", query = "SELECT f FROM FmStation f WHERE f.brdrLat = :brdrLat"),
  @NamedQuery(name = "FmStation.findByBrdrLong", query = "SELECT f FROM FmStation f WHERE f.brdrLong = :brdrLong"),
  @NamedQuery(name = "FmStation.findByBorder", query = "SELECT f FROM FmStation f WHERE f.border = :border"),
  @NamedQuery(name = "FmStation.findByCanLand", query = "SELECT f FROM FmStation f WHERE f.canLand = :canLand"),
  @NamedQuery(name = "FmStation.findByUsaLand", query = "SELECT f FROM FmStation f WHERE f.usaLand = :usaLand"),
  @NamedQuery(name = "FmStation.findByFreLand", query = "SELECT f FROM FmStation f WHERE f.freLand = :freLand"),
  @NamedQuery(name = "FmStation.findByStCreat", query = "SELECT f FROM FmStation f WHERE f.stCreat = :stCreat"),
  @NamedQuery(name = "FmStation.findByStMod", query = "SELECT f FROM FmStation f WHERE f.stMod = :stMod"),
  @NamedQuery(name = "FmStation.findByOkDump", query = "SELECT f FROM FmStation f WHERE f.okDump = :okDump"),
  @NamedQuery(name = "FmStation.findByDocFile", query = "SELECT f FROM FmStation f WHERE f.docFile = :docFile"),
  @NamedQuery(name = "FmStation.findByDecNumber", query = "SELECT f FROM FmStation f WHERE f.decNumber = :decNumber"),
  @NamedQuery(name = "FmStation.findByUnattended", query = "SELECT f FROM FmStation f WHERE f.unattended = :unattended"),
  @NamedQuery(name = "FmStation.findByCertNumb", query = "SELECT f FROM FmStation f WHERE f.certNumb = :certNumb"),
  @NamedQuery(name = "FmStation.findByScmo", query = "SELECT f FROM FmStation f WHERE f.scmo = :scmo"),
  @NamedQuery(name = "FmStation.findByAutoProg", query = "SELECT f FROM FmStation f WHERE f.autoProg = :autoProg"),
  @NamedQuery(name = "FmStation.findByBeamTilt", query = "SELECT f FROM FmStation f WHERE f.beamTilt = :beamTilt"),
  @NamedQuery(name = "FmStation.findByEhaatt", query = "SELECT f FROM FmStation f WHERE f.ehaatt = :ehaatt"),
  @NamedQuery(name = "FmStation.findByErpvav", query = "SELECT f FROM FmStation f WHERE f.erpvav = :erpvav"),
  @NamedQuery(name = "FmStation.findByErpvpk", query = "SELECT f FROM FmStation f WHERE f.erpvpk = :erpvpk"),
  @NamedQuery(name = "FmStation.findByErphav", query = "SELECT f FROM FmStation f WHERE f.erphav = :erphav"),
  @NamedQuery(name = "FmStation.findByErphpk", query = "SELECT f FROM FmStation f WHERE f.erphpk = :erphpk"),
  @NamedQuery(name = "FmStation.findByGroundLev", query = "SELECT f FROM FmStation f WHERE f.groundLev = :groundLev"),
  @NamedQuery(name = "FmStation.findByOverallH", query = "SELECT f FROM FmStation f WHERE f.overallH = :overallH"),
  @NamedQuery(name = "FmStation.findByRadCenter", query = "SELECT f FROM FmStation f WHERE f.radCenter = :radCenter"),
  @NamedQuery(name = "FmStation.findByChannel", query = "SELECT f FROM FmStation f WHERE f.channel = :channel")})
public class FmStation implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected FmStationPK fmStationPK;
  @Column(length = 20)
  @XmlAttribute
  private String city;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(precision = 12)
  @XmlAttribute
  private Float frequency;
  @Column(length = 3)
  @XmlAttribute
  private String clazz;
  @Column(length = 6)
  @XmlAttribute
  private String latitude;
  @Column(length = 7)
  @XmlAttribute
  private String longitude;
  @Column(name = "ss_code", length = 5)
  @XmlAttribute
  private String ssCode;
  @Column(length = 4)
  @XmlAttribute
  private String network;
  @Column(name = "ant_mode", length = 1)
  @XmlAttribute
  private String antMode;
  @Column(name = "bc_mode", length = 1)
  @XmlAttribute
  private String bcMode;
  @Column(name = "brdr_lat", precision = 12)
  @XmlAttribute
  private Float brdrLat;
  @Column(name = "brdr_long", precision = 12)
  @XmlAttribute
  private Float brdrLong;
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
  @Column(name = "st_creat", length = 8)
  @XmlAttribute
  private String stCreat;
  @Column(name = "st_mod", length = 8)
  @XmlAttribute
  private String stMod;
  @Column(name = "ok_dump", length = 8)
  @XmlAttribute
  private String okDump;
  @Column(name = "doc_file")
  @XmlAttribute
  private Integer docFile;
  @Column(name = "dec_number")
  @XmlAttribute
  private Integer decNumber;
  @Column(length = 1)
  @XmlAttribute
  private String unattended;
  @Column(name = "cert_numb", length = 6)
  @XmlAttribute
  private String certNumb;
  @Column(length = 1)
  @XmlAttribute
  private String scmo;
  @Column(name = "auto_prog", length = 1)
  @XmlAttribute
  private String autoProg;
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
  private Float erphav;
  @Column(precision = 12)
  @XmlAttribute
  private Float erphpk;
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

  public FmStation() {
  }

  public FmStation(FmStationPK fmStationPK) {
    this.fmStationPK = fmStationPK;
  }

  public FmStation(String callSign, String banner) {
    this.fmStationPK = new FmStationPK(callSign, banner);
  }

  public FmStationPK getFmStationPK() {
    return fmStationPK;
  }

  public void setFmStationPK(FmStationPK fmStationPK) {
    this.fmStationPK = fmStationPK;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
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

  public String getSsCode() {
    return ssCode;
  }

  public void setSsCode(String ssCode) {
    this.ssCode = ssCode;
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

  public Float getBrdrLat() {
    return brdrLat;
  }

  public void setBrdrLat(Float brdrLat) {
    this.brdrLat = brdrLat;
  }

  public Float getBrdrLong() {
    return brdrLong;
  }

  public void setBrdrLong(Float brdrLong) {
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

  public String getScmo() {
    return scmo;
  }

  public void setScmo(String scmo) {
    this.scmo = scmo;
  }

  public String getAutoProg() {
    return autoProg;
  }

  public void setAutoProg(String autoProg) {
    this.autoProg = autoProg;
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

  public Float getErphav() {
    return erphav;
  }

  public void setErphav(Float erphav) {
    this.erphav = erphav;
  }

  public Float getErphpk() {
    return erphpk;
  }

  public void setErphpk(Float erphpk) {
    this.erphpk = erphpk;
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
    hash += (fmStationPK != null ? fmStationPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof FmStation)) {
      return false;
    }
    FmStation other = (FmStation) object;
    if ((this.fmStationPK == null && other.fmStationPK != null) || (this.fmStationPK != null && !this.fmStationPK.equals(other.fmStationPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.FmStation[ fmStationPK=" + fmStationPK + " ]";
  }
}
