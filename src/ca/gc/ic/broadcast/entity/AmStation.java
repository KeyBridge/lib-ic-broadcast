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
@Table(name = "amstatio")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "AmStation.findAll", query = "SELECT a FROM AmStation a"),
  @NamedQuery(name = "AmStation.findByCallSign", query = "SELECT a FROM AmStation a WHERE a.amStationPK.callSign = :callSign"),
  @NamedQuery(name = "AmStation.findByBanner", query = "SELECT a FROM AmStation a WHERE a.amStationPK.banner = :banner"),
  @NamedQuery(name = "AmStation.findByNetwork", query = "SELECT a FROM AmStation a WHERE a.network = :network"),
  @NamedQuery(name = "AmStation.findByChannel", query = "SELECT a FROM AmStation a WHERE a.channel = :channel")})
public class AmStation implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected AmStationPK amStationPK;
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
  @Column(length = 2)
  @XmlAttribute
  private String status1;
  @Column(length = 2)
  @XmlAttribute
  private String status2;
  @Column(length = 6)
  @XmlAttribute
  private String latitudeDMS2;
  @Column(length = 7)
  @XmlAttribute
  private String longitudeDMS2;
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
  @Column(name = "ifrbn_d", precision = 12)
  @XmlAttribute
  private Float ifrbnD;
  @Column(name = "ifrbn_n", precision = 12)
  @XmlAttribute
  private Float ifrbnN;
  @Column(precision = 12)
  @XmlAttribute
  private Float clist1;
  @Column(precision = 12)
  @XmlAttribute
  private Float clist2;
  @Column(precision = 12)
  @XmlAttribute
  private Float clist3;
  @Column(precision = 12)
  @XmlAttribute
  private Float clist4;
  @Column(precision = 12)
  @XmlAttribute
  private Float clist5;
  @Column(precision = 12)
  @XmlAttribute
  private Float clist6;
  @Column(precision = 12)
  @XmlAttribute
  private Float clist7;
  @Column(precision = 12)
  @XmlAttribute
  private Float clist8;
  @Column(precision = 12)
  @XmlAttribute
  private Float clist9;
  @Column(precision = 12)
  @XmlAttribute
  private Float clist10;
  @Column(length = 4)
  @XmlAttribute
  private String network;
  @Column(name = "cert_numb", length = 6)
  @XmlAttribute
  private String certNumb;
  @Column(name = "bc_mode", length = 1)
  @XmlAttribute
  private String bcMode;
  @Column(length = 1)
  @XmlAttribute
  private String unattended;
  @Column(name = "auto_prog", length = 1)
  @XmlAttribute
  private String autoProg;
  @Column(precision = 12)
  @XmlAttribute
  private Float euvalu;
  @Column(precision = 12)
  @XmlAttribute
  private Float powerday;
  @Column(name = "par_rms_d", precision = 12)
  @XmlAttribute
  private Float parRmsD;
  @Column(name = "q_day", precision = 12)
  @XmlAttribute
  private Float qDay;
  @Column(precision = 12)
  @XmlAttribute
  private Float powernight;
  @Column(name = "par_rms_n", precision = 12)
  @XmlAttribute
  private Float parRmsN;
  @Column(name = "q_night", precision = 12)
  @XmlAttribute
  private Float qNight;
  @Column(precision = 12)
  @XmlAttribute
  private Float powercrit;
  @Column(name = "par_rms_c", precision = 12)
  @XmlAttribute
  private Float parRmsC;
  @Column(name = "q_crit", precision = 12)
  @XmlAttribute
  private Float qCrit;
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
  private CA_Province caProvince;
  @JoinTable(name = "apatstat", joinColumns = {
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign"),
    @JoinColumn(name = "banner", referencedColumnName = "banner")}, inverseJoinColumns = {
    @JoinColumn(name = "patt_key", referencedColumnName = "patt_key")})
  @ManyToMany
  private List<Antenna> antennaList;
  @OneToMany(mappedBy = "amStation")
  private List<ServiceContour> serviceContourList;
  @OneToMany(mappedBy = "amStation")
  private List<SignalFeed> signalFeedList;
  @OneToMany(mappedBy = "amStation")
  private List<AmStationExtendedHour> amStationExtendedHourList;
  @OneToMany(mappedBy = "amStation")
  private List<AmStationTower> amStationTowerList;
  @OneToMany(mappedBy = "amStation")
  private List<AmStationAugment> amStationAugmentList;
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

  public AmStation() {
  }

  public AmStation(AmStationPK amStationPK) {
    this.amStationPK = amStationPK;
  }

  public AmStation(String callSign, String banner) {
    this.amStationPK = new AmStationPK(callSign, banner);
  }

  //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
  public AmStationPK getAmStationPK() {
    return amStationPK;
  }

  public void setAmStationPK(AmStationPK amStationPK) {
    this.amStationPK = amStationPK;
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

  public String getLatitudeDMS2() {
    return latitudeDMS2;
  }

  public void setLatitudeDMS2(String latitudeDMS2) {
    this.latitudeDMS2 = latitudeDMS2;
  }

  public String getLongitudeDMS2() {
    return longitudeDMS2;
  }

  public void setLongitudeDMS2(String longitudeDMS2) {
    this.longitudeDMS2 = longitudeDMS2;
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

  public Float getClist1() {
    return clist1;
  }

  public void setClist1(Float clist1) {
    this.clist1 = clist1;
  }

  public Float getClist2() {
    return clist2;
  }

  public void setClist2(Float clist2) {
    this.clist2 = clist2;
  }

  public Float getClist3() {
    return clist3;
  }

  public void setClist3(Float clist3) {
    this.clist3 = clist3;
  }

  public Float getClist4() {
    return clist4;
  }

  public void setClist4(Float clist4) {
    this.clist4 = clist4;
  }

  public Float getClist5() {
    return clist5;
  }

  public void setClist5(Float clist5) {
    this.clist5 = clist5;
  }

  public Float getClist6() {
    return clist6;
  }

  public void setClist6(Float clist6) {
    this.clist6 = clist6;
  }

  public Float getClist7() {
    return clist7;
  }

  public void setClist7(Float clist7) {
    this.clist7 = clist7;
  }

  public Float getClist8() {
    return clist8;
  }

  public void setClist8(Float clist8) {
    this.clist8 = clist8;
  }

  public Float getClist9() {
    return clist9;
  }

  public void setClist9(Float clist9) {
    this.clist9 = clist9;
  }

  public Float getClist10() {
    return clist10;
  }

  public void setClist10(Float clist10) {
    this.clist10 = clist10;
  }

  public String getNetwork() {
    return network;
  }

  public void setNetwork(String network) {
    this.network = network;
  }

  public String getCertNumb() {
    return certNumb;
  }

  public void setCertNumb(String certNumb) {
    this.certNumb = certNumb;
  }

  public String getBcMode() {
    return bcMode;
  }

  public void setBcMode(String bcMode) {
    this.bcMode = bcMode;
  }

  public String getUnattended() {
    return unattended;
  }

  public void setUnattended(String unattended) {
    this.unattended = unattended;
  }

  public String getAutoProg() {
    return autoProg;
  }

  public void setAutoProg(String autoProg) {
    this.autoProg = autoProg;
  }

  public Float getEuvalu() {
    return euvalu;
  }

  public void setEuvalu(Float euvalu) {
    this.euvalu = euvalu;
  }

  public Float getPowerday() {
    return powerday;
  }

  public void setPowerday(Float powerday) {
    this.powerday = powerday;
  }

  public Float getParRmsD() {
    return parRmsD;
  }

  public void setParRmsD(Float parRmsD) {
    this.parRmsD = parRmsD;
  }

  public Float getqDay() {
    return qDay;
  }

  public void setqDay(Float qDay) {
    this.qDay = qDay;
  }

  public Float getPowernight() {
    return powernight;
  }

  public void setPowernight(Float powernight) {
    this.powernight = powernight;
  }

  public Float getParRmsN() {
    return parRmsN;
  }

  public void setParRmsN(Float parRmsN) {
    this.parRmsN = parRmsN;
  }

  public Float getqNight() {
    return qNight;
  }

  public void setqNight(Float qNight) {
    this.qNight = qNight;
  }

  public Float getPowercrit() {
    return powercrit;
  }

  public void setPowercrit(Float powercrit) {
    this.powercrit = powercrit;
  }

  public Float getParRmsC() {
    return parRmsC;
  }

  public void setParRmsC(Float parRmsC) {
    this.parRmsC = parRmsC;
  }

  public Float getqCrit() {
    return qCrit;
  }

  public void setqCrit(Float qCrit) {
    this.qCrit = qCrit;
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

  public CA_Province getCaProvince() {
    return caProvince;
  }

  public void setCaProvince(CA_Province caProvince) {
    this.caProvince = caProvince;
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

  public List<SignalFeed> getSignalFeedList() {
    return signalFeedList;
  }

  public void setSignalFeedList(List<SignalFeed> signalFeedList) {
    this.signalFeedList = signalFeedList;
  }

  public List<AmStationExtendedHour> getAmStationExtendedHourList() {
    return amStationExtendedHourList;
  }

  public void setAmStationExtendedHourList(List<AmStationExtendedHour> amStationExtendedHourList) {
    this.amStationExtendedHourList = amStationExtendedHourList;
  }

  public List<AmStationTower> getAmStationTowerList() {
    return amStationTowerList;
  }

  public void setAmStationTowerList(List<AmStationTower> amStationTowerList) {
    this.amStationTowerList = amStationTowerList;
  }

  public List<AmStationAugment> getAmStationAugmentList() {
    return amStationAugmentList;
  }

  public void setAmStationAugmentList(List<AmStationAugment> amStationAugmentList) {
    this.amStationAugmentList = amStationAugmentList;
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
    hash += (amStationPK != null ? amStationPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof AmStation)) {
      return false;
    }
    AmStation other = (AmStation) object;
    if ((this.amStationPK == null && other.amStationPK != null) || (this.amStationPK != null && !this.amStationPK.equals(other.amStationPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.AmStation[ amStationPK=" + amStationPK + " ]";
  }
}
