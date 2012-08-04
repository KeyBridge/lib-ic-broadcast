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
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author jesse
 */
@Entity
@Table(name = "ca_station")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "CanadaStation.findAll", query = "SELECT c FROM CanadaStation c"),
  @NamedQuery(name = "CanadaStation.findByStationType", query = "SELECT c FROM CanadaStation c WHERE c.stationType = :stationType"),
  @NamedQuery(name = "CanadaStation.findByBanner", query = "SELECT c FROM CanadaStation c WHERE c.canadaStationPK.banner = :banner"),
  @NamedQuery(name = "CanadaStation.findByCallSign", query = "SELECT c FROM CanadaStation c WHERE c.canadaStationPK.callSign = :callSign"),
  @NamedQuery(name = "CanadaStation.findByChannel", query = "SELECT c FROM CanadaStation c WHERE c.channel = :channel")})
public class CanadaStation implements Serializable {

  @XmlTransient
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
  @Column(name = "erpvpk", nullable = false)
  @XmlAttribute(required = true)
  private float erpvpk;
  @Basic(optional = false)
  @Column(name = "haat", nullable = false)
  @XmlAttribute
  private float haat;
  @Basic(optional = false)
  @Column(name = "hagl", nullable = false)
  @XmlAttribute
  private float hagl;
  @Basic(optional = false)
  @Column(name = "latitude", nullable = false)
  @XmlAttribute
  private float latitude;
  @Basic(optional = false)
  @Column(name = "longitude", nullable = false)
  @XmlAttribute
  private float longitude;
  @Column(name = "alloc_zone")
  @XmlAttribute
  private int allocZone;
  @Column(name = "ant_mode")
  @XmlAttribute(required = true)
  private Character antMode;
  @Column(name = "auto_prog", length = 1)
  @XmlAttribute
  private String autoProg;
  @Column(name = "bc_mode")
  @XmlAttribute
  private Character bcMode;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "beam_tilt", precision = 12)
  @XmlAttribute
  private float beamTilt;
  @Column(name = "border", precision = 12)
  @XmlAttribute
  private float border;
  @Column(name = "brdr_lat", length = 6)
  @XmlAttribute
  private String brdrLat;
  @Column(name = "brdr_long", length = 7)
  @XmlAttribute
  private String brdrLong;
  @Column(name = "can_land", precision = 12)
  @XmlAttribute
  private float canLand;
  @Column(name = "cert_numb", length = 6)
  @XmlAttribute
  private String certNumb;
  @Column(name = "city", length = 25)
  @XmlAttribute
  private String city;
  @Column(name = "clazz", length = 2)
  @XmlAttribute
  private String clazz;
  @Column(name = "close_cap")
  @XmlAttribute
  private Character closeCap;
  @Column(name = "dec_number")
  @XmlAttribute
  private int decNumber;
  @Column(name = "doc_file")
  @XmlAttribute
  private int docFile;
  @Column(name = "erpaav", precision = 12)
  @XmlAttribute
  private float erpaav;
  @Column(name = "erpapk", precision = 12)
  @XmlAttribute
  private float erpapk;
  @Column(name = "erpata")
  @XmlAttribute
  private int erpata;
  @Column(name = "erphav", precision = 12)
  @XmlAttribute
  private float erphav;
  @Column(name = "erphpk", precision = 12)
  @XmlAttribute
  private float erphpk;
  @Column(name = "erpvav", precision = 12)
  @XmlAttribute
  private float erpvav;
  @Column(name = "erpvta", precision = 12)
  @XmlAttribute
  private float erpvta;
  @Column(name = "euvalu", precision = 12)
  @XmlAttribute
  private float euvalu;
  @Column(name = "fre_land", precision = 12)
  @XmlAttribute
  private float freLand;
  @Column(name = "frequency", precision = 12)
  @XmlAttribute
  private float frequency;
  @Column(name = "ground_lev", precision = 12)
  @XmlAttribute
  private float groundLev;
  @Column(name = "ifrbn_d", precision = 12)
  @XmlAttribute
  private float ifrbnD;
  @Column(name = "ifrbn_n", precision = 12)
  @XmlAttribute
  private float ifrbnN;
  @Column(name = "latitude2", length = 6)
  @XmlAttribute
  private String latitude2;
  @Column(name = "limit_code", length = 8)
  @XmlAttribute
  private String limitCode;
  @Column(name = "longitude2", length = 7)
  @XmlAttribute
  private String longitude2;
  @Column(name = "network", length = 4)
  @XmlAttribute
  private String network;
  @Column(name = "off_prec")
  @XmlAttribute
  private Character offPrec;
  @Column(name = "offset")
  @XmlAttribute
  private Character offset;
  @Column(name = "ok_dump", length = 8)
  @Temporal(javax.persistence.TemporalType.DATE)
  @XmlAttribute
  private Date okDump;
  @Column(name = "overall_h", precision = 12)
  @XmlAttribute
  private float overallH;
  @Column(name = "par_rms_c", precision = 12)
  @XmlAttribute
  private float parRmsC;
  @Column(name = "par_rms_d", precision = 12)
  @XmlAttribute
  private float parRmsD;
  @Column(name = "par_rms_n", precision = 12)
  @XmlAttribute
  private float parRmsN;
  @Column(name = "powercrit", precision = 12)
  @XmlAttribute
  private float powercrit;
  @Column(name = "powerday", precision = 12)
  @XmlAttribute
  private float powerday;
  @Column(name = "powernight", precision = 12)
  @XmlAttribute
  private float powernight;
  @Column(name = "province", length = 2)
  @XmlAttribute
  private String province;
  @Column(name = "q_crit", precision = 12)
  @XmlAttribute
  private float qCrit;
  @Column(name = "q_day", precision = 12)
  @XmlAttribute
  private float qDay;
  @Column(name = "q_night", precision = 12)
  @XmlAttribute
  private float qNight;
  @Column(name = "rad_center", precision = 12)
  @XmlAttribute
  private float radCenter;
  @Column(name = "scmo")
  @XmlAttribute
  private Character scmo;
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
  @Column(name = "status1", length = 2)
  @XmlAttribute
  private String status1;
  @Column(name = "status2", length = 2)
  @XmlAttribute
  private String status2;
  @Column(name = "unattended")
  @XmlAttribute
  private Character unattended;
  @Column(name = "usa_land", precision = 12)
  @XmlAttribute
  private float usaLand;
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

  //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
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

  public int getAllocZone() {
    return allocZone;
  }

  public void setAllocZone(int allocZone) {
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

  public float getBeamTilt() {
    return beamTilt;
  }

  public void setBeamTilt(float beamTilt) {
    this.beamTilt = beamTilt;
  }

  public float getBorder() {
    return border;
  }

  public void setBorder(float border) {
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

  public float getCanLand() {
    return canLand;
  }

  public void setCanLand(float canLand) {
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

  public float getErpaav() {
    return erpaav;
  }

  public void setErpaav(float erpaav) {
    this.erpaav = erpaav;
  }

  public float getErpapk() {
    return erpapk;
  }

  public void setErpapk(float erpapk) {
    this.erpapk = erpapk;
  }

  public int getErpata() {
    return erpata;
  }

  public void setErpata(int erpata) {
    this.erpata = erpata;
  }

  public float getErphav() {
    return erphav;
  }

  public void setErphav(float erphav) {
    this.erphav = erphav;
  }

  public float getErphpk() {
    return erphpk;
  }

  public void setErphpk(float erphpk) {
    this.erphpk = erphpk;
  }

  public float getErpvav() {
    return erpvav;
  }

  public void setErpvav(float erpvav) {
    this.erpvav = erpvav;
  }

  public float getErpvta() {
    return erpvta;
  }

  public void setErpvta(float erpvta) {
    this.erpvta = erpvta;
  }

  public float getEuvalu() {
    return euvalu;
  }

  public void setEuvalu(float euvalu) {
    this.euvalu = euvalu;
  }

  public float getFreLand() {
    return freLand;
  }

  public void setFreLand(float freLand) {
    this.freLand = freLand;
  }

  public float getFrequency() {
    return frequency;
  }

  public void setFrequency(float frequency) {
    this.frequency = frequency;
  }

  public float getGroundLev() {
    return groundLev;
  }

  public void setGroundLev(float groundLev) {
    this.groundLev = groundLev;
  }

  public float getIfrbnD() {
    return ifrbnD;
  }

  public void setIfrbnD(float ifrbnD) {
    this.ifrbnD = ifrbnD;
  }

  public float getIfrbnN() {
    return ifrbnN;
  }

  public void setIfrbnN(float ifrbnN) {
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

  public Date getOkDump() {
    return okDump;
  }

  public void setOkDump(Date okDump) {
    this.okDump = okDump;
  }

  public float getOverallH() {
    return overallH;
  }

  public void setOverallH(float overallH) {
    this.overallH = overallH;
  }

  public float getParRmsC() {
    return parRmsC;
  }

  public void setParRmsC(float parRmsC) {
    this.parRmsC = parRmsC;
  }

  public float getParRmsD() {
    return parRmsD;
  }

  public void setParRmsD(float parRmsD) {
    this.parRmsD = parRmsD;
  }

  public float getParRmsN() {
    return parRmsN;
  }

  public void setParRmsN(float parRmsN) {
    this.parRmsN = parRmsN;
  }

  public float getPowercrit() {
    return powercrit;
  }

  public void setPowercrit(float powercrit) {
    this.powercrit = powercrit;
  }

  public float getPowerday() {
    return powerday;
  }

  public void setPowerday(float powerday) {
    this.powerday = powerday;
  }

  public float getPowernight() {
    return powernight;
  }

  public void setPowernight(float powernight) {
    this.powernight = powernight;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public float getQCrit() {
    return qCrit;
  }

  public void setQCrit(float qCrit) {
    this.qCrit = qCrit;
  }

  public float getQDay() {
    return qDay;
  }

  public void setQDay(float qDay) {
    this.qDay = qDay;
  }

  public float getQNight() {
    return qNight;
  }

  public void setQNight(float qNight) {
    this.qNight = qNight;
  }

  public float getRadCenter() {
    return radCenter;
  }

  public void setRadCenter(float radCenter) {
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

  public float getUsaLand() {
    return usaLand;
  }

  public void setUsaLand(float usaLand) {
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
  //</editor-fold>

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
