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
@Table(name = "fmstatio")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "FmStation.findAll", query = "SELECT f FROM FmStation f"),
  @NamedQuery(name = "FmStation.findByCallSign", query = "SELECT f FROM FmStation f WHERE f.fmStationPK.callSign = :callSign"),
  @NamedQuery(name = "FmStation.findByNetwork", query = "SELECT f FROM FmStation f WHERE f.network = :network"),
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
  private String latitudeDMS;
  @Column(length = 7)
  @XmlAttribute
  private String longitudeDMS;
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
  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign"),
    @JoinColumn(name = "banner", referencedColumnName = "banner")
  })
  @OneToOne
  private CA_Region caRegion;
  @JoinColumn(name = "province", referencedColumnName = "province")
  @ManyToOne
  private CA_Province province;
  @JoinTable(name = "apatstat", joinColumns = {
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign"),
    @JoinColumn(name = "banner", referencedColumnName = "banner")}, inverseJoinColumns = {
    @JoinColumn(name = "patt_key", referencedColumnName = "patt_key")})
  @ManyToMany
  private List<Antenna> antennaList;
  @OneToMany(mappedBy = "tvStation")
  private List<ServiceContour> serviceContourList;
  @OneToMany(mappedBy = "amStation")
  private List<Comment> commentList;
  //
  // Decimal latitude values set by postLoad
  //
  @Transient
  @XmlAttribute
  private double latitude;
  @Transient
  @XmlAttribute
  private double longitude;

  public FmStation() {
  }

  public FmStation(FmStationPK fmStationPK) {
    this.fmStationPK = fmStationPK;
  }

  public FmStation(String callSign, String banner) {
    this.fmStationPK = new FmStationPK(callSign, banner);
  }

  //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
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

  public CA_Region getCaRegion() {
    return caRegion;
  }

  public void setCaRegion(CA_Region caRegion) {
    this.caRegion = caRegion;
  }

  public CA_Province getProvince() {
    return province;
  }

  public void setProvince(CA_Province province) {
    this.province = province;
  }

  public List<Antenna> getAntennaList() {
    return antennaList;
  }

  public void setAntennaList(List<Antenna> antennaList) {
    this.antennaList = antennaList;
  }

  public List<ServiceContour> getServiceContourList() {
    return serviceContourList;
  }

  public void setServiceContourList(List<ServiceContour> serviceContourList) {
    this.serviceContourList = serviceContourList;
  }

  public List<Comment> getCommentList() {
    return commentList;
  }

  public void setCommentList(List<Comment> commentList) {
    this.commentList = commentList;
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
