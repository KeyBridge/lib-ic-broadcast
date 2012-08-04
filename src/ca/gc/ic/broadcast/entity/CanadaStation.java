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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jesse
 */
@Entity
@Table(name = "ca_station")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "CanadaStation.findAll", query = "SELECT c FROM CanadaStation c"),
  @NamedQuery(name = "CanadaStation.findByStationType", query = "SELECT c FROM CanadaStation c WHERE c.stationType = :stationType"),
  @NamedQuery(name = "CanadaStation.findByBanner", query = "SELECT c FROM CanadaStation c WHERE c.canadaStationPK.banner = :banner"),
  @NamedQuery(name = "CanadaStation.findByCallSign", query = "SELECT c FROM CanadaStation c WHERE c.canadaStationPK.callSign = :callSign"),
  @NamedQuery(name = "CanadaStation.findByChannel", query = "SELECT c FROM CanadaStation c WHERE c.channel = :channel"),
  @NamedQuery(name = "CanadaStation.findByErpvpk", query = "SELECT c FROM CanadaStation c WHERE c.erpvpk = :erpvpk"),
  @NamedQuery(name = "CanadaStation.findByHaat", query = "SELECT c FROM CanadaStation c WHERE c.haat = :haat"),
  @NamedQuery(name = "CanadaStation.findByHagl", query = "SELECT c FROM CanadaStation c WHERE c.hagl = :hagl"),
  @NamedQuery(name = "CanadaStation.findByLatitude", query = "SELECT c FROM CanadaStation c WHERE c.latitude = :latitude"),
  @NamedQuery(name = "CanadaStation.findByLongitude", query = "SELECT c FROM CanadaStation c WHERE c.longitude = :longitude"),
  @NamedQuery(name = "CanadaStation.findByAllocZone", query = "SELECT c FROM CanadaStation c WHERE c.allocZone = :allocZone"),
  @NamedQuery(name = "CanadaStation.findByAntMode", query = "SELECT c FROM CanadaStation c WHERE c.antMode = :antMode"),
  @NamedQuery(name = "CanadaStation.findByAutoProg", query = "SELECT c FROM CanadaStation c WHERE c.autoProg = :autoProg"),
  @NamedQuery(name = "CanadaStation.findByBcMode", query = "SELECT c FROM CanadaStation c WHERE c.bcMode = :bcMode"),
  @NamedQuery(name = "CanadaStation.findByBeamTilt", query = "SELECT c FROM CanadaStation c WHERE c.beamTilt = :beamTilt"),
  @NamedQuery(name = "CanadaStation.findByBorder", query = "SELECT c FROM CanadaStation c WHERE c.border = :border"),
  @NamedQuery(name = "CanadaStation.findByBrdrLat", query = "SELECT c FROM CanadaStation c WHERE c.brdrLat = :brdrLat"),
  @NamedQuery(name = "CanadaStation.findByBrdrLong", query = "SELECT c FROM CanadaStation c WHERE c.brdrLong = :brdrLong"),
  @NamedQuery(name = "CanadaStation.findByCanLand", query = "SELECT c FROM CanadaStation c WHERE c.canLand = :canLand"),
  @NamedQuery(name = "CanadaStation.findByCertNumb", query = "SELECT c FROM CanadaStation c WHERE c.certNumb = :certNumb"),
  @NamedQuery(name = "CanadaStation.findByCity", query = "SELECT c FROM CanadaStation c WHERE c.city = :city"),
  @NamedQuery(name = "CanadaStation.findByClazz", query = "SELECT c FROM CanadaStation c WHERE c.clazz = :clazz"),
  @NamedQuery(name = "CanadaStation.findByCloseCap", query = "SELECT c FROM CanadaStation c WHERE c.closeCap = :closeCap"),
  @NamedQuery(name = "CanadaStation.findByDecNumber", query = "SELECT c FROM CanadaStation c WHERE c.decNumber = :decNumber"),
  @NamedQuery(name = "CanadaStation.findByDocFile", query = "SELECT c FROM CanadaStation c WHERE c.docFile = :docFile"),
  @NamedQuery(name = "CanadaStation.findByErpaav", query = "SELECT c FROM CanadaStation c WHERE c.erpaav = :erpaav"),
  @NamedQuery(name = "CanadaStation.findByErpapk", query = "SELECT c FROM CanadaStation c WHERE c.erpapk = :erpapk"),
  @NamedQuery(name = "CanadaStation.findByErpata", query = "SELECT c FROM CanadaStation c WHERE c.erpata = :erpata"),
  @NamedQuery(name = "CanadaStation.findByErphav", query = "SELECT c FROM CanadaStation c WHERE c.erphav = :erphav"),
  @NamedQuery(name = "CanadaStation.findByErphpk", query = "SELECT c FROM CanadaStation c WHERE c.erphpk = :erphpk"),
  @NamedQuery(name = "CanadaStation.findByErpvav", query = "SELECT c FROM CanadaStation c WHERE c.erpvav = :erpvav"),
  @NamedQuery(name = "CanadaStation.findByErpvta", query = "SELECT c FROM CanadaStation c WHERE c.erpvta = :erpvta"),
  @NamedQuery(name = "CanadaStation.findByEuvalu", query = "SELECT c FROM CanadaStation c WHERE c.euvalu = :euvalu"),
  @NamedQuery(name = "CanadaStation.findByFreLand", query = "SELECT c FROM CanadaStation c WHERE c.freLand = :freLand"),
  @NamedQuery(name = "CanadaStation.findByFrequency", query = "SELECT c FROM CanadaStation c WHERE c.frequency = :frequency"),
  @NamedQuery(name = "CanadaStation.findByGroundLev", query = "SELECT c FROM CanadaStation c WHERE c.groundLev = :groundLev"),
  @NamedQuery(name = "CanadaStation.findByIfrbnD", query = "SELECT c FROM CanadaStation c WHERE c.ifrbnD = :ifrbnD"),
  @NamedQuery(name = "CanadaStation.findByIfrbnN", query = "SELECT c FROM CanadaStation c WHERE c.ifrbnN = :ifrbnN"),
  @NamedQuery(name = "CanadaStation.findByLatitude2", query = "SELECT c FROM CanadaStation c WHERE c.latitude2 = :latitude2"),
  @NamedQuery(name = "CanadaStation.findByLimitCode", query = "SELECT c FROM CanadaStation c WHERE c.limitCode = :limitCode"),
  @NamedQuery(name = "CanadaStation.findByLongitude2", query = "SELECT c FROM CanadaStation c WHERE c.longitude2 = :longitude2"),
  @NamedQuery(name = "CanadaStation.findByNetwork", query = "SELECT c FROM CanadaStation c WHERE c.network = :network"),
  @NamedQuery(name = "CanadaStation.findByOffPrec", query = "SELECT c FROM CanadaStation c WHERE c.offPrec = :offPrec"),
  @NamedQuery(name = "CanadaStation.findByOffset", query = "SELECT c FROM CanadaStation c WHERE c.offset = :offset"),
  @NamedQuery(name = "CanadaStation.findByOkDump", query = "SELECT c FROM CanadaStation c WHERE c.okDump = :okDump"),
  @NamedQuery(name = "CanadaStation.findByParRmsC", query = "SELECT c FROM CanadaStation c WHERE c.parRmsC = :parRmsC"),
  @NamedQuery(name = "CanadaStation.findByParRmsD", query = "SELECT c FROM CanadaStation c WHERE c.parRmsD = :parRmsD"),
  @NamedQuery(name = "CanadaStation.findByParRmsN", query = "SELECT c FROM CanadaStation c WHERE c.parRmsN = :parRmsN"),
  @NamedQuery(name = "CanadaStation.findByPowercrit", query = "SELECT c FROM CanadaStation c WHERE c.powercrit = :powercrit"),
  @NamedQuery(name = "CanadaStation.findByPowerday", query = "SELECT c FROM CanadaStation c WHERE c.powerday = :powerday"),
  @NamedQuery(name = "CanadaStation.findByPowernight", query = "SELECT c FROM CanadaStation c WHERE c.powernight = :powernight"),
  @NamedQuery(name = "CanadaStation.findByProvince", query = "SELECT c FROM CanadaStation c WHERE c.province = :province"),
  @NamedQuery(name = "CanadaStation.findByQCrit", query = "SELECT c FROM CanadaStation c WHERE c.qCrit = :qCrit"),
  @NamedQuery(name = "CanadaStation.findByQDay", query = "SELECT c FROM CanadaStation c WHERE c.qDay = :qDay"),
  @NamedQuery(name = "CanadaStation.findByQNight", query = "SELECT c FROM CanadaStation c WHERE c.qNight = :qNight"),
  @NamedQuery(name = "CanadaStation.findByRadCenter", query = "SELECT c FROM CanadaStation c WHERE c.radCenter = :radCenter"),
  @NamedQuery(name = "CanadaStation.findByScmo", query = "SELECT c FROM CanadaStation c WHERE c.scmo = :scmo"),
  @NamedQuery(name = "CanadaStation.findBySsCode", query = "SELECT c FROM CanadaStation c WHERE c.ssCode = :ssCode"),
  @NamedQuery(name = "CanadaStation.findByStCreat", query = "SELECT c FROM CanadaStation c WHERE c.stCreat = :stCreat"),
  @NamedQuery(name = "CanadaStation.findByStMod", query = "SELECT c FROM CanadaStation c WHERE c.stMod = :stMod"),
  @NamedQuery(name = "CanadaStation.findByStatus1", query = "SELECT c FROM CanadaStation c WHERE c.status1 = :status1"),
  @NamedQuery(name = "CanadaStation.findByStatus2", query = "SELECT c FROM CanadaStation c WHERE c.status2 = :status2"),
  @NamedQuery(name = "CanadaStation.findByUnattended", query = "SELECT c FROM CanadaStation c WHERE c.unattended = :unattended"),
  @NamedQuery(name = "CanadaStation.findByUsaLand", query = "SELECT c FROM CanadaStation c WHERE c.usaLand = :usaLand")})
public class CanadaStation implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected CanadaStationPK canadaStationPK;
  @Basic(optional = false)
  @Column(name = "station_type", nullable = false, length = 4)
  private String stationType;
  @Basic(optional = false)
  @Column(name = "channel", nullable = false)
  private int channel;
  @Basic(optional = false)
  @Column(name = "erpvpk", nullable = false)
  private float erpvpk;
  @Basic(optional = false)
  @Column(name = "haat", nullable = false)
  private float haat;
  @Basic(optional = false)
  @Column(name = "hagl", nullable = false)
  private float hagl;
  @Basic(optional = false)
  @Column(name = "latitude", nullable = false)
  private float latitude;
  @Basic(optional = false)
  @Column(name = "longitude", nullable = false)
  private float longitude;
  @Column(name = "alloc_zone")
  private Integer allocZone;
  @Column(name = "ant_mode")
  private Character antMode;
  @Column(name = "auto_prog", length = 1)
  private String autoProg;
  @Column(name = "bc_mode")
  private Character bcMode;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "beam_tilt", precision = 12)
  private Float beamTilt;
  @Column(name = "border", precision = 12)
  private Float border;
  @Column(name = "brdr_lat", length = 6)
  private String brdrLat;
  @Column(name = "brdr_long", length = 7)
  private String brdrLong;
  @Column(name = "can_land", precision = 12)
  private Float canLand;
  @Column(name = "cert_numb", length = 6)
  private String certNumb;
  @Column(name = "city", length = 25)
  private String city;
  @Column(name = "clazz", length = 2)
  private String clazz;
  @Column(name = "close_cap")
  private Character closeCap;
  @Column(name = "dec_number")
  private Integer decNumber;
  @Column(name = "doc_file")
  private Integer docFile;
  @Column(name = "erpaav", precision = 12)
  private Float erpaav;
  @Column(name = "erpapk", precision = 12)
  private Float erpapk;
  @Column(name = "erpata")
  private Integer erpata;
  @Column(name = "erphav", precision = 12)
  private Float erphav;
  @Column(name = "erphpk", precision = 12)
  private Float erphpk;
  @Column(name = "erpvav", precision = 12)
  private Float erpvav;
  @Column(name = "erpvta", precision = 12)
  private Float erpvta;
  @Column(name = "euvalu", precision = 12)
  private Float euvalu;
  @Column(name = "fre_land", precision = 12)
  private Float freLand;
  @Column(name = "frequency", precision = 12)
  private Float frequency;
  @Column(name = "ground_lev", precision = 12)
  private Float groundLev;
  @Column(name = "ifrbn_d", precision = 12)
  private Float ifrbnD;
  @Column(name = "ifrbn_n", precision = 12)
  private Float ifrbnN;
  @Column(name = "latitude2", length = 6)
  private String latitude2;
  @Column(name = "limit_code", length = 8)
  private String limitCode;
  @Column(name = "longitude2", length = 7)
  private String longitude2;
  @Column(name = "network", length = 4)
  private String network;
  @Column(name = "off_prec")
  private Character offPrec;
  @Column(name = "offset")
  private Character offset;
  @Column(name = "ok_dump", length = 8)
  private String okDump;
  @Column(name = "par_rms_c", precision = 12)
  private Float parRmsC;
  @Column(name = "par_rms_d", precision = 12)
  private Float parRmsD;
  @Column(name = "par_rms_n", precision = 12)
  private Float parRmsN;
  @Column(name = "powercrit", precision = 12)
  private Float powercrit;
  @Column(name = "powerday", precision = 12)
  private Float powerday;
  @Column(name = "powernight", precision = 12)
  private Float powernight;
  @Column(name = "province", length = 2)
  private String province;
  @Column(name = "q_crit", precision = 12)
  private Float qCrit;
  @Column(name = "q_day", precision = 12)
  private Float qDay;
  @Column(name = "q_night", precision = 12)
  private Float qNight;
  @Column(name = "rad_center", precision = 12)
  private Float radCenter;
  @Column(name = "scmo")
  private Character scmo;
  @Column(name = "ss_code", length = 5)
  private String ssCode;
  @Column(name = "st_creat", length = 8)
  private String stCreat;
  @Column(name = "st_mod", length = 8)
  private String stMod;
  @Column(name = "status1", length = 2)
  private String status1;
  @Column(name = "status2", length = 2)
  private String status2;
  @Column(name = "unattended")
  private Character unattended;
  @Column(name = "usa_land", precision = 12)
  private Float usaLand;
  @ManyToMany(mappedBy = "canadaStationList")
  private List<Antenna> antennaList;
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "canadaStation")
  private RegionalFiling regionalFiling;
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "canadaStation")
  private FeedSignal feedSignal;
  @OneToMany(mappedBy = "canadaStation")
  private List<Contour> contourList;
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "canadaStation")
  private AmStationExtendedHours amStationExtendedHours;
  @OneToMany(mappedBy = "canadaStation")
  private List<AmStationParameter> amStationParameterList;
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "canadaStation")
  private Tsid tsid;
  @OneToMany(mappedBy = "canadaStation")
  private List<AmStationAugment> amStationAugmentList;
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "canadaStation")
  private Comment comment;

  public CanadaStation() {
  }

  public CanadaStation(CanadaStationPK canadaStationPK) {
    this.canadaStationPK = canadaStationPK;
  }

  public CanadaStation(CanadaStationPK canadaStationPK, String stationType, int channel, float erpvpk, float haat, float hagl, float latitude, float longitude) {
    this.canadaStationPK = canadaStationPK;
    this.stationType = stationType;
    this.channel = channel;
    this.erpvpk = erpvpk;
    this.haat = haat;
    this.hagl = hagl;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public CanadaStation(String banner, String callSign) {
    this.canadaStationPK = new CanadaStationPK(banner, callSign);
  }

  public CanadaStationPK getCanadaStationPK() {
    return canadaStationPK;
  }

  public void setCanadaStationPK(CanadaStationPK canadaStationPK) {
    this.canadaStationPK = canadaStationPK;
  }

  public String getStationType() {
    return stationType;
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

  public float getErpvpk() {
    return erpvpk;
  }

  public void setErpvpk(float erpvpk) {
    this.erpvpk = erpvpk;
  }

  public float getHaat() {
    return haat;
  }

  public void setHaat(float haat) {
    this.haat = haat;
  }

  public float getHagl() {
    return hagl;
  }

  public void setHagl(float hagl) {
    this.hagl = hagl;
  }

  public float getLatitude() {
    return latitude;
  }

  public void setLatitude(float latitude) {
    this.latitude = latitude;
  }

  public float getLongitude() {
    return longitude;
  }

  public void setLongitude(float longitude) {
    this.longitude = longitude;
  }

  public Integer getAllocZone() {
    return allocZone;
  }

  public void setAllocZone(Integer allocZone) {
    this.allocZone = allocZone;
  }

  public Character getAntMode() {
    return antMode;
  }

  public void setAntMode(Character antMode) {
    this.antMode = antMode;
  }

  public String getAutoProg() {
    return autoProg;
  }

  public void setAutoProg(String autoProg) {
    this.autoProg = autoProg;
  }

  public Character getBcMode() {
    return bcMode;
  }

  public void setBcMode(Character bcMode) {
    this.bcMode = bcMode;
  }

  public Float getBeamTilt() {
    return beamTilt;
  }

  public void setBeamTilt(Float beamTilt) {
    this.beamTilt = beamTilt;
  }

  public Float getBorder() {
    return border;
  }

  public void setBorder(Float border) {
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

  public Float getCanLand() {
    return canLand;
  }

  public void setCanLand(Float canLand) {
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

  public String getClazz() {
    return clazz;
  }

  public void setClazz(String clazz) {
    this.clazz = clazz;
  }

  public Character getCloseCap() {
    return closeCap;
  }

  public void setCloseCap(Character closeCap) {
    this.closeCap = closeCap;
  }

  public Integer getDecNumber() {
    return decNumber;
  }

  public void setDecNumber(Integer decNumber) {
    this.decNumber = decNumber;
  }

  public Integer getDocFile() {
    return docFile;
  }

  public void setDocFile(Integer docFile) {
    this.docFile = docFile;
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

  public Integer getErpata() {
    return erpata;
  }

  public void setErpata(Integer erpata) {
    this.erpata = erpata;
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

  public Float getErpvav() {
    return erpvav;
  }

  public void setErpvav(Float erpvav) {
    this.erpvav = erpvav;
  }

  public Float getErpvta() {
    return erpvta;
  }

  public void setErpvta(Float erpvta) {
    this.erpvta = erpvta;
  }

  public Float getEuvalu() {
    return euvalu;
  }

  public void setEuvalu(Float euvalu) {
    this.euvalu = euvalu;
  }

  public Float getFreLand() {
    return freLand;
  }

  public void setFreLand(Float freLand) {
    this.freLand = freLand;
  }

  public Float getFrequency() {
    return frequency;
  }

  public void setFrequency(Float frequency) {
    this.frequency = frequency;
  }

  public Float getGroundLev() {
    return groundLev;
  }

  public void setGroundLev(Float groundLev) {
    this.groundLev = groundLev;
  }

  public Float getIfrbnD() {
    return ifrbnD;
  }

  public void setIfrbnD(Float ifrbnD) {
    this.ifrbnD = ifrbnD;
  }

  public Float getIfrbnN() {
    return ifrbnN;
  }

  public void setIfrbnN(Float ifrbnN) {
    this.ifrbnN = ifrbnN;
  }

  public String getLatitude2() {
    return latitude2;
  }

  public void setLatitude2(String latitude2) {
    this.latitude2 = latitude2;
  }

  public String getLimitCode() {
    return limitCode;
  }

  public void setLimitCode(String limitCode) {
    this.limitCode = limitCode;
  }

  public String getLongitude2() {
    return longitude2;
  }

  public void setLongitude2(String longitude2) {
    this.longitude2 = longitude2;
  }

  public String getNetwork() {
    return network;
  }

  public void setNetwork(String network) {
    this.network = network;
  }

  public Character getOffPrec() {
    return offPrec;
  }

  public void setOffPrec(Character offPrec) {
    this.offPrec = offPrec;
  }

  public Character getOffset() {
    return offset;
  }

  public void setOffset(Character offset) {
    this.offset = offset;
  }

  public String getOkDump() {
    return okDump;
  }

  public void setOkDump(String okDump) {
    this.okDump = okDump;
  }

  public Float getParRmsC() {
    return parRmsC;
  }

  public void setParRmsC(Float parRmsC) {
    this.parRmsC = parRmsC;
  }

  public Float getParRmsD() {
    return parRmsD;
  }

  public void setParRmsD(Float parRmsD) {
    this.parRmsD = parRmsD;
  }

  public Float getParRmsN() {
    return parRmsN;
  }

  public void setParRmsN(Float parRmsN) {
    this.parRmsN = parRmsN;
  }

  public Float getPowercrit() {
    return powercrit;
  }

  public void setPowercrit(Float powercrit) {
    this.powercrit = powercrit;
  }

  public Float getPowerday() {
    return powerday;
  }

  public void setPowerday(Float powerday) {
    this.powerday = powerday;
  }

  public Float getPowernight() {
    return powernight;
  }

  public void setPowernight(Float powernight) {
    this.powernight = powernight;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public Float getQCrit() {
    return qCrit;
  }

  public void setQCrit(Float qCrit) {
    this.qCrit = qCrit;
  }

  public Float getQDay() {
    return qDay;
  }

  public void setQDay(Float qDay) {
    this.qDay = qDay;
  }

  public Float getQNight() {
    return qNight;
  }

  public void setQNight(Float qNight) {
    this.qNight = qNight;
  }

  public Float getRadCenter() {
    return radCenter;
  }

  public void setRadCenter(Float radCenter) {
    this.radCenter = radCenter;
  }

  public Character getScmo() {
    return scmo;
  }

  public void setScmo(Character scmo) {
    this.scmo = scmo;
  }

  public String getSsCode() {
    return ssCode;
  }

  public void setSsCode(String ssCode) {
    this.ssCode = ssCode;
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

  public String getStatus1() {
    return status1;
  }

  public void setStatus1(String status1) {
    this.status1 = status1;
  }

  public String getStatus2() {
    return status2;
  }

  public void setStatus2(String status2) {
    this.status2 = status2;
  }

  public Character getUnattended() {
    return unattended;
  }

  public void setUnattended(Character unattended) {
    this.unattended = unattended;
  }

  public Float getUsaLand() {
    return usaLand;
  }

  public void setUsaLand(Float usaLand) {
    this.usaLand = usaLand;
  }

  @XmlTransient
  public List<Antenna> getAntennaList() {
    return antennaList;
  }

  public void setAntennaList(List<Antenna> antennaList) {
    this.antennaList = antennaList;
  }

  public RegionalFiling getRegionalFiling() {
    return regionalFiling;
  }

  public void setRegionalFiling(RegionalFiling regionalFiling) {
    this.regionalFiling = regionalFiling;
  }

  public FeedSignal getFeedSignal() {
    return feedSignal;
  }

  public void setFeedSignal(FeedSignal feedSignal) {
    this.feedSignal = feedSignal;
  }

  @XmlTransient
  public List<Contour> getContourList() {
    return contourList;
  }

  public void setContourList(List<Contour> contourList) {
    this.contourList = contourList;
  }

  public AmStationExtendedHours getAmStationExtendedHours() {
    return amStationExtendedHours;
  }

  public void setAmStationExtendedHours(AmStationExtendedHours amStationExtendedHours) {
    this.amStationExtendedHours = amStationExtendedHours;
  }

  @XmlTransient
  public List<AmStationParameter> getAmStationParameterList() {
    return amStationParameterList;
  }

  public void setAmStationParameterList(List<AmStationParameter> amStationParameterList) {
    this.amStationParameterList = amStationParameterList;
  }

  public Tsid getTsid() {
    return tsid;
  }

  public void setTsid(Tsid tsid) {
    this.tsid = tsid;
  }

  @XmlTransient
  public List<AmStationAugment> getAmStationAugmentList() {
    return amStationAugmentList;
  }

  public void setAmStationAugmentList(List<AmStationAugment> amStationAugmentList) {
    this.amStationAugmentList = amStationAugmentList;
  }

  public Comment getComment() {
    return comment;
  }

  public void setComment(Comment comment) {
    this.comment = comment;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (canadaStationPK != null ? canadaStationPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CanadaStation)) {
      return false;
    }
    CanadaStation other = (CanadaStation) object;
    if ((this.canadaStationPK == null && other.canadaStationPK != null) || (this.canadaStationPK != null && !this.canadaStationPK.equals(other.canadaStationPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.CanadaStation[ canadaStationPK=" + canadaStationPK + " ]";
  }

}
