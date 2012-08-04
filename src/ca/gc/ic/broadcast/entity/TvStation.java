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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;
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
@Table(name = "tvstatio")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "TvStation.findAll", query = "SELECT t FROM TvStation t"),
  @NamedQuery(name = "TvStation.findByCallSign", query = "SELECT t FROM TvStation t WHERE t.tvStationPK.callSign = :callSign"),
  @NamedQuery(name = "TvStation.findByNetwork", query = "SELECT t FROM TvStation t WHERE t.network = :network"),
  @NamedQuery(name = "TvStation.findByChannel", query = "SELECT t FROM TvStation t WHERE t.channel = :channel")})
public class TvStation implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected TvStationPK tvStationPK;
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
  @Column(name = "latitude", length = 6)
  @XmlAttribute
  private String latitudeDMS;
  @Column(name = "longitude", length = 7)
  @XmlAttribute
  private String longitudeDMS;
  @Column(name = "limit_code", length = 8)
  @XmlAttribute
  private String limitCode;
  @Column(length = 4)
  @XmlAttribute
  private String network;
  @Column(name = "ant_mode", length = 1)
  @XmlAttribute
  private String antMode;
  @Column(name = "bc_mode", length = 1)
  @XmlAttribute
  private String bcMode;
  @Column(length = 1)
  @XmlAttribute
  private String offset;
  @Column(name = "off_prec", length = 1)
  @XmlAttribute
  private String offPrec;
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
  @Column(name = "close_cap", length = 1)
  @XmlAttribute
  private String closeCap;
  @Column(name = "alloc_zone", precision = 12)
  @XmlAttribute
  private Float allocZone;
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
//  @JoinColumns({    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign"),    @JoinColumn(name = "banner", referencedColumnName = "banner")  })  @OneToOne  private CA_Region caRegion;
//  @JoinColumn(name = "province", referencedColumnName = "province")  @ManyToOne  private CA_Province province;
  @JoinTable(name = "apatstat", joinColumns = {
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign", nullable = false),
    @JoinColumn(name = "banner", referencedColumnName = "banner", nullable = false)}, inverseJoinColumns = {
    @JoinColumn(name = "patt_key", referencedColumnName = "patt_key", nullable = false)})
  @ManyToMany
  private List<Antenna> antennaList;
//  @OneToMany(mappedBy = "tmStation")  private List<ServiceContour> serviceContourList;
//  @OneToMany(mappedBy = "tvStation")  private List<Comment> commentList;
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "tvStation")
  private Tsid tsid;
  //
  // Decimal latitude values set by postLoad
  //
  @Transient
  @XmlAttribute
  private double latitude;
  @Transient
  @XmlAttribute
  private double longitude;

  public TvStation() {
  }

  public TvStation(TvStationPK tvStationPK) {
    this.tvStationPK = tvStationPK;
  }

  public TvStation(String callSign, String banner) {
    this.tvStationPK = new TvStationPK(callSign, banner);
  }

  //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
  public TvStationPK getTvStationPK() {
    return tvStationPK;
  }

  public void setTvStationPK(TvStationPK tvStationPK) {
    this.tvStationPK = tvStationPK;
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

  public String getLatitudeDMS() {
    return latitudeDMS;
  }

  public void setLatitudeDMS(String latitudeDMS) {
    this.latitudeDMS = latitudeDMS;
  }

  public String getLongitudeDMS() {
    return longitudeDMS;
  }

  public void setLongitudeDMS(String longitudeDMS) {
    this.longitudeDMS = longitudeDMS;
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
  }

  public List<Antenna> getAntennaList() {
    return antennaList;
  }

  public void setAntennaList(List<Antenna> antennaList) {
    this.antennaList = antennaList;
  }

  public Tsid getTsid() {
    return tsid;
  }

  public void setTsid(Tsid tsid) {
    this.tsid = tsid;
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
  //</editor-fold>

  @PostLoad
  public void postLoad() {
    /**
     * Set the Latitude
     */
    String latitudePattern = "(\\d\\d)(\\d\\d)(\\d\\d)";

    Pattern p = Pattern.compile(latitudePattern);
    Matcher m = p.matcher(latitudeDMS);
    if (m.find()) {
      latitude = DMStoDEC(Integer.valueOf(m.group(1)),
                          Integer.valueOf(m.group(2)),
                          Integer.valueOf(m.group(3)),
                          "N");
    }
    /**
     * Set the Longitude
     */
    String longitudePattern;
    if (longitudeDMS != null && longitudeDMS.length() == 7) {
      longitudePattern = "(\\d\\d\\d)(\\d\\d)(\\d\\d)";
    } else {
      longitudePattern = "(\\d\\d)(\\d\\d)(\\d\\d)";
    }
    p = Pattern.compile(longitudePattern);
    m = p.matcher(longitudeDMS);
    if (m.find()) {
      longitude = DMStoDEC(Integer.valueOf(m.group(1)),
                           Integer.valueOf(m.group(2)),
                           Integer.valueOf(m.group(3)),
                           "W");
    }
  }

  /**
   * convert DMS to decimal
   * <p/>
   * @param deg param min param direction
   * @return
   */
  private double DMStoDEC(int deg, int min, double sec, String direction) {
    double val = deg + ((double) min + (sec / 60)) / 60;
    double dir = 1;
    if (direction.toUpperCase().contains("S") || direction.toUpperCase().contains("W")) {
      dir = -1;
    }
    return dir * val;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (tvStationPK != null ? tvStationPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TvStation)) {
      return false;
    }
    TvStation other = (TvStation) object;
    if ((this.tvStationPK == null && other.tvStationPK != null) || (this.tvStationPK != null && !this.tvStationPK.equals(other.tvStationPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.TvStation[ tvStationPK=" + tvStationPK + " ]";
  }
}
